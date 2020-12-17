package com.example.day_03_zy_sanyemian.model.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.day_03_zy_sanyemian.R;
import com.example.day_03_zy_sanyemian.model.bean.MainDataVideo;
import com.yc.video.player.VideoPlayer;
import com.yc.video.ui.view.BasisVideoController;

import java.util.ArrayList;

public class RecycleVideoAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<MainDataVideo.DataBeanX.DataBean> list;

    public RecycleVideoAdapter(Context context, ArrayList<MainDataVideo.DataBeanX.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.video_layout, null);
        return new Holder1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Holder1 holder1 = (Holder1) holder;
        //头像
        Glide.with(context).load(list.get(position).getAuthor().getAvatar()).apply(new RequestOptions().circleCrop()).into(holder1.mIvtitle);
        //头像名字
        holder1.titleName.setText(list.get(position).getAuthor().getName());
        //视频
        holder1.video_shipin.setUrl(list.get(position).getUrl());

        //创建基础视频播放器，一般播放器的功能
        BasisVideoController controller = new BasisVideoController(context);
        //设置控制器
        holder1.video_shipin.setController(controller);
        //设置视频播放地址
        //开始播放
        holder1.video_shipin.start();

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class Holder1 extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView mIvtitle;
        public TextView titleName;
        public TextView magessId;
        public VideoPlayer video_shipin;
        public TextView duocaiId;
        public ImageView iv_dz;
        public TextView shuzi;
        public ImageView iv_xq;
        public TextView tv_cai;
        public ImageView iv_wen;
        public TextView tv_plun;
        public ImageView iv_fx;
        public TextView tv_fenx;

        public Holder1(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.mIvtitle = (ImageView) rootView.findViewById(R.id.mIvtitle);
            this.titleName = (TextView) rootView.findViewById(R.id.titleName);
            this.magessId = (TextView) rootView.findViewById(R.id.magessId);
            this.video_shipin = (VideoPlayer) rootView.findViewById(R.id.video_shipin);
            this.duocaiId = (TextView) rootView.findViewById(R.id.duocaiId);
            this.iv_dz = (ImageView) rootView.findViewById(R.id.iv_dz);
            this.shuzi = (TextView) rootView.findViewById(R.id.shuzi);
            this.iv_xq = (ImageView) rootView.findViewById(R.id.iv_xq);
            this.tv_cai = (TextView) rootView.findViewById(R.id.tv_cai);
            this.iv_wen = (ImageView) rootView.findViewById(R.id.iv_wen);
            this.tv_plun = (TextView) rootView.findViewById(R.id.tv_plun);
            this.iv_fx = (ImageView) rootView.findViewById(R.id.iv_fx);
            this.tv_fenx = (TextView) rootView.findViewById(R.id.tv_fenx);
        }

    }
}
