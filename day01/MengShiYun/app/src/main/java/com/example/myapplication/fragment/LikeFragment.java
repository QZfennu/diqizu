package com.example.myapplication.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.App;
import com.example.myapplication.R;
import com.example.myapplication.adapter.LogAdapter;
import com.example.myapplication.bean.DataBean;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class LikeFragment extends Fragment {

    private RecyclerView mTagRcy;
    private ArrayList<DataBean> list;
    private LogAdapter logAdapter;

    public LikeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_like, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mTagRcy = view.findViewById(R.id.mTagRcy);
        mTagRcy.setLayoutManager(new LinearLayoutManager(getActivity()));
        ArrayList<DataBean> dataBeans = (ArrayList<DataBean>) App.getmDaoSession().getDataBeanDao().loadAll();
        logAdapter = new LogAdapter(getActivity(), dataBeans);
        mTagRcy.setAdapter(logAdapter);
    }



}
