package com.example.xiaoshixun_zy.view;

import com.example.xiaoshixun_zy.bean.ItemBean;

public interface MainView {
    void onSuccess(ItemBean itemBean);
    void onFail(String msg);
}
