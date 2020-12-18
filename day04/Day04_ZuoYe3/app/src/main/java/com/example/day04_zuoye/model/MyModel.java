package com.example.day04_zuoye.model;

import com.example.day04_zuoye.bean.ClassifyBean;
import com.example.day04_zuoye.bean.HotActivityBean;
import com.example.day04_zuoye.bean.HotBean;
import com.example.day04_zuoye.net.ApiService;
import com.example.day04_zuoye.presenter.ResultCallback;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyModel {
    public void getClassify(final ResultCallback resultCallback) {
        new Retrofit.Builder()
                .baseUrl(ApiService.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class)
                .getClassify()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<ClassifyBean>() {
                    @Override
                    public void onNext(ClassifyBean classifyBean) {
                        resultCallback.onSuccess(classifyBean);
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

    public void getHotActivity(final ResultCallback resultCallback) {
        new Retrofit.Builder()
                .baseUrl(ApiService.url)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService.class)
                .getActivity()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<HotActivityBean>() {
                    @Override
                    public void onNext(HotActivityBean hotActivityBean) {
                        resultCallback.onSuccess(hotActivityBean);
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

    public void getHot(String type, final ResultCallback resultCallback) {
        new Retrofit.Builder()
                .baseUrl(ApiService.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class)
                .getHot(type)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<HotBean>() {
                    @Override
                    public void onNext(HotBean hotBean) {
                        resultCallback.onSuccess(hotBean);
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
