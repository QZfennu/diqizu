package com.example.xiaoshixun_zy.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.xiaoshixun_zy.R;
import com.example.xiaoshixun_zy.bean.ItemBean;

import java.util.ArrayList;

public class RlvAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<ItemBean.DataBeanX.DataBean> beans;

    public RlvAdapter(Context context, ArrayList<ItemBean.DataBeanX.DataBean> beans) {
        this.context = context;
        this.beans = beans;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View one = LayoutInflater.from(context).inflate(R.layout.layout_one, parent, false);
        return new OneHolder(one);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        OneHolder oneHolder = (OneHolder) holder;
        Glide.with(context).load(beans.get(position).getAuthor()).into(oneHolder.one_img);
        Glide.with(context).load(beans.get(position).getCover()).into(oneHolder.two_img);
        oneHolder.one_text.setText(beans.get(position).getFeeds_text());
        oneHolder.two_text.setText(beans.get(position).getFeeds_text());

    }

    @Override
    public int getItemCount() {
        return beans.size();
    }

    public static
    class OneHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView one_img;
        public TextView one_text;
        public TextView two_text;
        public ImageView two_img;
        public TextView i1;
        public TextView i2;
        public TextView i3;
        public TextView i4;

        public OneHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.one_img = (ImageView) rootView.findViewById(R.id.one_img);
            this.one_text = (TextView) rootView.findViewById(R.id.one_text);
            this.two_text = (TextView) rootView.findViewById(R.id.two_text);
            this.two_img = (ImageView) rootView.findViewById(R.id.two_img);
            this.i1 = (TextView) rootView.findViewById(R.id.i1);
            this.i2 = (TextView) rootView.findViewById(R.id.i2);
            this.i3 = (TextView) rootView.findViewById(R.id.i3);
            this.i4 = (TextView) rootView.findViewById(R.id.i4);
        }

    }
}
