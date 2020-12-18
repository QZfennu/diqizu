package com.example.swq_tp;

public interface ResultCallBack<T> {
    void onSuccess(T t);
    void onFail(String msg);
}
