package com.example.day3_zuoye.presenter;

import android.util.Log;

import com.example.day3_zuoye.fragment.sofafragment.ImageFragment;
import com.example.day3_zuoye.model.MyModel;
import com.example.day3_zuoye.view.MyView;

public class MyPresenter {
    private final MyModel myModel;
    private MyView view;

    public MyPresenter(MyView view) {
        this.view = view;
        myModel = new MyModel();
    }

    public void getSofaImage(int pagecount, String feed) {
        Log.i("TAG", "getSofaImage: "+feed);
        myModel.getSofaImage(pagecount,feed,new ResultCallback() {
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

    public void getSofaVideo(int pagecount, String feed) {
        myModel.getSofaVideo(pagecount,feed,new ResultCallback() {
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

    public void getSofaText(int pagecount, String feed) {
        Log.i("TAG", "getSofaText: "+feed);
        myModel.getSofaText(pagecount,feed,new ResultCallback() {
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
