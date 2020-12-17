package com.example.hanxuyi_1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
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


public class Recy_one_Fragment extends Fragment implements Iview {

    private ArrayList<ImageBeans.DataBeanX.DataBean> beans;
    private RecyOneAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recy_one_, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        RecyclerView recy_one = view.findViewById(R.id.recy_one);
        recy_one.setLayoutManager(new LinearLayoutManager(getContext()));
        beans = new ArrayList<>();
        adapter = new RecyOneAdapter(beans, getContext());
        Person person = new Person(this);
        person.getlist();
        recy_one.setAdapter(adapter);
    }


    @Override
    public void getObjece(Object o) {
        if (o instanceof ImageBeans){
            ImageBeans o1 = (ImageBeans) o;
            List<ImageBeans.DataBeanX.DataBean> data = o1.getData().getData();
            beans.addAll(data);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void getExction(String exction) {
        Log.i("TAG", "getExction: "+exction);
    }
}