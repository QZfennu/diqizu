package com.example.hanxuyi_1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ShipinFragment extends Fragment {


    private RecyJiaoziAdapter adapter;
    private ArrayList<ShipinBeans.DataBeanX.DataBean> beans;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shipin, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        RecyclerView jzsp = view.findViewById(R.id.recy_jz);
        jzsp.setLayoutManager(new LinearLayoutManager(getContext()));
        beans = new ArrayList<>();
        adapter = new RecyJiaoziAdapter(beans, getContext());
        jzsp.setAdapter(adapter);
        initData();
    }

    private void initData() {

            new Retrofit.Builder().baseUrl(APISEVERS.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build().create(APISEVERS.class)

                    .getshipin(12,"video").observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(new Observer<ShipinBeans>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(ShipinBeans value) {
                            List<ShipinBeans.DataBeanX.DataBean> data = value.getData().getData();
                            beans.addAll(data);
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