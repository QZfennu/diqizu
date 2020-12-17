package com.example.day3_zuoye.fragment.sofafragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.day3_zuoye.R;
import com.example.day3_zuoye.bean.SofaImageBean;

import java.util.ArrayList;

class SofaImageAdapter extends RecyclerView.Adapter {
    public ArrayList<SofaImageBean.DataDTOX.DataDTO> list;
    private Context context;

    public SofaImageAdapter(ArrayList<SofaImageBean.DataDTOX.DataDTO> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_sofaimage, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder view = (ViewHolder) holder;
        SofaImageBean.DataDTOX.DataDTO dataDTO = list.get(position);
        Glide.with(context).load(dataDTO.getAuthor().getAvatar()).apply(new RequestOptions().circleCrop()).into(view.iv_sofaiamge_avatar);
        Glide.with(context).load(dataDTO.getCover()).into(view.iv_sofaimage_cover);
        view.tv_sofaiamge_name.setText(dataDTO.getAuthor().getName());
        view.tv_sofaimage_activity.setText(dataDTO.getActivityText());
        view.tv_sofaimage_feeds.setText(dataDTO.getFeedsText());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView iv_sofaiamge_avatar;
        public TextView tv_sofaiamge_name;
        public TextView tv_sofaimage_feeds;
        public ImageView iv_sofaimage_cover;
        public TextView tv_sofaimage_activity;
        public LinearLayout ll_sofaimage;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv_sofaiamge_avatar = (ImageView) rootView.findViewById(R.id.iv_sofaiamge_avatar);
            this.tv_sofaiamge_name = (TextView) rootView.findViewById(R.id.tv_sofaiamge_name);
            this.tv_sofaimage_feeds = (TextView) rootView.findViewById(R.id.tv_sofaimage_feeds);
            this.iv_sofaimage_cover = (ImageView) rootView.findViewById(R.id.iv_sofaimage_cover);
            this.tv_sofaimage_activity = (TextView) rootView.findViewById(R.id.tv_sofaimage_activity);
            this.ll_sofaimage = (LinearLayout) rootView.findViewById(R.id.ll_sofaimage);
        }

    }
}
