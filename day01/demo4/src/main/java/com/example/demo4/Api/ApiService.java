package com.example.demo4.Api;

import com.example.demo4.Bean.FXBean;
import com.example.demo4.Bean.MpBean;
import com.example.demo4.Bean.PnBean;
import com.example.demo4.Bean.TextBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    String baseUrla = "http://123.56.232.18:8080/";
    @GET("serverdemo/feeds/queryHotFeedsList?pageCount=12&feedType=pics")
    Observable<PnBean> geta();

    String baseUrkb = "http://123.56.232.18:8080/";
    @GET("serverdemo/feeds/queryHotFeedsList?pageCount=12&feedType=video")
    Observable<MpBean> getb();

    String baseUrlc = "http://123.56.232.18:8080/serverdemo/";
    @GET("feeds/queryHotFeedsList?pageCount=10&feedType=text&feedId=1578920275")
    Observable<TextBean> getc();

    String url="http://123.56.232.18:8080/";
    @GET("serverdemo//tag/queryTagList")
    Observable<FXBean> getData();

}
