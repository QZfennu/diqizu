package com.example.tongpao.adapter;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tongpao.ApISEVERs;
import com.example.tongpao.R;
import com.example.tongpao.beans.Faxian4Beans;
import com.example.tongpao.beans.Fenlei1Beans;
import com.example.tongpao.beans.FenleidaohangBeans;
import com.example.tongpao.beans.HuodongRecyBeans;

import java.util.ArrayList;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class FaxianFragment extends Fragment {

    private ArrayList<FenleidaohangBeans.DataBean> list;
    private ArrayList<HuodongRecyBeans.DataBean> huodonglistm;
    private ArrayList<Fenlei1Beans.DataBean.ListBean.FilePathListBean> frame1;
    private ArrayList<Faxian4Beans.DataBean.ListBean> frame4;
    private FaxianAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_faxian, container, false);
        initview(view);
        return view;
    }

    private void initview(View view) {
        RecyclerView recy_faxian = view.findViewById(R.id.recy_faxian);
        recy_faxian.setLayoutManager(new LinearLayoutManager(getContext()));

        list = new ArrayList<>();
        huodonglistm = new ArrayList<>();
        frame1 = new ArrayList<>();
        frame4 = new ArrayList<>();
        adapter =new FaxianAdapter(list,huodonglistm,getContext(),new FrameRecyAdpater(getContext(),huodonglistm));
        recy_faxian.setAdapter(adapter);
        initData();
    }

    private void initData() {
        //获取 活动导航
        new Retrofit.Builder().baseUrl(ApISEVERs.BEAS_URL).addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build().create(ApISEVERs.class)
                .huodong().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<HuodongRecyBeans>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(HuodongRecyBeans value) {
            huodonglistm.addAll(value.getData());
            adapter.notifyDataSetChanged();
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });


    }



}