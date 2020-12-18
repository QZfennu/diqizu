package com.example.tongpao.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.tongpao.R;
import com.example.tongpao.beans.OneqianBenas;

import java.util.ArrayList;

public class OneRecyAdapter extends RecyclerView.Adapter {
    private ArrayList<OneqianBenas.DataBean.ExpTopBean.ListBean> list;
    private Context context;

    public OneRecyAdapter(ArrayList<OneqianBenas.DataBean.ExpTopBean.ListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_recy_one_qiandao, parent, false);

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder view = (ViewHolder) holder;
        Glide.with(context).load(list.get(position).getHeadUrl()).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(view.image_one_touxiang);
        view.text_name_one.setText(list.get(position).getNickName());
        view.text_dizhi_one.setText(list.get(position).getDays());
        view.text_jingyan_one.setText(list.get(position).getProvince()+""+list.get(position).getCity());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView image_one_qian;
        public ImageView image_one_touxiang;
        public TextView text_name_one;
        public TextView text_dizhi_one;
        public TextView text_jingyan_one;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.image_one_qian = (ImageView) rootView.findViewById(R.id.image_one_qian);
            this.image_one_touxiang = (ImageView) rootView.findViewById(R.id.image_one_touxiang);
            this.text_name_one = (TextView) rootView.findViewById(R.id.text_name_one);
            this.text_dizhi_one = (TextView) rootView.findViewById(R.id.text_dizhi_one);
            this.text_jingyan_one = (TextView) rootView.findViewById(R.id.text_jingyan_one);
        }

    }
}
