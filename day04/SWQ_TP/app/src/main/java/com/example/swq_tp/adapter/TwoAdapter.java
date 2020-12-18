package com.example.swq_tp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.swq_tp.R;
import com.example.swq_tp.bean.ReBean;

import java.util.ArrayList;

public class TwoAdapter extends RecyclerView.Adapter{
    private Context context;
    private ArrayList<ReBean.DataBean> reBeans;

    public TwoAdapter(Context context, ArrayList<ReBean.DataBean> reBeans) {
        this.context = context;
        this.reBeans = reBeans;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View three = LayoutInflater.from(context).inflate(R.layout.layout_three, parent, false);
        return new ThreeHolder(three);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ThreeHolder threeHolder = (ThreeHolder) holder;
        Glide.with(context).load(reBeans.get(position).getCover()).into(threeHolder.three_img);
        threeHolder.three_text.setText(reBeans.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return reBeans.size();
    }
    public static
    class ThreeHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView three_img;
        public TextView three_text;

        public ThreeHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.three_img = (ImageView) rootView.findViewById(R.id.three_img);
            this.three_text = (TextView) rootView.findViewById(R.id.three_text);
        }

    }
}
