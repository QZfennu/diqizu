package com.example.day3_zuoye.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RecoBean {
    /**
     * status : 200
     * message : 成功
     * data : {"data":[{"id":61,"icon":"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/icon_etpack.png","background":"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/1111.png","activityIcon":"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/51f076f662ef40c99f056a41b130c516.png","title":"2019高光时刻","intro":"2019年那些事,有哪些最让你怀念呢？","feedNum":100,"tagId":1,"enterNum":1000,"followNum":100,"hasFollow":false},{"id":62,"icon":"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/21434249C0E2090713793722702E4487.jpg","background":"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/2222.png","activityIcon":"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/51f076f662ef40c99f056a41b130c516.png","title":"2020新年快乐","intro":"2020年展望未来，许下美好的愿望","feedNum":101,"tagId":2,"enterNum":1001,"followNum":101,"hasFollow":false},{"id":63,"icon":"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/%E5%A4%9A%E5%BD%A9%E5%85%AC%E9%B8%A1.jpg","background":"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/%E5%A4%9A%E5%BD%A9%E5%85%AC%E9%B8%A1.jpg","activityIcon":"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/51f076f662ef40c99f056a41b130c516.png","title":"多彩生活","intro":"多彩生活，由于这只多彩公鸡","feedNum":100,"tagId":3,"enterNum":1000,"followNum":100,"hasFollow":false},{"id":64,"icon":"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/%E8%80%83%E6%8B%89.jpg","background":"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/%E8%80%83%E6%8B%89.jpg","activityIcon":"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/51f076f662ef40c99f056a41b130c516.png","title":"Aukoala","intro":"考拉 作为澳大利亚本土品牌，澳考拉雪地靴由麦克森（Bill.Decksen）于上世纪70年代初创立Decksen公司所有，是澳大利亚人最喜欢的雪地靴品牌之一。","feedNum":100,"tagId":4,"enterNum":1000,"followNum":100,"hasFollow":false},{"id":65,"icon":"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/relaxing-1979674_640.jpg","background":"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/relaxing-1979674_640.jpg","activityIcon":"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/51f076f662ef40c99f056a41b130c516.png","title":"放松时刻","intro":"放松时刻,放松下自己","feedNum":100,"tagId":5,"enterNum":1000,"followNum":100,"hasFollow":false},{"id":66,"icon":"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/music-3507317_640.jpg","background":"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/music-3507317_640.jpg","activityIcon":"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/51f076f662ef40c99f056a41b130c516.png","title":"音乐时刻","intro":"好听的音乐，给到你我","feedNum":100,"tagId":6,"enterNum":1000,"followNum":100,"hasFollow":false},{"id":67,"icon":"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/lol.jpg","background":"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/lol.jpg","activityIcon":"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/51f076f662ef40c99f056a41b130c516.png","title":"王者峡谷","intro":"高能时刻，峡谷精彩瞬间","feedNum":100,"tagId":7,"enterNum":1000,"followNum":100,"hasFollow":false},{"id":68,"icon":"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/geometry-1044090_640.jpg","background":"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/geometry-1044090_640.jpg","activityIcon":"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/51f076f662ef40c99f056a41b130c516.png","title":"百年教育","intro":"百年大计，教育大业","feedNum":100,"tagId":8,"enterNum":1000,"followNum":100,"hasFollow":false},{"id":69,"icon":"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/food-984441_640.jpg","background":"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/food-984441_640.jpg","activityIcon":"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/51f076f662ef40c99f056a41b130c516.png","title":"舌尖上的美食","intro":"舌尖上的美食，纵览让人垂涎三尺的美食","feedNum":100,"tagId":9,"enterNum":1000,"followNum":100,"hasFollow":false},{"id":70,"icon":"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/emotion-2167582_640.jpg","background":"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/emotion-2167582_640.jpg","activityIcon":"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/51f076f662ef40c99f056a41b130c516.png","title":"国宝熊猫","intro":"看起来憨厚，据说当年蚩尤骑着这货打天下","feedNum":100,"tagId":10,"enterNum":1000,"followNum":100,"hasFollow":false}]}
     */

    @SerializedName("status")
    private int status;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private DataDTOX data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataDTOX getData() {
        return data;
    }

    public void setData(DataDTOX data) {
        this.data = data;
    }

    public static class DataDTOX {
        @SerializedName("data")
        private List<DataDTO> data;

        public List<DataDTO> getData() {
            return data;
        }

        public void setData(List<DataDTO> data) {
            this.data = data;
        }


    }
}
