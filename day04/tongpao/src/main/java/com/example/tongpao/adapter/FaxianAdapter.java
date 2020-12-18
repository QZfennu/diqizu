package com.example.tongpao.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.tongpao.PaoziActivity;
import com.example.tongpao.R;
import com.example.tongpao.beans.FenleidaohangBeans;
import com.example.tongpao.beans.HuodongRecyBeans;

import java.util.ArrayList;

public class FaxianAdapter extends RecyclerView.Adapter implements View.OnClickListener {
    private ArrayList<FenleidaohangBeans.DataBean> paelist;
    private ArrayList<HuodongRecyBeans.DataBean> huodonglist;
    private Context context;
    private FrameRecyAdpater recy1;

    public FaxianAdapter(ArrayList<FenleidaohangBeans.DataBean> paelist, ArrayList<HuodongRecyBeans.DataBean> huodonglist, Context context, FrameRecyAdpater recy1) {
        this.paelist = paelist;
        this.huodonglist = huodonglist;
        this.context = context;
        this.recy1 = recy1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 1) {
            View one = LayoutInflater.from(context).inflate(R.layout.layout_one_list, parent, false);
            return new ViewHolder_one(one);
        }
        if (viewType==2){
            View view = LayoutInflater.from(context).inflate(R.layout.layout_two_list, parent, false);
            return new ViewHolder_two(view);
        }
       if (viewType==3){
           View huodong = LayoutInflater.from(context).inflate(R.layout.layout_three_list, parent, false);
           return new ViewHolder_recy(huodong);
       }

       return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int type = getItemViewType(position);
        if (type==1){
            ViewHolder_one one = (ViewHolder_one) holder;
            one.image_pai.setOnClickListener(this);
            one.image_paozi.setOnClickListener(this);
            one.image_shetuan.setOnClickListener(this);
            Glide.with(context) .load(R.drawable.icon).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(one.image_pai);
            Glide.with(context) .load(R.drawable.icon).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(one.image_paozi);
            Glide.with(context) .load(R.drawable.icon).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(one.image_shetuan);
        }
        if (type==2){
            ViewHolder_two two = (ViewHolder_two) holder;
            two.text_green.setText("更多活动");
        }
        if (type==3){
            ViewHolder_recy recy = (ViewHolder_recy) holder;
            LinearLayoutManager manager = new LinearLayoutManager(context);
            manager.setOrientation(RecyclerView.HORIZONTAL);
            recy.recy_huodong.setLayoutManager(manager);
           recy.recy_huodong.setAdapter(recy1);

        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0) {
            return 1;
        }
        if (position==1){
            return 2;
        }
       if (position== 2){
           return  3 ;
       }

       return 5;
    }

    @Override
    public int getItemCount() {
        return  3;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.image_paozi:

                break;
            case R.id.image_shetuan:
                context.startActivity(new Intent(context, PaoziActivity.class));
                break;
            case  R.id.image_pai:
                break;
        }
    }

    public static
    class ViewHolder_one extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView image_paozi;
        public ImageView image_shetuan;
        public ImageView image_pai;

        public ViewHolder_one(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.image_paozi = (ImageView) rootView.findViewById(R.id.image_paozi);
            this.image_shetuan = (ImageView) rootView.findViewById(R.id.image_shetuan);
            this.image_pai = (ImageView) rootView.findViewById(R.id.image_pai);
        }

    }

    public static
    class ViewHolder_two extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView text_green;

        public ViewHolder_two(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.text_green = (TextView) rootView.findViewById(R.id.text_green);
        }

    }

    public static
    class ViewHolder_recy extends RecyclerView.ViewHolder {
        public View rootView;
        public RecyclerView recy_huodong;

        public ViewHolder_recy(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.recy_huodong = (RecyclerView) rootView.findViewById(R.id.recy_huodong);
        }

    }

}
