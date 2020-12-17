package com.example.myapplication.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.adapter.PiceAdapter;
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
public class PicFragment extends Fragment implements MyView {

    private RecyclerView rcy;
    private ArrayList<PiceBean.DataBeanX.DataBean> list;
    private PiceAdapter piceAdapter;

    public PicFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_pic, container, false);
        MyPresenter myPresenter = new MyPresenter(this);
        myPresenter.startPresPice();
        initView(v);
        return v;
    }

    private void initView(View v) {
        rcy = v.findViewById(R.id.rcy);
        rcy.setLayoutManager(new LinearLayoutManager(getActivity()));
        list = new ArrayList<>();
        piceAdapter = new PiceAdapter(getActivity(), list);
        rcy.setAdapter(piceAdapter);

    }

    @Override
    public void startViewPice(PiceBean piceBean) {
        list.addAll(piceBean.getData().getData());
        piceAdapter.notifyDataSetChanged();
    }

    @Override
    public void startViewVoid(VoidBean voidBean) {

    }

    @Override
    public void startViewText(TextBean textBean) {

    }

    @Override
    public void startViewTag(TagBean tagBean) {

    }
}
