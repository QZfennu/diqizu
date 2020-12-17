package com.example.hanxuyi_1;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APISEVERS {

//    http://123.56.232.18:8080/  沙发—图片
////    http://123.56.232.18:8080/serverdemo/feeds/queryHotFeedsList?pageCount=12&feedType=video 沙发—视频
////    http://123.56.232.18:8080/沙发— 文本
    //http://123.56.232.18:8080/serverdemo/feeds/queryHotFeedsList?pageCount=10&feedType=text&feedId=1578920275
////    http://123.56.232.18:8080/        发现—推荐
   // http://123.56.232.18:8080/
    String BASE_URL = "http://123.56.232.18:8080/";
    @GET("serverdemo/feeds/queryHotFeedsList")
    Observable<ImageBeans> getImage(@Query("pageCount") int page, @Query("feedType") String pisc);
    @GET("serverdemo/feeds/queryHotFeedsList")
    Observable<ShipinBeans>getshipin(@Query("pagecount")int page,@Query("feedType")String video);
    @GET("serverdemo/feeds/queryHotFeedsList?pageCount=10&feedType=text&feedId=1578920275")
    Observable<WebBeans>getweb(@Query("pageCount")int page,@Query("feedType")String text,@Query("feedId")int id);
    @GET("serverdemo//tag/queryTagList")
    Observable<GreenBeans> getgreen();
}
