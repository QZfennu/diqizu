package com.example.myapplication.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.adapter.TextAdapter;
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
public class TextFragment extends Fragment implements MyView {

    private RecyclerView mRcy;
    private ArrayList<TextBean.DataBeanX.DataBean> list;
    private TextAdapter textAdapter;

    public TextFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_text, container, false);
        MyPresenter myPresenter = new MyPresenter(this);
        myPresenter.startPresText();
        initView(view);
        return view;
    }

    private void initView(View view) {
        mRcy = view.findViewById(R.id.mRcy);
        mRcy.setLayoutManager(new LinearLayoutManager(getActivity()));
        list = new ArrayList<>();
        textAdapter = new TextAdapter(getActivity(), list);
        mRcy.setAdapter(textAdapter);
    }

    @Override
    public void startViewPice(PiceBean piceBean) {

    }

    @Override
    public void startViewVoid(VoidBean voidBean) {

    }

    @Override
    public void startViewText(TextBean textBean) {
        list.addAll(textBean.getData().getData());
        textAdapter.notifyDataSetChanged();
    }

    @Override
    public void startViewTag(TagBean tagBean) {

    }
}
