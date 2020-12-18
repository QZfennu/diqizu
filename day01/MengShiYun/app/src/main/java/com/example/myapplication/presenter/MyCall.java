package com.example.myapplication.presenter;

import com.example.myapplication.bean.PiceBean;
import com.example.myapplication.bean.TagBean;
import com.example.myapplication.bean.TextBean;
import com.example.myapplication.bean.VoidBean;

public interface MyCall {
    public void startCallPice(PiceBean piceBean);
    public void startCallVoid(VoidBean voidBean);
    public void startCallText(TextBean textBean);
    public void startCallTag(TagBean tagBean);
}
