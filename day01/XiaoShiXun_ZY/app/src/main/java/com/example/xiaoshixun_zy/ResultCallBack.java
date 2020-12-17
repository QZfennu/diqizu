package com.example.xiaoshixun_zy;

public interface ResultCallBack<T> {
    void onSuccess(T t);
    void onFail(String msg);
}
