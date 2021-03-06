package com.waste.treatment.ui;


import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.printer.sdk.PosFactory;
import android.printer.sdk.bean.BarCodeBean;
import android.printer.sdk.bean.TextData;
import android.printer.sdk.bean.enums.ALIGN_MODE;
import android.printer.sdk.constant.BarCode;
import android.printer.sdk.interfaces.IPosApi;
import android.printer.sdk.interfaces.OnPrintEventListener;
import android.printer.sdk.util.PowerUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.waste.treatment.R;
import com.waste.treatment.WasteTreatmentApplication;
import com.waste.treatment.bean.GenRecyleBean;
import com.waste.treatment.bean.GetCarsBean;
import com.waste.treatment.bean.GetTypesBean;
import com.waste.treatment.bean.Success;
import com.waste.treatment.databinding.ActivityCollectBinding;
import com.waste.treatment.http.HttpClient;
import com.waste.treatment.util.DialogUtil;
import com.waste.treatment.util.Tips;
import com.waste.treatment.util.Utils;
import com.wildma.pictureselector.PictureSelector;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.pda.serialport.SerialDriver;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class CollectActivity extends BaseActivity<ActivityCollectBinding> implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {
    Map<Integer, Integer> types = new HashMap<>();
    private List<String> typeList;
    private List<Integer> typeListId;
    private boolean getCompanyIsSucceed = false;
    private boolean getTypeSucceed = false;
    private boolean isImage = false;
    private List<String> companys;
    private List<String> mLyings;
    private ArrayAdapter<String> adapter;
    private String company;
    private String Lxing;
    private IPosApi mPosApi;
    private String strTypes = "";
    private ProgressDialog waitingDialog;
    private String filePath = null;


    @Override
    protected int setLayout() {
        return R.layout.activity_collect;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mParentBinding.ilTitle.tvTitle.setText("????????????");
        mParentBinding.ilTitle.ivBack.setVisibility(View.VISIBLE);
        mBinding.spCompany.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                company = Integer.toString(position + 1);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        mBinding.spLx.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Lxing = Integer.toString(position + 1);
                mBinding.llZhongnei.removeAllViews();
                types.clear();
                HttpClient.getInstance().geData().getSubTypes(Lxing)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<GetTypesBean>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(GetTypesBean getTypesBean) {
                                Log.d(WasteTreatmentApplication.TAG, "getTypesBean: " + getTypesBean.toString());
                                typeList = new ArrayList<>();
                                typeListId = new ArrayList<>();
                                if (getTypesBean.getIsSuccess()) {
                                    for (int i = 0; i < getTypesBean.getContent().size(); i++) {
                                        Log.d(WasteTreatmentApplication.TAG, "++++++++++++++++++++++>: "+getTypesBean.getContent().get(i).getName()+"  -"+getTypesBean.getContent().get(i).getIndex());
                                        typeList.add(getTypesBean.getContent().get(i).getName());
                                        typeListId.add(getTypesBean.getContent().get(i).getOid());
                                    }
                                    for (int i = 0; i < typeList.size(); i++) {
                                      /*  CheckBox cb = new CheckBox(CollectActivity.this);
                                        cb.setText(typeList.get(i));
                                        cb.setId(i + 1);
                                        cb.setOnCheckedChangeListener(CollectActivity.this);
                                        mBinding.llZhongnei.addView(cb);*/
                                        addTextView(typeList.get(i),typeListId.get(i));
                                    }
                                    getTypeSucceed = true;
                                    Log.d(WasteTreatmentApplication.TAG, "getTypeSucceed: " + getTypeSucceed);
                                    isShowContentView();
                                } else {
                                    showError();
                                }

                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.d(WasteTreatmentApplication.TAG, "onError2222: " + e.toString());

                            }

                            @Override
                            public void onComplete() {

                            }
                        });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        mBinding.imgBtnPhoto.setOnClickListener(this);
        mBinding.imgBtnDel.setOnClickListener(this);
        mBinding.upDataBtn.setOnClickListener(this);
        initPos();
        getData();

    }

    /**
     * 71      * ??????????????????
     * 72      * @param str
     * 73
     */
    private void addTextView(String str,int i) {
        CheckBox child = new CheckBox(this);
        ViewGroup.MarginLayoutParams params = new ViewGroup.MarginLayoutParams(ViewGroup.MarginLayoutParams.WRAP_CONTENT, ViewGroup.MarginLayoutParams.WRAP_CONTENT);
        params.setMargins(5, 5, 5, 5);
        child.setLayoutParams(params);
        child.setText(str);
        child.setId(i);
        child.setOnCheckedChangeListener(CollectActivity.this);
        mBinding.llZhongnei.addView(child);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        Log.d(WasteTreatmentApplication.TAG, "onCheckedChanged: "+buttonView.getId());
        if (isChecked) {
            types.put(buttonView.getId(), buttonView.getId());
        } else {
            //??????????????????
            types.remove(buttonView.getId());
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PictureSelector.SELECT_REQUEST_CODE) {
            if (data != null) {
                String picturePath = data.getStringExtra(PictureSelector.PICTURE_PATH);
                loadImg(true, picturePath);
                uploadImg(picturePath);
            }
        }
    }

    /**
     * ??????????????????
     *
     * @param bool        true ????????????  false ????????????
     * @param picturePath ??????????????? ???bool???false ??? ???null
     */
    private void loadImg(Boolean bool, String picturePath) {
        if (bool) {
            mBinding.imgBtnDel.setVisibility(View.VISIBLE);
            mBinding.imgBtnPhoto.setVisibility(View.INVISIBLE);
            Glide.with(this).load(picturePath).into(mBinding.imgPhoto);
        } else {
            mBinding.imgBtnDel.setVisibility(View.INVISIBLE);
            mBinding.imgBtnPhoto.setVisibility(View.VISIBLE);
            mBinding.imgPhoto.setImageBitmap(null);
            isImage = false;
        }

    }

    /**
     * ????????????
     */
    private void getData() {

        HttpClient.getInstance().geData().getTypes()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetTypesBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetTypesBean getTypesBean) {

                        Log.d(WasteTreatmentApplication.TAG, "getCarsBean: " + getTypesBean.toString());

                        if (getTypesBean.getIsSuccess()) {
                            mLyings = new ArrayList<>();
                            for (int i = 0; i < getTypesBean.getContent().size(); i++) {
                                mLyings.add(getTypesBean.getContent().get(i).getName());
                            }
                            adapter = new ArrayAdapter<String>(CollectActivity.this, android.R.layout.simple_spinner_item, mLyings);
                            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            mBinding.spLx.setAdapter(adapter);
                            getTypeSucceed = true;
                            isShowContentView();
                            Log.d(WasteTreatmentApplication.TAG, "getCompanyIsSucceed: " + getTypeSucceed + "-------------->" + Lxing);


                        } else {

                            showError();
                        }


                    }

                    @Override
                    public void onError(Throwable e) {
                        showError();
                    }

                    @Override
                    public void onComplete() {

                    }
                });


        HttpClient.getInstance().geData().getCompanys()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetCarsBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetCarsBean getCarsBean) {
                        Log.d(WasteTreatmentApplication.TAG, "getCarsBean: " + getCarsBean.toString());

                        if (getCarsBean.getIsSuccess()) {
                            companys = new ArrayList<>();
                            for (int i = 0; i < getCarsBean.getContent().size(); i++) {
                                companys.add(getCarsBean.getContent().get(i).getName());
                            }
                            adapter = new ArrayAdapter<String>(CollectActivity.this, android.R.layout.simple_spinner_item, companys);
                            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            mBinding.spCompany.setAdapter(adapter);
                            getCompanyIsSucceed = true;
                            Log.d(WasteTreatmentApplication.TAG, "getCompanyIsSucceed: " + getCompanyIsSucceed);
                            isShowContentView();

                        } else {

                            showError();
                        }


                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(WasteTreatmentApplication.TAG, "eComm: " + e.toString());

                        showError();
                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }

    /**
     * ????????????????????? ??????
     */
    private void isShowContentView() {
        if (getCompanyIsSucceed && getTypeSucceed) {
            Log.d(WasteTreatmentApplication.TAG, "getCompanyIsSucceed: " + getCompanyIsSucceed + "  getTypeSucceed: " + getTypeSucceed);
            showContentView();
            if (WasteTreatmentApplication.instance.getRouteId() == null) {
                showDialog();
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_btn_photo:
                PictureSelector.create(CollectActivity.this, PictureSelector.SELECT_REQUEST_CODE).selectPicture(false, 200, 200, 1, 1);
                break;
            case R.id.img_btn_del:
                loadImg(false, null);
                break;
            case R.id.up_data_btn:
                if (isFillOut()) {
                    StringBuilder type = new StringBuilder();
                    strTypes="";
                    for (Map.Entry<Integer, Integer> entry : types.entrySet()) {
                        Log.d(WasteTreatmentApplication.TAG, "strTypes: " + strTypes);
                        strTypes = strTypes + entry.getValue() + "???";
                        type.append(Integer.toString(entry.getValue())).append(";");
                    }
                    if (WasteTreatmentApplication.instance.getRouteId() != null) {


                        Log.d(WasteTreatmentApplication.TAG, "UPDATA: "+type.substring(0, type.length() - 1)+"/"+ mBinding.etZhongliang.getText().toString().trim()+"/"+ WasteTreatmentApplication.instance.getUserId()+"/"+ WasteTreatmentApplication.instance.getRouteId()+"/"+ company+"/"+ filePath);
                        genRecyle(type.substring(0, type.length() - 1), mBinding.etZhongliang.getText().toString().trim(), WasteTreatmentApplication.instance.getUserId(), WasteTreatmentApplication.instance.getRouteId(), company, filePath);
                    } else {
                        Tips.show("????????????????????????????????????????????????");
                    }
                }
                break;
            default:
                break;
        }

    }


    /**
     * ????????????????????????
     *
     * @return true ???????????????
     */
    private boolean isFillOut() {

        if (types.isEmpty()) {
            Toast.makeText(CollectActivity.this, "???????????????", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            if (mBinding.etZhongliang.getText().toString().trim().isEmpty()) {
                Toast.makeText(CollectActivity.this, "???????????????", Toast.LENGTH_SHORT).show();
                // Log.d(WasteTreatmentApplication.TAG, "???????????????");
                return false;
            } else {
                if (isImage) {
                    return true;
                } else {
                    Toast.makeText(CollectActivity.this, "?????????", Toast.LENGTH_SHORT).show();
                    return false;

                }
            }

        }

    }

    /**
     * ????????????
     *
     * @param types      ??????
     * @param weight     ??????
     * @param operatorId ?????????
     * @param routeId    ??????
     * @param companyId  ??????
     */
    private void genRecyle(String types, final String weight, String operatorId, String routeId, final String companyId, String filePath) {
        HttpClient.getInstance().geData().genRecyle(Utils.getIMEI(CollectActivity.this), types, weight, operatorId, routeId, companyId, filePath)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GenRecyleBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GenRecyleBean success) {
                        Log.d(WasteTreatmentApplication.TAG, "success: " + success.getIsSuccess());
                        Log.d(WasteTreatmentApplication.TAG, "content: " + success.getContent());
                        if (success.getIsSuccess()) {
                            //print(companys.get(Integer.parseInt(companyId)-1),strTypes.substring(0, strTypes.length() - 1),WasteTreatmentApplication.instance.getChepai(),weight,WasteTreatmentApplication.instance.getSiji(),WasteTreatmentApplication.instance.getUserName(), Utils.timeToTime(success.getContent().getRecyleTime()),success.getContent().getCode());
                            //print(success.getContent().getCompany().getName(), success.getContent().getName(), success.getContent().getRouteId().getCarId().getName(), success.getContent().getWeight(), success.getContent().getRouteId().getDriver().getChineseName(), success.getContent().getRouteId().getBeginOperator().getChineseName(), Utils.timeToTime(success.getContent().getRecyleTime()), success.getContent().getCode());
                            print(success.getContent().getCompany().getName(), success.getContent().getName(), success.getContent().getRouteId().getCarId().getName(), success.getContent().getWeight(), success.getContent().getRouteId().getDriver().getChineseName(), success.getContent().getRouteId().getBeginOperator().getChineseName(), Utils.timeToTime(success.getContent().getRecyleTime()), success.getContent().getCode());
                            cleanMsg();
                            Tips.show("????????????");
                        } else {
                            Tips.show(success.getErrorMsg());

                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(WasteTreatmentApplication.TAG, "onError: " + e.toString());
                        Tips.show("??????????????????");

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    private void uploadImg(String file1Location) {
        //????????????(????????????????????????????????????)
        //file1Location??????????????? ,?????????????????????????????????????????????????????????,???????????????????????????;
        File file = new File(file1Location);
        //?????????????????????;?????????????????????????????????
        RequestBody imageBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        // RequestBody imageBody1 = RequestBody.create(MediaType.parse("multipart/form-data"), file1);
        //????????????(uploadfile??????????????????????????????????????????)
        // builder.addFormDataPart("uploadfile", file.getName(), imageBody);
        //builder.addFormDataPart("uploadfile1", file1.getName(), imageBody1);
        //?????????????????????list
        MultipartBody.Part parts = MultipartBody.Part.createFormData("uploadfile", file.getName(), imageBody);

        HttpClient.getInstance().geData1().uploadImage(parts, "1") //??????????????????????????????
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Success>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        waitingDialog = DialogUtil.waitingDialog(CollectActivity.this, "????????????????????????????????????");
                        waitingDialog.show();

                    }

                    @Override
                    public void onNext(Success s) {
                        waitingDialog.cancel();

                        if (s.getIsSuccess()) {
                            isImage = true;
                            Tips.show("???????????????");
                            filePath = s.getContent();
                        } else {
                            Tips.show("?????????");

                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        waitingDialog.cancel();
                        Log.d(WasteTreatmentApplication.TAG, "????????????onError: " + e.toString());
                        Tips.show("???????????????");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    /**
     * ???????????? ????????????
     */
    @SuppressLint("ResourceType")
    public void cleanMsg() {
        for (int i = 0; i < typeListId.size(); i++) {
            CheckBox cb = mBinding.llZhongnei.findViewById(typeListId.get(i));
            cb.setChecked(false);
        }
        mBinding.etZhongliang.setText("");
        strTypes = "";
        filePath = null;
        loadImg(false, null);
    }

    public void initPos() {
        PowerUtils.powerOnOrOff(1, "1");
        PosFactory.registerCommunicateDriver(this, new SerialDriver()); // ??????????????? Register serial driver
        mPosApi = PosFactory.getPosDevice(); // ????????????????????? get printer driver
        mPosApi.setPrintEventListener(onPrintEventListener);
        mPosApi.openDev("/dev/ttyS2", 115200, 0);
        mPosApi.setPos()  //???????????????
                .setAutoEnableMark(true)//????????????
                .setEncode(-1)  //????????????  1 ???UNICODE??????  2???UFT-8?????? 3 ??? CODEPAGE ?????? ??????-1
                .setLanguage(15) // 0 ????????? 15???????????? 39 ???????????? 21 ??????  ??????-1
                .setPrintSpeed(-1) //  ??????????????????
                .setMarkDistance(-1) //??????????????????????????????
                .init();// ?????????????????? init printer

        //mPosApi.addFeedPaper(true,60); //???????????????   ??????956mm
        Log.d(WasteTreatmentApplication.TAG, "initPos: ");
    }

    private void print(String danwei, String types, String chepai, String zhongliang, String siji, String shoujiren, String time, String code) {
        TextData textData1 = new TextData();
        textData1.addConcentration(25);
        textData1.addFont(BarCode.FONT_ASCII_12x24);
        textData1.addTextAlign(BarCode.ALIGN_LEFT);
        textData1.addFontSize(BarCode.NORMAL);
        textData1.addText("?????????" + danwei);
        textData1.addText("\n");
               /* textData1.addText("?????????2020031900000039");
                textData1.addText("\n");*/
        textData1.addText("?????????" + types);
        textData1.addText("\n");
        textData1.addText("?????????" + chepai + "  ?????????" + zhongliang + "Kg");
        textData1.addText("\n");
        textData1.addText("?????????" + siji + "  ????????????" + shoujiren);
        textData1.addText("\n");
        textData1.addText("?????????" + time);
        mPosApi.addText(textData1);
        BarCodeBean barCodeBean = new BarCodeBean();
        barCodeBean.setConcentration(25);
        barCodeBean.setHeight(60);
        barCodeBean.setWidth(2);// ????????????1-4; Width value 1 2 3 4
        barCodeBean.setText(code);
        barCodeBean.setBarType(BarCode.CODE128);
        mPosApi.addBarCode(barCodeBean, ALIGN_MODE.ALIGN_CENTER);
        mPosApi.addMark();
        //  mPosApi.addFeedPaper(true, 2);
        mPosApi.printStart();


    }

    public OnPrintEventListener onPrintEventListener = new OnPrintEventListener() {
        @Override
        public void onPrintState(int state) {
            switch (state) {
                case BarCode.ERR_POS_PRINT_SUCC:
                    Tips.show("????????????");
                    //showToastShort (getString (R.string.toast_print_success));
                    break;
                case BarCode.ERR_POS_PRINT_FAILED:
                    Tips.show("????????????");
                    //  showToastShort (getString (R.string.toast_print_error));
                    break;
                case BarCode.ERR_POS_PRINT_HIGH_TEMPERATURE:
                    Tips.show("????????????");
                    // showToastShort (getString (R.string.toast_high_temperature));
                    break;
                case BarCode.ERR_POS_PRINT_NO_PAPER:
                    Tips.show("????????????");
                    //showToastShort (getString (R.string.toast_no_paper));
                    break;
                case 4:
                    break;
            }
        }
    };

    //??????dialog
    private void showDialog() {
        final Dialog dialog = new android.app.AlertDialog.Builder(CollectActivity.this).create();
        dialog.setCancelable(false);
        View v = LayoutInflater.from(CollectActivity.this).inflate(R.layout.dialog_permissions, null);
        TextView tv = v.findViewById(R.id.tv_hint);
        tv.setText("???????????????????????????");
        Button btn_add = v.findViewById(R.id.btn_add);
        Button btn_diss = v.findViewById(R.id.btn_diss);
        btn_add.setText("?????????");
        dialog.show();
        dialog.setContentView(v);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                startActivity(new Intent(CollectActivity.this, RouteActivity.class));
            }
        });

        btn_diss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                CollectActivity.this.finish();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPosApi.closeDev();
        // mPosApi.closePos();
        // printer.Close();
    }
}
