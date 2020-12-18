package com.example.day04_zuoye.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.day04_zuoye.R;
import com.example.day04_zuoye.bean.HotActivityBean;

import java.util.ArrayList;

class FindRvAdapter extends RecyclerView.Adapter {
    public ArrayList<HotActivityBean.DataDTO> list;
    private Context context;

    public FindRvAdapter(ArrayList<HotActivityBean.DataDTO> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_findrv, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder view = (ViewHolder) holder;
        HotActivityBean.DataDTO dataDTO = list.get(position);
        Glide.with(context).load(dataDTO.getCover()).into(view.iv_findrv);
        view.tv_findrv.setText(dataDTO.getTitle());
        view.tv_findrv2.setText(dataDTO.getLocation());
        view.tv_findrv3.setText(dataDTO.getApplyCutOffTime());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView iv_findrv;
        public TextView tv_findrv;
        public TextView tv_findrv2;
        public TextView tv_findrv3;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv_findrv = (ImageView) rootView.findViewById(R.id.iv_findrv);
            this.tv_findrv = (TextView) rootView.findViewById(R.id.tv_findrv);
            this.tv_findrv2 = (TextView) rootView.findViewById(R.id.tv_findrv2);
            this.tv_findrv3 = (TextView) rootView.findViewById(R.id.tv_findrv3);
        }

    }
}
