package com.example.mengshiyun1.adapter;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mengshiyun1.Bean.FindBean;
import com.example.mengshiyun1.R;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<FindBean.DataBean> list;

    public MyAdapter(Context context, ArrayList<FindBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item2, parent, false);
        return new ViewHolder1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder1 holder1= (ViewHolder1) holder;
        holder1.title.setText(list.get(position).getTitle());
        holder1.dress.setText(list.get(position).getLocation());
        holder1.data.setText(list.get(position).getStartTime());
        Glide.with(context).load(list.get(position).getCover()).into(holder1.img1);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder1 extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView img1;
        public TextView title;
        public TextView dress;
        public TextView data;

        public ViewHolder1(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.img1 = (ImageView) rootView.findViewById(R.id.img1);
            this.title = (TextView) rootView.findViewById(R.id.title);
            this.dress = (TextView) rootView.findViewById(R.id.dress);
            this.data = (TextView) rootView.findViewById(R.id.data);
        }

    }
}
