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
import com.example.day_03_zy_sanyemian.model.bean.MainImgDataBean;

import java.util.ArrayList;

public class RecycleAdapterImg extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<MainImgDataBean.DataBeanX.DataBean> imgBean;

    public RecycleAdapterImg(Context context, ArrayList<MainImgDataBean.DataBeanX.DataBean> imgBean) {
        this.context = context;
        this.imgBean = imgBean;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.img_layout, null);
        return new Holder1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Holder1 holder1 = (Holder1) holder;
//        holder1.mIvtitle
        //用户头像图片
        Glide.with(context).load(imgBean.get(position).getAuthor().getAvatar()).apply(new RequestOptions().circleCrop()).into(holder1.mIvtitle);
        //月亮会反光
        holder1.titleName.setText(imgBean.get(position).getAuthor().getName());
        holder1.magessId.setText(imgBean.get(position).getFeeds_text());
        //人物图
        Glide.with(context).load(imgBean.get(position).getCover()).into(holder1.imageId);
        //多彩生活
        holder1.duocaiId.setText(imgBean.get(position).getActivityText());
    }

    @Override
    public int getItemCount() {
        return imgBean.size();
    }

    public static
    class Holder1 extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView mIvtitle;
        public TextView titleName;
        public TextView magessId;
        public ImageView imageId;
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
            this.imageId = (ImageView) rootView.findViewById(R.id.imageId);
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
