package com.example.day_03_zy_sanyemian.model;

import android.util.Log;

import com.example.day_03_zy_sanyemian.callback.ApiService;
import com.example.day_03_zy_sanyemian.model.bean.MainDataVideo;
import com.example.day_03_zy_sanyemian.callback.callbackdatavideo;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Mmodel {
    public void getDatavieods(callbackdatavideo callbackdatavideo) {
        new Retrofit.Builder()
                .baseUrl(ApiService.BACK_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class)
                .getDataVideo()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MainDataVideo>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MainDataVideo mainDataVideo) {
                        callbackdatavideo.callbackvoido(mainDataVideo);
                        Log.i("TAG", "视频请求成功 ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("TAG", "视频请求失败："+e.getMessage());

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
