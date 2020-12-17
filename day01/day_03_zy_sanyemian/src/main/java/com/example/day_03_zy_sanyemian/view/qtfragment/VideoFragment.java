package com.example.day_03_zy_sanyemian.view.qtfragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day_03_zy_sanyemian.R;
import com.example.day_03_zy_sanyemian.model.adapter.RecycleVideoAdapter;
import com.example.day_03_zy_sanyemian.model.bean.MainDataVideo;
import com.example.day_03_zy_sanyemian.persenter.Mpersenter;
import com.example.day_03_zy_sanyemian.view.Mviwe;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class VideoFragment extends Fragment implements Mviwe {


    private RecyclerView mRevideo;
    private ArrayList<MainDataVideo.DataBeanX.DataBean> list;
    private RecycleVideoAdapter adapter;
    private Mpersenter mpersenter;

    public VideoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_vide, container, false);
        mpersenter = new Mpersenter(this);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        mpersenter.setDataVideo();
    }


    private void initView(View view) {

        mRevideo = view.findViewById(R.id.mRevideo);


        mRevideo.setLayoutManager(new LinearLayoutManager(getActivity()));
        list = new ArrayList<>();
        adapter = new RecycleVideoAdapter(getActivity(), list);

        mRevideo.setAdapter(adapter);

    }


    @Override
    public void setvideoData(Object object) {
        if(object instanceof MainDataVideo){
            MainDataVideo mainDataVideo = (MainDataVideo) object;
            List<MainDataVideo.DataBeanX.DataBean> data = mainDataVideo.getData().getData();
            list.addAll(data);
            adapter.notifyDataSetChanged();
        }
    }
}
