package com.example.mengshiyun1.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mengshiyun1.Bean.FindBean;
import com.example.mengshiyun1.Bean.LevelBean;
import com.example.mengshiyun1.Bean.MoneyBean;
import com.example.mengshiyun1.Bean.SignBean;
import com.example.mengshiyun1.adapter.MyAdapter;
import com.example.mengshiyun1.PaiActivity;
import com.example.mengshiyun1.R;
import com.example.mengshiyun1.presenter.MyPersenter;
import com.example.mengshiyun1.view.MyView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FindFragment extends Fragment implements MyView {

    private ArrayList<FindBean.DataBean> dataBeans;
    private MyAdapter myAdapter;

    public FindFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_find, container, false);
        MyPersenter myPersenter = new MyPersenter(this);
        myPersenter.startPersFind();
        initView(view);
        return view;
    }

    private void initView(View view) {
        RecyclerView rcy = view.findViewById(R.id.rcy);
        TextView text3 = view.findViewById(R.id.text3);
        text3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), PaiActivity.class));
            }
        });
        rcy.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        dataBeans = new ArrayList<>();
        myAdapter = new MyAdapter(getActivity(), dataBeans);
        rcy.setAdapter(myAdapter);
    }

    @Override
    public void startViewFind(FindBean findBean) {
        dataBeans.addAll(findBean.getData());
        myAdapter.notifyDataSetChanged();
    }

    @Override
    public void startViewLevel(LevelBean levelBean) {

    }

    @Override
    public void startViewSign(SignBean signBean) {

    }

    @Override
    public void startViewMoney(MoneyBean moneyBean) {

    }
}
