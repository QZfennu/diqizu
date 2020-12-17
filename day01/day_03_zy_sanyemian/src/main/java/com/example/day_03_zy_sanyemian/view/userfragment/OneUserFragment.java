package com.example.day_03_zy_sanyemian.view.userfragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.day_03_zy_sanyemian.R;
import com.example.day_03_zy_sanyemian.db.App;
import com.example.day_03_zy_sanyemian.model.adapter.RecycleUserAdapter;
import com.example.day_03_zy_sanyemian.model.bean.DataBean;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class OneUserFragment extends Fragment {


    private RecyclerView mReusertwo;
    private RecycleUserAdapter adapter;

    public OneUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_one2, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mReusertwo = view.findViewById(R.id.mReusertwo);
        mReusertwo.setLayoutManager(new LinearLayoutManager(getActivity()));
        ArrayList<DataBean> dataBeans = (ArrayList<DataBean>) App.getDaoSession().getDataBeanDao().loadAll();
        adapter = new RecycleUserAdapter(getActivity(), dataBeans);
        mReusertwo.setAdapter(adapter);
    }

}
