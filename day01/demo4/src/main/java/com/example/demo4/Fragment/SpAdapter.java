package com.example.demo4.Fragment;

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
import com.example.demo4.Bean.MpBean;
import com.example.demo4.Bean.PnBean;
import com.example.demo4.R;
import com.yc.video.player.VideoPlayer;
import com.yc.video.ui.view.BasisVideoController;

import java.util.List;

public class SpAdapter extends RecyclerView.Adapter<SpAdapter.ViewHolder> {
    private Context context;
    private List<MpBean.DataBeanX.DataBean> list;


    public SpAdapter(Context context, List<MpBean.DataBeanX.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item2_type, parent, false);
        return new ViewHolder(inflate);
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MpBean.DataBeanX.DataBean dataBean = list.get(position);
        MpBean.DataBeanX.DataBean.AuthorBean author = list.get(position).getAuthor();
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.circleCrop();
        Glide.with(context).load(author.getAvatar()).apply(requestOptions).into(holder.mTxIv);
        holder.mNameTv.setText(dataBean.getAuthor().getName());
        holder.mJjTv.setText(dataBean.getFeeds_text()+"");
        //创建基础视频播放器，一般播放器的功能
        BasisVideoController controller = new BasisVideoController(context);
//设置控制器
        holder.PlayerVideo.setController(controller);
//设置视频播放链接地址
        holder.PlayerVideo.setUrl(dataBean.getUrl());
//开始播放
        holder.PlayerVideo.start();
        holder.PlayerVideo.postDelayed(new Runnable() {
            @Override
            public void run() {
                holder.PlayerVideo.start();
            }
        }, 300);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
         ImageView mTxIv;
         TextView mNameTv;
         TextView mJjTv;
         VideoPlayer PlayerVideo;
         TextView mDzTv;
         TextView mCTv;
         TextView mPlTv;
         TextView mFxTv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTxIv = (ImageView) itemView.findViewById(R.id.iv_tx);
            mNameTv = (TextView) itemView.findViewById(R.id.tv_name);
            mJjTv = (TextView) itemView.findViewById(R.id.tv_jj);
            PlayerVideo = (VideoPlayer) itemView.findViewById(R.id.video_player);
            mDzTv = (TextView) itemView.findViewById(R.id.tv_dz);
            mCTv = (TextView) itemView.findViewById(R.id.tv_c);
            mPlTv = (TextView) itemView.findViewById(R.id.tv_pl);
            mFxTv = (TextView) itemView.findViewById(R.id.tv_fx);
        }
    }
}
