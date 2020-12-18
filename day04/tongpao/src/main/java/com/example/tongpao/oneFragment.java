package com.example.tongpao;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tongpao.adapter.OneRecyAdapter;
import com.example.tongpao.beans.OneqianBenas;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class oneFragment extends Fragment {

    private OneRecyAdapter adapter;
    private ArrayList<OneqianBenas.DataBean.ExpTopBean.ListBean> beans;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        initData(view);
        return view;
    }

    private void initData(View view) {
        RecyclerView recy = view.findViewById(R.id.recy_one);
        recy.setLayoutManager(new LinearLayoutManager(getContext()));
        beans = new ArrayList<>();
        adapter = new OneRecyAdapter(beans, getContext());
        recy.setAdapter(adapter);
        new Retrofit.Builder()
                .baseUrl(ApISEVERs.BEAS_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build().create(ApISEVERs.class)
                .getqiandao().observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new Observer<OneqianBenas>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(OneqianBenas value) {
                List<OneqianBenas.DataBean.ExpTopBean.ListBean> list = value.getData().getExpTop().getList();
                beans.addAll(list);
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