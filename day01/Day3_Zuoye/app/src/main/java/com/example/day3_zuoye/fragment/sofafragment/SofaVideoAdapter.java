package com.example.day3_zuoye.fragment.sofafragment;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.day3_zuoye.R;
import com.example.day3_zuoye.bean.SofaVideoBean;
import com.yc.video.player.VideoPlayer;
import com.yc.video.ui.view.BasisVideoController;

import java.util.ArrayList;

class SofaVideoAdapter extends RecyclerView.Adapter {
    public ArrayList<SofaVideoBean.DataDTOX.DataDTO> list;
    private Context context;

    public SofaVideoAdapter(ArrayList<SofaVideoBean.DataDTOX.DataDTO> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_video, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder view = (ViewHolder) holder;
        SofaVideoBean.DataDTOX.DataDTO dataDTO = list.get(position);

        BasisVideoController controller = new BasisVideoController(context);
        view.vv_sofavideo_url.setController(controller);
        view.vv_sofavideo_url.setUrl(dataDTO.getUrl());

        Glide.with(context).load(dataDTO.getAuthor().getAvatar()).apply(new RequestOptions().circleCrop()).into(view.iv_sofavideo_avatar);
        view.tv_sofavideo_name.setText(dataDTO.getAuthor().getName());
        view.tv_sofavideo_feeds.setText(dataDTO.getFeedsText() + "");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView iv_sofavideo_avatar;
        public TextView tv_sofavideo_name;
        public TextView tv_sofavideo_feeds;
        public VideoPlayer vv_sofavideo_url;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv_sofavideo_avatar = (ImageView) rootView.findViewById(R.id.iv_sofavideo_avatar);
            this.tv_sofavideo_name = (TextView) rootView.findViewById(R.id.tv_sofavideo_name);
            this.tv_sofavideo_feeds = (TextView) rootView.findViewById(R.id.tv_sofavideo_feeds);
            this.vv_sofavideo_url = (VideoPlayer) rootView.findViewById(R.id.vv_sofavideo_url);
        }

    }
}
