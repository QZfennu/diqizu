package com.example.mengshiyun1.presenter;

import com.example.mengshiyun1.Bean.FindBean;
import com.example.mengshiyun1.Bean.LevelBean;
import com.example.mengshiyun1.Bean.MoneyBean;
import com.example.mengshiyun1.Bean.SignBean;
import com.example.mengshiyun1.model.MyModel;
import com.example.mengshiyun1.view.MyView;

public class MyPersenter {
    private final MyModel myModel;
    private MyView myView;

    public MyPersenter(MyView myView) {
        this.myView = myView;
        myModel = new MyModel();
    }
    public void startPersFind(){
        myModel.startFind(new MyCall() {
            @Override
            public void startCallFind(FindBean findBean) {
                myView.startViewFind(findBean);
            }

            @Override
            public void startCallLevel(LevelBean levelBean) {

            }

            @Override
            public void startCallSign(SignBean signBean) {

            }

            @Override
            public void startCallMoney(MoneyBean moneyBean) {

            }
        });
    }
    public void startPersLevel(){
        myModel.startLevel(new MyCall() {
            @Override
            public void startCallFind(FindBean findBean) {

            }

            @Override
            public void startCallLevel(LevelBean levelBean) {
                myView.startViewLevel(levelBean);
            }

            @Override
            public void startCallSign(SignBean signBean) {

            }

            @Override
            public void startCallMoney(MoneyBean moneyBean) {

            }
        });
    }
    public void startPersSign(){
        myModel.startSign(new MyCall() {
            @Override
            public void startCallFind(FindBean findBean) {
            }

            @Override
            public void startCallLevel(LevelBean levelBean) {

            }

            @Override
            public void startCallSign(SignBean signBean) {
                myView.startViewSign(signBean);
            }

            @Override
            public void startCallMoney(MoneyBean moneyBean) {

            }
        });
    }
    public void startPersMoney(){
        myModel.startMoney(new MyCall() {
            @Override
            public void startCallFind(FindBean findBean) {

            }

            @Override
            public void startCallLevel(LevelBean levelBean) {

            }

            @Override
            public void startCallSign(SignBean signBean) {

            }

            @Override
            public void startCallMoney(MoneyBean moneyBean) {
                myView.startViewMoney(moneyBean);
            }
        });
    }
}
