package com.example.day3_zuoye.model;

import android.util.Log;

import com.example.day3_zuoye.bean.SofaImageBean;
import com.example.day3_zuoye.bean.SofaTextBean;
import com.example.day3_zuoye.bean.SofaVideoBean;
import com.example.day3_zuoye.net.ApiService;
import com.example.day3_zuoye.presenter.ResultCallback;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyModel {
    public void getSofaImage(int pagecount, String feed, final ResultCallback resultCallback) {
        Log.i("TAG", "getSofaImage: "+feed+pagecount);
        new Retrofit.Builder()
                .baseUrl(ApiService.sofaImageUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class)
                .getSofaImage(pagecount, feed)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<SofaImageBean>() {
                    @Override
                    public void onNext(SofaImageBean sofaImageBean) {
                        resultCallback.onSuccess(sofaImageBean);
                    }

                    @Override
                    public void onError(Throwable t) {
                        resultCallback.onFiled(t.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void getSofaVideo(int pagecount, String feed, final ResultCallback resultCallback) {
        new Retrofit.Builder()
                .baseUrl(ApiService.sofaImageUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class)
                .getSofaVideo(pagecount, feed)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<SofaVideoBean>() {
                    @Override
                    public void onNext(SofaVideoBean sofaImageBean) {
                        resultCallback.onSuccess(sofaImageBean);
                    }

                    @Override
                    public void onError(Throwable t) {
                        resultCallback.onFiled(t.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    public void getSofaText(int pagecount, String feed, final ResultCallback resultCallback) {
        new Retrofit.Builder()
                .baseUrl(ApiService.sofaImageUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class)
                .getSofaText(pagecount, feed,"1578920275")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<SofaTextBean>() {
                    @Override
                    public void onNext(SofaTextBean sofaImageBean) {
                        Log.i("TAG", "onNext: "+sofaImageBean);
                        resultCallback.onSuccess(sofaImageBean);
                    }

                    @Override
                    public void onError(Throwable t) {
                        resultCallback.onFiled(t.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
