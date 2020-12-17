package com.example.hanxuyi_1;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Moudel {

    public void getlist(final CallBACK back) {
        new Retrofit.Builder().baseUrl(APISEVERS.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build().create(APISEVERS.class)
                .getImage(12,"pics").subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<ImageBeans>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ImageBeans value) {

                back.getObjece(value);
            }

            @Override
            public void onError(Throwable e) {
                back.getExction(e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });

    }
}
