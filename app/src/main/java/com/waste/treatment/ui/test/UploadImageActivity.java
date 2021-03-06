package com.waste.treatment.ui.test;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.bumptech.glide.Glide;
import com.waste.treatment.R;
import com.waste.treatment.WasteTreatmentApplication;
import com.waste.treatment.bean.Success;
import com.waste.treatment.databinding.ActivityUploadImageBinding;
import com.waste.treatment.http.HttpClient;
import com.wildma.pictureselector.PictureSelector;

import java.io.File;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class UploadImageActivity extends AppCompatActivity {
    private ActivityUploadImageBinding imageBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        imageBinding = DataBindingUtil.setContentView(this,R.layout.activity_upload_image);
        imageBinding.paizhao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PictureSelector.create(UploadImageActivity.this, PictureSelector.SELECT_REQUEST_CODE).selectPicture(false, 200, 200, 1, 1);

            }
        });


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PictureSelector.SELECT_REQUEST_CODE) {
            if (data != null) {
                String picturePath = data.getStringExtra(PictureSelector.PICTURE_PATH);
                Glide.with(this).load(picturePath).into(imageBinding.imageView);
                uploadImg(picturePath);

            }
        }
    }
    private void uploadImg(String file1Location ){
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
        MultipartBody.Part parts =MultipartBody.Part.createFormData("uploadfile", file.getName(), imageBody);

        HttpClient.getInstance().geData1().uploadImage(parts,"1")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Success>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(WasteTreatmentApplication.TAG, "UpImage  onSubscribe: "+d.toString());

                    }

                    @Override
                    public void onNext(Success s) {
                        Log.d(WasteTreatmentApplication.TAG, "UpImage onNext: "+s);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(WasteTreatmentApplication.TAG, "UpImage onError: "+e.toString());

                    }

                    @Override
                    public void onComplete() {
                        Log.d(WasteTreatmentApplication.TAG, "onComplete: ");

                    }
                });
    }

}
