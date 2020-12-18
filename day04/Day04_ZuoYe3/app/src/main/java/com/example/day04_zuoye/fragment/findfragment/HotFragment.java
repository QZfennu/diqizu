package com.example.day04_zuoye.fragment.findfragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.day04_zuoye.R;
import com.example.day04_zuoye.bean.HotBean;
import com.example.day04_zuoye.presenter.MyPresenter;
import com.example.day04_zuoye.view.MyView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HotFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HotFragment extends Fragment implements MyView {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private HotAdapter hotAdapter;
    private MyPresenter myPresenter;

    public HotFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HotFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HotFragment newInstance(String param1, String param2) {
        HotFragment fragment = new HotFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_hot, container, false);
        myPresenter = new MyPresenter(this);
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {
        myPresenter.getHotData(mParam1);
    }

    private void initView(View inflate) {
        RecyclerView rv_hot  = inflate.findViewById(R.id.rv_hot);
        ArrayList<HotBean.DataDTO.ListDTO> list = new ArrayList<>();
        hotAdapter = new HotAdapter(list,getActivity());
        rv_hot.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv_hot.setAdapter(hotAdapter);
    }

    @Override
    public void onSuccess(Object bean) {
        if (bean instanceof HotBean){
            HotBean hotBean = (HotBean) bean;
            Log.i("TAG", "onSuccess: "+hotBean.toString());
            hotAdapter.list.addAll(hotBean.getData().getList());
            hotAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onFiled(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }
}
