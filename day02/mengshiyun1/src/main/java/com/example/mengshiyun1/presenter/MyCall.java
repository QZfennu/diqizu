package com.example.mengshiyun1.presenter;

import com.example.mengshiyun1.Bean.FindBean;
import com.example.mengshiyun1.Bean.LevelBean;
import com.example.mengshiyun1.Bean.MoneyBean;
import com.example.mengshiyun1.Bean.SignBean;

public interface MyCall {
    public void startCallFind(FindBean findBean);
    public void startCallLevel(LevelBean levelBean);
    public void startCallSign(SignBean signBean);
    public void startCallMoney(MoneyBean moneyBean);
}
