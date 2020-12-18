package com.example.tongpao.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tongpao.R;
import com.example.tongpao.beans.HuodongRecyBeans;

import java.util.ArrayList;

public class FrameRecyAdpater extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<HuodongRecyBeans.DataBean> huodonglist;

    public FrameRecyAdpater(Context context, ArrayList<HuodongRecyBeans.DataBean> huodonglist) {
        this.context = context;
        this.huodonglist = huodonglist;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_recy_redian, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            ViewHolder view = (ViewHolder) holder;
            view.text_di.setText(huodonglist.get(position).getBusinessEndTime());
        Glide.with(context).load(huodonglist.get(position).getCover()).into(view.image_111);
    }

    @Override
    public int getItemCount() {
        return huodonglist.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView image_111;
        public TextView text_di;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.image_111 = (ImageView) rootView.findViewById(R.id.image_111);
            this.text_di = (TextView) rootView.findViewById(R.id.text_di);
        }

    }
}
