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
import com.example.demo4.Bean.PnBean;
import com.example.demo4.R;

import java.util.List;

public class TPAdapter extends RecyclerView.Adapter<TPAdapter.ViewHolder> {
    private Context context;
    private List<PnBean.DataBeanX.DataBean> list;


    public TPAdapter(Context context, List<PnBean.DataBeanX.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_type, parent, false);
        return new ViewHolder(inflate);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PnBean.DataBeanX.DataBean dataBean = list.get(position);
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.circleCrop();
        PnBean.DataBeanX.DataBean.AuthorBean author = list.get(position).getAuthor();
        Glide.with(context).load(author.getAvatar()).apply(requestOptions).into(holder.mTxIv);
        holder.mNameTv.setText(dataBean.getAuthor().getName());
        holder.mJjTv.setText(dataBean.getFeeds_text());
        Glide.with(context).load(dataBean.getCover()).into(holder.mPtIv);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
         ImageView mTxIv;
         TextView mNameTv;
         TextView mJjTv;
         ImageView mPtIv;
         TextView mDzTv;
         TextView mCTv;
         TextView mPlTv;
         TextView mFxTv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTxIv = (ImageView) itemView.findViewById(R.id.iv_tx);
            mNameTv = (TextView) itemView.findViewById(R.id.tv_name);
            mJjTv = (TextView) itemView.findViewById(R.id.tv_jj);
            mPtIv = (ImageView) itemView.findViewById(R.id.iv_pt);
            mDzTv = (TextView) itemView.findViewById(R.id.tv_dz);
            mCTv = (TextView) itemView.findViewById(R.id.tv_c);
            mPlTv = (TextView) itemView.findViewById(R.id.tv_pl);
            mFxTv = (TextView) itemView.findViewById(R.id.tv_fx);
        }
    }
}
