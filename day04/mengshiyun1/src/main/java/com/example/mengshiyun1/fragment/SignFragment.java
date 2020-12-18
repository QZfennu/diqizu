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
import com.example.mengshiyun1.adapter.SignAdapter;
import com.example.mengshiyun1.presenter.MyPersenter;
import com.example.mengshiyun1.view.MyView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignFragment extends Fragment implements MyView {

    private RecyclerView srcy;

    public SignFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign, container, false);
        MyPersenter myPersenter = new MyPersenter(this);
        myPersenter.startPersSign();
        initView(view);
        return view;
    }

    private void initView(View view) {
        srcy = view.findViewById(R.id.srcy);
        srcy.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void startViewFind(FindBean findBean) {

    }

    @Override
    public void startViewLevel(LevelBean levelBean) {

    }

    @Override
    public void startViewSign(SignBean signBean) {
        ArrayList<SignBean.DataBean.SignTopBean.ListBean> list = (ArrayList<SignBean.DataBean.SignTopBean.ListBean>) signBean.getData().getSignTop().getList();
        srcy.setAdapter(new SignAdapter(getActivity(),list));
    }

    @Override
    public void startViewMoney(MoneyBean moneyBean) {

    }
}
