package com.example.myapplication.view;

import android.widget.TextView;

import com.example.myapplication.bean.PiceBean;
import com.example.myapplication.bean.TagBean;
import com.example.myapplication.bean.TextBean;
import com.example.myapplication.bean.VoidBean;

public interface MyView {
    public void startViewPice(PiceBean piceBean);
    public void startViewVoid(VoidBean voidBean);
    public void startViewText(TextBean textBean);
    public void startViewTag(TagBean tagBean);
}
