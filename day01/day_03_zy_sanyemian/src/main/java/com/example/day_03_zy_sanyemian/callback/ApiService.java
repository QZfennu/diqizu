package com.example.day_03_zy_sanyemian.callback;

import com.example.day_03_zy_sanyemian.model.bean.DataBean;
import com.example.day_03_zy_sanyemian.model.bean.MainDataFax;
import com.example.day_03_zy_sanyemian.model.bean.MainDataText;
import com.example.day_03_zy_sanyemian.model.bean.MainDataVideo;
import com.example.day_03_zy_sanyemian.model.bean.MainImgDataBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {

//    http://123.56.232.18:8080/serverdemo/feeds/queryHotFeedsList?pageCount=12&feedType=pics  沙发—图片
//    http://123.56.232.18:8080/serverdemo/feeds/queryHotFeedsList?pageCount=12&feedType=video 沙发—视频
//    http://123.56.232.18:8080/serverdemo/feeds/queryHotFeedsList?pageCount=10&feedType=text&feedId=1578920275沙发— 文本
//    http://123.56.232.18:8080/serverdemo//tag/queryTagList          发现—推荐

    String BACK_URL = "http://123.56.232.18:8080/";

    @GET("serverdemo/feeds/queryHotFeedsList?pageCount=12&feedType=pics")
    Observable<MainImgDataBean> getDataImg();

    @GET("serverdemo/feeds/queryHotFeedsList?pageCount=12&feedType=video")
    Observable<MainDataVideo> getDataVideo();

    @GET("serverdemo/feeds/queryHotFeedsList?pageCount=10&feedType=text&feedId=1578920275")
    Observable<MainDataText> getDatatext();
//http://123.56.232.18:8080/serverdemo//tag/queryTagList
    @GET("serverdemo//tag/queryTagList")
    Observable<MainDataFax> getDatauser();
}
