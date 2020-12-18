package com.example.xiaoshixun_zy.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.xiaoshixun_zy.R;
import com.example.xiaoshixun_zy.adapter.RlvAdapter;
import com.example.xiaoshixun_zy.bean.ItemBean;
import com.example.xiaoshixun_zy.presenter.MainPresenter;
import com.example.xiaoshixun_zy.view.MainView;

import java.util.ArrayList;
import java.util.List;

public class ItemFragmenr extends Fragment implements MainView {
    private RecyclerView mRel;
    private ArrayList<ItemBean.DataBeanX.DataBean> beans;
    private RlvAdapter adapter;
    private MainPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.item_fragment, null);
        presenter = new MainPresenter(this);
        initData();
        initView(view);
        return view;
    }

    private void initData() {
        presenter.getData();
    }

    private void initView(@NonNull final View itemView) {
        mRel = (RecyclerView) itemView.findViewById(R.id.rel);
        mRel.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRel.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        beans = new ArrayList<>();
        adapter = new RlvAdapter(getContext(), beans);
        mRel.setAdapter(adapter);
    }

    @Override
    public void onSuccess(ItemBean itemBean) {
        if (itemBean!=null && itemBean.getData()!=null && itemBean.getData().getData()!=null){
            List<ItemBean.DataBeanX.DataBean> data = itemBean.getData().getData();
            beans.addAll(data);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onFail(String msg) {

    }
}
