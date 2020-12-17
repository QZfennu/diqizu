package com.example.day_03_zy_sanyemian.persenter;

import androidx.fragment.app.FragmentActivity;

import com.example.day_03_zy_sanyemian.callback.callbackdatavideo;
import com.example.day_03_zy_sanyemian.model.Mmodel;
import com.example.day_03_zy_sanyemian.view.Mviwe;

public class Mpersenter {
    private Mviwe mviwe;
    private final Mmodel mmodel;

    public Mpersenter(Mviwe mviwe) {

        this.mviwe = mviwe;
        mmodel = new Mmodel();

    }

    public void setDataVideo() {
        mmodel.getDatavieods(new callbackdatavideo() {
            @Override
            public void callbackvoido(Object object) {
                mviwe.setvideoData(object);
            }
        });
    }
}
