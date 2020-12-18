package com.example.xiaoshixun_zy.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.xiaoshixun_zy.R;
import com.example.xiaoshixun_zy.bean.PlayBean;

import java.util.ArrayList;

import cn.jzvd.JzvdStd;

public class PlayAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<PlayBean.DataBeanX.DataBean> beans;

    public PlayAdapter(Context context, ArrayList<PlayBean.DataBeanX.DataBean> beans) {
        this.context = context;
        this.beans = beans;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View one = LayoutInflater.from(context).inflate(R.layout.layout_play, parent, false);
        return new PlayHolder(one);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        PlayHolder playHolder = (PlayHolder) holder;
        Glide.with(context).load(beans.get(position).getCover()).into(playHolder.play_img);
        playHolder.jz.setUp(beans.get(position).getUrl(),"你看像不像视频");

    }

    @Override
    public int getItemCount() {
        return beans.size();
    }

    public static
    class PlayHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView play_img;
        public TextView play_text;
        public TextView play_text2;
        public JzvdStd jz;
        public TextView i1;
        public TextView i2;
        public TextView i3;
        public TextView i4;

        public PlayHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.play_img = (ImageView) rootView.findViewById(R.id.play_img);
            this.play_text = (TextView) rootView.findViewById(R.id.play_text);
            this.play_text2 = (TextView) rootView.findViewById(R.id.play_text2);
            this.jz = (JzvdStd) rootView.findViewById(R.id.jz);
            this.i1 = (TextView) rootView.findViewById(R.id.i1);
            this.i2 = (TextView) rootView.findViewById(R.id.i2);
            this.i3 = (TextView) rootView.findViewById(R.id.i3);
            this.i4 = (TextView) rootView.findViewById(R.id.i4);
        }

    }
}
