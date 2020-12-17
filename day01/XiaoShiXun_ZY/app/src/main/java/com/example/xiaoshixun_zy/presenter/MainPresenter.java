package com.example.xiaoshixun_zy.presenter;

import com.example.xiaoshixun_zy.ResultCallBack;
import com.example.xiaoshixun_zy.bean.ItemBean;
import com.example.xiaoshixun_zy.fragment.ItemFragmenr;
import com.example.xiaoshixun_zy.model.MainModel;
import com.example.xiaoshixun_zy.view.MainView;

public class MainPresenter {
    private MainView view;
    private final MainModel model;

    public MainPresenter(MainView view) {
        this.view = view;
        model = new MainModel();
    }

    public void getData() {
        model.getData(new ResultCallBack<ItemBean>() {
            @Override
            public void onSuccess(ItemBean itemBean) {
                view.onSuccess(itemBean);
            }

            @Override
            public void onFail(String msg) {
                view.onFail(msg);
            }
        });
    }
}
