package com.example.myapplication.presenter;

import com.example.myapplication.bean.PiceBean;
import com.example.myapplication.bean.TagBean;
import com.example.myapplication.bean.TextBean;
import com.example.myapplication.bean.VoidBean;
import com.example.myapplication.model.MyModel;
import com.example.myapplication.view.MyView;

public class MyPresenter {
    private MyView myView;
    private final MyModel myModel;

    public MyPresenter(MyView myView) {
        this.myView = myView;
        myModel = new MyModel();
    }
    public void startPresPice(){
        myModel.startPice(new MyCall() {
            @Override
            public void startCallPice(PiceBean piceBean) {
                myView.startViewPice(piceBean);
            }

            @Override
            public void startCallVoid(VoidBean voidBean) {

            }

            @Override
            public void startCallText(TextBean textBean) {

            }

            @Override
            public void startCallTag(TagBean tagBean) {

            }
        });
    }
    public void startPresVoid(){
        myModel.startVoid(new MyCall() {
            @Override
            public void startCallPice(PiceBean piceBean) {

            }

            @Override
            public void startCallVoid(VoidBean voidBean) {
                myView.startViewVoid(voidBean);
            }

            @Override
            public void startCallText(TextBean textBean) {

            }

            @Override
            public void startCallTag(TagBean tagBean) {

            }
        });
    }
    public void startPresText(){
        myModel.startText(new MyCall() {
            @Override
            public void startCallPice(PiceBean piceBean) {
                myView.startViewPice(piceBean);
            }

            @Override
            public void startCallVoid(VoidBean voidBean) {

            }

            @Override
            public void startCallText(TextBean textBean) {
                myView.startViewText(textBean);
            }

            @Override
            public void startCallTag(TagBean tagBean) {

            }
        });
    }
    public void startPresTag(){
        myModel.startTag(new MyCall() {
            @Override
            public void startCallPice(PiceBean piceBean) {
                myView.startViewPice(piceBean);
            }

            @Override
            public void startCallVoid(VoidBean voidBean) {

            }

            @Override
            public void startCallText(TextBean textBean) {

            }

            @Override
            public void startCallTag(TagBean tagBean) {
                myView.startViewTag(tagBean);
            }
        });
    }

}
