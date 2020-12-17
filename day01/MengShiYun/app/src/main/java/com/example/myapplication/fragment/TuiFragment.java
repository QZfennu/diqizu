package com.example.myapplication.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.adapter.LogAdapter;
import com.example.myapplication.bean.DataBean;
import com.example.myapplication.bean.PiceBean;
import com.example.myapplication.bean.TagBean;
import com.example.myapplication.bean.TextBean;
import com.example.myapplication.bean.VoidBean;
import com.example.myapplication.presenter.MyPresenter;
import com.example.myapplication.view.MyView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TuiFragment extends Fragment implements MyView {

    private RecyclerView recycler;
    private ArrayList<DataBean> list;
    private LogAdapter logAdapter;

    public TuiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tui, container, false);
        MyPresenter myPresenter = new MyPresenter(this);
        myPresenter.startPresTag();
        initView(view);
        return view;
    }

    private void initView(View view) {
        recycler = view.findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        list = new ArrayList<>();
        logAdapter = new LogAdapter(getActivity(), list);
        recycler.setAdapter(logAdapter);
    }

    @Override
    public void startViewPice(PiceBean piceBean) {

    }

    @Override
    public void startViewVoid(VoidBean voidBean) {

    }

    @Override
    public void startViewText(TextBean textBean) {

    }

    @Override
    public void startViewTag(TagBean tagBean) {
        list.addAll(tagBean.getData().getData());
        logAdapter.notifyDataSetChanged();
    }
}
