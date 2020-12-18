package com.example.mengshiyun1;

import com.example.mengshiyun1.Bean.FindBean;
import com.example.mengshiyun1.Bean.LevelBean;
import com.example.mengshiyun1.Bean.MoneyBean;
import com.example.mengshiyun1.Bean.SignBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    public static final String BASE_URL="http://cdwan.cn:7000/tongpao/";
    @GET("discover/hot_activity.json")
    Observable<FindBean> getFind();
    @GET("discover/rank_level.json")
    Observable<LevelBean> getLevel();
    @GET("discover/rank_sign.json")
    Observable<SignBean> getSign();
    @GET("discover/rank_money.json")
    Observable<MoneyBean> getMoney();
}
