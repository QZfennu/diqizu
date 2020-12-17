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
import com.example.demo4.Bean.TextBean;
import com.example.demo4.R;

import java.util.List;

public class TextAdapter extends RecyclerView.Adapter<TextAdapter.ViewHolder> {
    private Context context;
    private List<TextBean.DataBeanX.DataBean> list;


    public TextAdapter(Context context, List<TextBean.DataBeanX.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item3_type, parent, false);
        return new ViewHolder(inflate);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TextBean.DataBeanX.DataBean dataBean = list.get(position);
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.circleCrop();
        Glide.with(context).load(dataBean.getAuthor().getAvatar()).apply(requestOptions).into(holder.mTxIv);
        holder.mNameTv.setText(dataBean.getAuthor().getName());
        holder.mJjTv.setText(dataBean.getFeeds_text()+"");

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
         ImageView mTxIv;
         TextView mNameTv;
         TextView mJjTv;
         TextView mDzTv;
         TextView mCTv;
         TextView mPlTv;
         TextView mFxTv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTxIv = (ImageView) itemView.findViewById(R.id.iv_tx);
            mNameTv = (TextView) itemView.findViewById(R.id.tv_name);
            mJjTv = (TextView) itemView.findViewById(R.id.tv_jj);
            mDzTv = (TextView) itemView.findViewById(R.id.tv_dz);
            mCTv = (TextView) itemView.findViewById(R.id.tv_c);
            mPlTv = (TextView) itemView.findViewById(R.id.tv_pl);
            mFxTv = (TextView) itemView.findViewById(R.id.tv_fx);
        }
    }
}
