package com.example.xiaoshixun_zy;

import com.example.xiaoshixun_zy.bean.Item2Bean;
import com.example.xiaoshixun_zy.bean.ItemBean;
import com.example.xiaoshixun_zy.bean.PlayBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {

   // http://123.56.232.18:8080/serverdemo/feeds/queryHotFeedsList?pageCount=12&feedType=pics  沙发—图片
   // http://123.56.232.18:8080/serverdemo/feeds/queryHotFeedsList?pageCount=12&feedType=video 沙发—视频
   // http://123.56.232.18:8080/serverdemo/feeds/queryHotFeedsList?pageCount=10&feedType=text&feedId=1578920275沙发— 文本
   // http://123.56.232.18:8080/serverdemo//tag/queryTagList

    String sUrl = "http://123.56.232.18:8080/serverdemo/";
    @GET("feeds/queryHotFeedsList?pageCount=12&feedType=pics")
    Observable<ItemBean> getItem();

    @GET("feeds/queryHotFeedsList?pageCount=12&feedType=video")
    Observable<PlayBean> getPlay();

    @GET("feeds/queryHotFeedsList?pageCount=10&feedType=text&feedId=1578920275")
    Observable<Item2Bean> getItem2();
}
