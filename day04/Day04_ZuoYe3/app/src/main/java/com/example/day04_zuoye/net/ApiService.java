package com.example.day04_zuoye.net;

import com.example.day04_zuoye.bean.ClassifyBean;
import com.example.day04_zuoye.bean.HotActivityBean;
import com.example.day04_zuoye.bean.HotBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    String url = "http://cdwan.cn:7000/tongpao/";

    @GET("discover/navigation.json")
    Flowable<ClassifyBean> getClassify();

    @GET("discover/hot_activity.json")
    Flowable<HotActivityBean> getActivity();

    @GET("discover/news_{type}.json")
    Flowable<HotBean> getHot(@Path("type") String type);
}
