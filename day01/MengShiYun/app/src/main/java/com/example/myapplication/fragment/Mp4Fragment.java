package com.example.myapplication.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.adapter.VideoAdapter;
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
public class Mp4Fragment extends Fragment implements MyView {

    private RecyclerView rcy;
    private ArrayList<VoidBean.DataBeanX.DataBean> dataBeans;
    private VideoAdapter videoAdapter;

    public Mp4Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mp4, container, false);
        MyPresenter myPresenter = new MyPresenter(this);
        myPresenter.startPresVoid();
        initView(view);
        return view;
    }

    private void initView(View view) {
        rcy = view.findViewById(R.id.mrcy);
        rcy.setLayoutManager(new LinearLayoutManager(getActivity()));
        dataBeans = new ArrayList<>();
        videoAdapter = new VideoAdapter(getActivity(), dataBeans);
        rcy.setAdapter(videoAdapter);
    }

    @Override
    public void startViewPice(PiceBean piceBean) {

    }

    @Override
    public void startViewVoid(VoidBean voidBean) {
        dataBeans.addAll(voidBean.getData().getData());
        videoAdapter.notifyDataSetChanged();
    }

    @Override
    public void startViewText(TextBean textBean) {

    }

    @Override
    public void startViewTag(TagBean tagBean) {

    }
}
