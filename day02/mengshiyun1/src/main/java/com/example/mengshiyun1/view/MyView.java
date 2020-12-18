package com.example.mengshiyun1.view;

import com.example.mengshiyun1.Bean.FindBean;
import com.example.mengshiyun1.Bean.LevelBean;
import com.example.mengshiyun1.Bean.MoneyBean;
import com.example.mengshiyun1.Bean.SignBean;

public interface MyView {
    public void startViewFind(FindBean findBean);
    public void startViewLevel(LevelBean levelBean);
    public void startViewSign(SignBean signBean);
    public void startViewMoney(MoneyBean moneyBean);
}
