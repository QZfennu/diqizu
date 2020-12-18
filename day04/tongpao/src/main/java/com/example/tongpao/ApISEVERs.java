package com.example.tongpao;

import com.example.tongpao.beans.Fenlei1Beans;
import com.example.tongpao.beans.FenleidaohangBeans;
import com.example.tongpao.beans.HuodongRecyBeans;
import com.example.tongpao.beans.OneqianBenas;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApISEVERs {
    // /discover/news_1.json
    String BEAS_URL = "http://cdwan.cn:7000/tongpao/";
    @GET("discover/hot_activity.json")   //热门活动
    Observable<HuodongRecyBeans>huodong(); // 热门活动
    @GET("discover/navigation.json")  //分类导航的benas
    Observable<FenleidaohangBeans> getHuodongFenlei();   //
    @GET("discover/news_{page}.json")   //里面的页面
    Observable<Fenlei1Beans>getFenlei(@Query("page")int page);
    @GET("discover/rank_level.json")
    Observable<OneqianBenas> getqiandao();

}
