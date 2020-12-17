package com.example.day3_zuoye.net;

import com.example.day3_zuoye.bean.RecoBean;
import com.example.day3_zuoye.bean.SofaImageBean;
import com.example.day3_zuoye.bean.SofaTextBean;
import com.example.day3_zuoye.bean.SofaVideoBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    String sofaImageUrl = "http://123.56.232.18:8080/";

    @GET("serverdemo/feeds/queryHotFeedsList")
    Flowable<SofaImageBean> getSofaImage(@Query("pageCount") int pagecount, @Query("feedType") String feed);

    @GET("serverdemo/feeds/queryHotFeedsList")
    Flowable<SofaVideoBean> getSofaVideo(@Query("pageCount") int pagecount, @Query("feedType") String feed);

    @GET("serverdemo/feeds/queryHotFeedsList")
    Flowable<SofaTextBean> getSofaText(@Query("pageCount") int pagecount, @Query("feedType") String feed, @Query("feedId") String feedid);

    String findUrl = "http://123.56.232.18:8080/";
    @GET("serverdemo//tag/queryTagList")
    Flowable<RecoBean> getReco();
}
