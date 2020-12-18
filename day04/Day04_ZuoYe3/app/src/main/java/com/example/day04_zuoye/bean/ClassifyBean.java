package com.example.day04_zuoye.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ClassifyBean {

    /**
     * status : {"statusCode":100,"message":"请求成功！","serverTime":"2020-08-04 16:34:00"}
     * data : [{"name":"热点","sort":4,"keyword":"汉服，抗击肺炎，肺炎科普","type":1},{"name":"妆造","sort":3,"keyword":"妆造","type":2},{"name":"图赏","sort":2,"keyword":"汉服图赏","type":3},{"name":"百科","sort":1,"keyword":"汉服百科，汉服知识，汉服科普","type":4}]
     */

    @SerializedName("status")
    private StatusDTO status;
    @SerializedName("data")
    private List<DataDTO> data;

    public StatusDTO getStatus() {
        return status;
    }

    public void setStatus(StatusDTO status) {
        this.status = status;
    }

    public List<DataDTO> getData() {
        return data;
    }

    public void setData(List<DataDTO> data) {
        this.data = data;
    }

    public static class StatusDTO {
        /**
         * statusCode : 100
         * message : 请求成功！
         * serverTime : 2020-08-04 16:34:00
         */

        @SerializedName("statusCode")
        private int statusCode;
        @SerializedName("message")
        private String message;
        @SerializedName("serverTime")
        private String serverTime;

        public int getStatusCode() {
            return statusCode;
        }

        public void setStatusCode(int statusCode) {
            this.statusCode = statusCode;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getServerTime() {
            return serverTime;
        }

        public void setServerTime(String serverTime) {
            this.serverTime = serverTime;
        }
    }

    public static class DataDTO {
        /**
         * name : 热点
         * sort : 4
         * keyword : 汉服，抗击肺炎，肺炎科普
         * type : 1
         */

        @SerializedName("name")
        private String name;
        @SerializedName("sort")
        private int sort;
        @SerializedName("keyword")
        private String keyword;
        @SerializedName("type")
        private int type;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public String getKeyword() {
            return keyword;
        }

        public void setKeyword(String keyword) {
            this.keyword = keyword;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }
}
