package com.example.swq_tp.presenter;

import com.example.swq_tp.ResultCallBack;
import com.example.swq_tp.bean.Re2Bean;
import com.example.swq_tp.fragment.FaFragment;
import com.example.swq_tp.model.MainModel;
import com.example.swq_tp.view.MainView;

public class MainPresenter {
    private MainView view;
    private final MainModel model;

    public MainPresenter(MainView view) {
        this.view = view;
        model = new MainModel();
    }

    public void getData() {
        model.getData(new ResultCallBack<Re2Bean>() {
            @Override
            public void onSuccess(Re2Bean re2Bean) {
                view.onSuccess(re2Bean);
            }

            @Override
            public void onFail(String msg) {
                view.onFail(msg);
            }
        });
    }
}
