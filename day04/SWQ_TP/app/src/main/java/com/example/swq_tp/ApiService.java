package com.example.swq_tp;

import com.example.swq_tp.bean.Re2Bean;
import com.example.swq_tp.bean.ReBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {

    //http://cdwan.cn:7000/tongpao/discover/hot_activity.json
    // http://cdwan.cn:7000/tongpao/discover/robe.json
    String sUrl = "http://cdwan.cn:7000/";
    @GET("tongpao/discover/hot_activity.json")
    Observable<ReBean> getData();

    @GET("tongpao/discover/robe.json")
    Observable<Re2Bean> getItem();
}
