package com.example.day04_zuoye.presenter;

import com.example.day04_zuoye.fragment.FindFragment;
import com.example.day04_zuoye.model.MyModel;
import com.example.day04_zuoye.view.MyView;

public class MyPresenter {
    private final MyModel myModel;
    private MyView view;

    public MyPresenter(MyView view) {
        this.view = view;
        myModel = new MyModel();
    }

    public void getClassify() {
        myModel.getClassify(new ResultCallback() {
            @Override
            public void onSuccess(Object bean) {
                view.onSuccess(bean);
            }

            @Override
            public void onFiled(String msg) {
                view.onFiled(msg);
            }
        });
    }

    public void getHotActivity() {
        myModel.getHotActivity(new ResultCallback() {
            @Override
            public void onSuccess(Object bean) {
                view.onSuccess(bean);
            }

            @Override
            public void onFiled(String msg) {
                view.onFiled(msg);
            }
        });
    }

    public void getHotData(String type) {
        myModel.getHot(type, new ResultCallback() {
            @Override
            public void onSuccess(Object bean) {
                view.onSuccess(bean);
            }

            @Override
            public void onFiled(String msg) {
                view.onFiled(msg);
            }
        });
    }
}
