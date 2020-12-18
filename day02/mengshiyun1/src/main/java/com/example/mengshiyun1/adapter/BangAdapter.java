package com.example.mengshiyun1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mengshiyun1.Bean.LevelBean;
import com.example.mengshiyun1.R;

import java.util.ArrayList;

public class BangAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<LevelBean.DataBean.ExpTopBean.ListBean> list;

    public BangAdapter(Context context, ArrayList<LevelBean.DataBean.ExpTopBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.bang_item, parent, false);
        return new ViewHolder1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder1 holder1 = (ViewHolder1) holder;
        holder1.name.setText(list.get(position).getNickName());
        holder1.dress.setText(list.get(position).getProvince()+list.get(position).getCity());
        holder1.jingyan.setText(list.get(position).getExpScore()+"经验");
        Glide.with(context).load(list.get(position).getHeadUrl()).into(holder1.img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder1 extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView img;
        public TextView name;
        public TextView dress;
        public TextView jingyan;

        public ViewHolder1(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.img = (ImageView) rootView.findViewById(R.id.img);
            this.name = (TextView) rootView.findViewById(R.id.name);
            this.dress = (TextView) rootView.findViewById(R.id.dress);
            this.jingyan = (TextView) rootView.findViewById(R.id.jingyan);
        }

    }
}
