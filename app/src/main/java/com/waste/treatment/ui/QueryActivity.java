package com.waste.treatment.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.database.DatabaseUtils;
import android.device.ScanDevice;
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
import android.view.View;
import android.view.Window;

import com.baidu.mapapi.map.BaiduMapOptions;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.Overlay;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.map.PolylineOptions;
import com.baidu.mapapi.model.LatLng;
import com.waste.treatment.R;
import com.waste.treatment.WasteTreatmentApplication;
import com.waste.treatment.bean.Data1Bean;
import com.waste.treatment.bean.Data2Bean;
import com.waste.treatment.bean.GetPosBean;
import com.waste.treatment.databinding.ActivityQueryBinding;
import com.waste.treatment.http.HttpClient;
import com.waste.treatment.util.Tips;
import com.waste.treatment.util.Utils;

import java.util.ArrayList;
import java.util.List;

import cn.pda.serialport.SerialDriver;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class QueryActivity extends AppCompatActivity {
    private ActivityQueryBinding mBinding;
    ScanDevice sm;
    private final static String SCAN_ACTION = "scan.rcv.message";
    private String barcodeStr;
    private MapView mapView;
    private Overlay mPolyline;
    private IPosApi mPosApi;


    private String danwei;
    private String types;
    private String chepai;
    private String zhongliang;
    private String siji;
    private String shoujiren;
    private String time;
    private String code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        Utils.makeStatusBarTransparent(this);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//??????
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_query);
        Bundle bundle = getIntent().getExtras();
        String code1 = bundle.getString("code");
        assert code1 != null;
        if (!code1.equals("")){
            showData(code1);
            getPos(code1);

        }
        mBinding.llMap.setVisibility(View.INVISIBLE);
        sm = new ScanDevice();
        sm.setOutScanMode(0);//????????????????????????
        sm.openScan();

        initPos();
        initBaiDuMap();

        mBinding.tvRightText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mBinding.edtCode.getText().toString().trim().isEmpty()) {
                    Tips.show("???????????????????????????");
                } else {
                    if (mBinding.edtCode.getText().toString().trim().length() < 14) {
                        Tips.show("?????????14???");
                    } else {
                        showData(mBinding.edtCode.getText().toString().trim());
                        getPos(mBinding.edtCode.getText().toString().trim());

                    }

                }
            }
        });
        mBinding.ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mBinding.printBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                print(danwei,types,chepai,zhongliang,siji,shoujiren,time,code);
            }
        });
    }

    private BroadcastReceiver mScanReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {

            byte[] barocode = intent.getByteArrayExtra("barocode");
            int barocodelen = intent.getIntExtra("length", 0);
            byte temp = intent.getByteExtra("barcodeType", (byte) 0);
            byte[] aimid = intent.getByteArrayExtra("aimid");
            barcodeStr = new String(barocode, 0, barocodelen);
            mBinding.edtCode.setText(barcodeStr);
            showData(mBinding.edtCode.getText().toString().trim());
            getPos(mBinding.edtCode.getText().toString().trim());
            sm.stopScan();
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter filter = new IntentFilter();
        filter.addAction(SCAN_ACTION);
        registerReceiver(mScanReceiver, filter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(mScanReceiver);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
       /* if (sm != null) {
            sm.stopScan();
            sm.setScanLaserMode(8);
            sm.closeScan();
        }*/
    }

    private void showData(String recyleCode) {
        HttpClient.getInstance().geData().getRecyleByCode(recyleCode)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Data2Bean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Data2Bean data2Bean) {
                        if (data2Bean.getIsSuccess()) {
                            danwei = data2Bean.getContent().getCompany().getName();
                            types = data2Bean.getContent().getName();
                            chepai = data2Bean.getContent().getRouteId().getCarId().getName();
                            zhongliang = data2Bean.getContent().getWeight().toString();
                            time = Utils.timeToTime1(data2Bean.getContent().getRecyleTime());
                            siji = data2Bean.getContent().getRouteId().getDriver().getChineseName();
                            shoujiren = data2Bean.getContent().getRouteId().getDriver().getChineseName();
                            code = data2Bean.getContent().getCode();


                            Log.d(WasteTreatmentApplication.TAG, "onNext: " + data2Bean.toString());

                            Log.d(WasteTreatmentApplication.TAG, "onNext: " + data2Bean.getContent().toString());
                            mBinding.tvGsmc.setText(data2Bean.getContent().getCompany().getName());
                            mBinding.tvFwbm.setText(data2Bean.getContent().getCode());
                            mBinding.tvFwlx.setText(data2Bean.getContent().getName());
                            mBinding.tvFwzl.setText(data2Bean.getContent().getWeight().toString());
                            mBinding.tvSjsj.setText(Utils.timeToTime1(data2Bean.getContent().getRecyleTime()));
                            mBinding.tvYscp.setText(data2Bean.getContent().getRouteId().getCarId().getName());
                            mBinding.tvYssj.setText(data2Bean.getContent().getRouteId().getDriver().getChineseName());
                            mBinding.tvSjr.setText(data2Bean.getContent().getRouteId().getBeginOperator().getChineseName());
                            mBinding.printBtn.setVisibility(View.VISIBLE);

                        } else {
                            Log.d(WasteTreatmentApplication.TAG, "onNext:error ");
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(WasteTreatmentApplication.TAG, "onError: " + e.toString());

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    private void getPos(String code) {

        HttpClient.getInstance().geData().getPos(code)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetPosBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetPosBean getPosBean) {
                        Log.d(WasteTreatmentApplication.TAG, "getPosBean: " + getPosBean.toString());
                        //?????????????????????
                        List<LatLng> points = new ArrayList<LatLng>();
                        for (int i = 0; i < getPosBean.getContent().getPos().size(); i++) {
                            LatLng p = new LatLng(getPosBean.getContent().getPos().get(i).getX(), getPosBean.getContent().getPos().get(i).getY());
                            points.add(p);
                        }
                        if (points.size() > 2) {
                            showMap(points);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }

    private void initBaiDuMap() {
        BaiduMapOptions bOptions = new BaiduMapOptions();
        bOptions.zoomControlsEnabled(false); //??????????????????
        // bOptions.mapType(BaiduMap.M); //????????????
        bOptions.scrollGesturesEnabled(true); //????????????
        bOptions.compassEnabled(true);
        mapView = new MapView(this, bOptions);
        mBinding.llMap.addView(mapView);

        mapView.getMap().setMyLocationEnabled(true);
        MyLocationConfiguration myLocationConfiguration = new MyLocationConfiguration(MyLocationConfiguration.LocationMode.FOLLOWING, true, null, 0xAAFFFF88, 0xAA00FF00);
        mapView.getMap().setMyLocationConfiguration(myLocationConfiguration);
        MapStatus.Builder builder = new MapStatus.Builder();
        builder.zoom(17.0f);
        mapView.getMap().setMapStatus(MapStatusUpdateFactory.newMapStatus(builder.build()));


    }

    private void showMap(List<LatLng> points) {
        if (mPolyline != null) {
            mPolyline.remove();
        }
            /*  LatLng p1 = new LatLng(39.97923, 116.357428);
        LatLng p2 = new LatLng(39.94923, 116.397428);

        points.add(p2);
        points.add(p3);*/

//?????????????????????
        OverlayOptions mOverlayOptions = new PolylineOptions()
                .width(10)
                .color(0xAAFF0000)
                .points(points);
//????????????????????????
//mPloyline ????????????
        mPolyline = mapView.getMap().addOverlay(mOverlayOptions);


        // LatLng cenpt = new LatLng(29.806651, 160.606983);

        MapStatus mMapStatus = new MapStatus.Builder()//??????????????????
                .target(points.get((int) Math.ceil(points.size() / 2)))
                .zoom(13)
                .build();
        MapStatusUpdate mMapStatusUpdate = MapStatusUpdateFactory.newMapStatus(mMapStatus);
        mapView.getMap().setMapStatus(mMapStatusUpdate);//??????????????????
        mBinding.llMap.setVisibility(View.VISIBLE);

     /*   MyLocationData locData = new MyLocationData.Builder()
                // ?????????????????????????????????????????????????????????0-360
                .latitude(points.get((int) Math.ceil(points.size() / 2)).latitude)
                .longitude(points.get((int) Math.ceil(points.size() / 2)).longitude).build();
        mapView.getMap().setMapStatus();*/

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
}
