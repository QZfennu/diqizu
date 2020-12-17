package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.myapplication.R;
import com.example.myapplication.bean.VoidBean;
import com.yc.video.player.VideoPlayer;
import com.yc.video.ui.view.BasisVideoController;

import java.util.ArrayList;

public class VideoAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<VoidBean.DataBeanX.DataBean> list;

    public VideoAdapter(Context context, ArrayList<VoidBean.DataBeanX.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.void_item, parent, false);
        return new ViewHolder1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder1 holder1 = (ViewHolder1) holder;
//        holder1.title.setText(list.get(position).getFeeds_text().toString());
        Glide.with(context).load(list.get(position).getAuthor().getAvatar()).apply(new RequestOptions().circleCrop()).into(holder1.img);
        holder1.video.setUrl(list.get(position).getUrl());
        BasisVideoController basisVideoController = new BasisVideoController(context);
        holder1.video.setController(basisVideoController);
        holder1.video.start();
        holder1.name.setText(list.get(position).getAuthor().getName());
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
        public TextView title;
        public VideoPlayer video;

        public ViewHolder1(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.img = (ImageView) rootView.findViewById(R.id.img);
            this.name = (TextView) rootView.findViewById(R.id.name);
            this.title = (TextView) rootView.findViewById(R.id.title);
            this.video = (VideoPlayer) rootView.findViewById(R.id.video);
        }

    }
}

