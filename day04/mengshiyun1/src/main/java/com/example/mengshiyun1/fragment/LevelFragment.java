package com.example.mengshiyun1.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mengshiyun1.Bean.FindBean;
import com.example.mengshiyun1.Bean.LevelBean;
import com.example.mengshiyun1.Bean.MoneyBean;
import com.example.mengshiyun1.Bean.SignBean;
import com.example.mengshiyun1.R;
import com.example.mengshiyun1.adapter.BangAdapter;
import com.example.mengshiyun1.presenter.MyPersenter;
import com.example.mengshiyun1.view.MyView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class LevelFragment extends Fragment implements MyView {

    private RecyclerView rcy;

    public LevelFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_level, container, false);
        MyPersenter myPersenter = new MyPersenter(this);
        myPersenter.startPersLevel();
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        rcy = inflate.findViewById(R.id.rcy);
        rcy.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void startViewFind(FindBean findBean) {

    }

    @Override
    public void startViewLevel(LevelBean levelBean) {
        ArrayList<LevelBean.DataBean.ExpTopBean.ListBean> list = (ArrayList<LevelBean.DataBean.ExpTopBean.ListBean>) levelBean.getData().getExpTop().getList();
        BangAdapter bangAdapter = new BangAdapter(getActivity(), list);
        rcy.setAdapter(bangAdapter);
    }

    @Override
    public void startViewSign(SignBean signBean) {

    }

    @Override
    public void startViewMoney(MoneyBean moneyBean) {

    }
}
