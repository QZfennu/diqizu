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
import com.example.mengshiyun1.adapter.MoneyAdapter;
import com.example.mengshiyun1.presenter.MyPersenter;
import com.example.mengshiyun1.view.MyView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoneyFragment extends Fragment implements MyView {

    private RecyclerView mrcy;

    public MoneyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_money, container, false);
        MyPersenter myPersenter = new MyPersenter(this);
        myPersenter.startPersMoney();
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        mrcy = inflate.findViewById(R.id.mrcy);
        mrcy.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void startViewFind(FindBean findBean) {

    }

    @Override
    public void startViewLevel(LevelBean levelBean) {

    }

    @Override
    public void startViewSign(SignBean signBean) {

    }

    @Override
    public void startViewMoney(MoneyBean moneyBean) {
        ArrayList<MoneyBean.DataBean.TongQianTopBean.ListBean> list = (ArrayList<MoneyBean.DataBean.TongQianTopBean.ListBean>) moneyBean.getData().getTongQianTop().getList();
        mrcy.setAdapter(new MoneyAdapter(getActivity(),list));
    }
}
