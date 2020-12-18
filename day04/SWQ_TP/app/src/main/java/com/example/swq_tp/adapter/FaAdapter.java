package com.example.swq_tp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.swq_tp.R;
import com.example.swq_tp.bean.Re2Bean;
import com.example.swq_tp.bean.ReBean;

import java.util.ArrayList;

public class FaAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<ReBean.DataBean> reBeans;
    private ArrayList<Re2Bean.DataBean> re2Beans;

    private int ONE = 1;
    private int TWO = 2;
    private int FOUR = 3;

    public FaAdapter(Context context, ArrayList<ReBean.DataBean> reBeans,ArrayList<Re2Bean.DataBean> re2Beans) {
        this.context = context;
        this.reBeans = reBeans;
        this.re2Beans = re2Beans;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == ONE) {
            View one = LayoutInflater.from(context).inflate(R.layout.layout_one, parent, false);
            return new OneHolder(one);
        }
        if (viewType == TWO) {
            View two = LayoutInflater.from(context).inflate(R.layout.layout_two, parent, false);
            return new TwoHolder(two);
        }
            View four = LayoutInflater.from(context).inflate(R.layout.layout_four, parent, false);
            return new FourHolder(four);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int type = getItemViewType(position);
        if (type == ONE) {
            OneHolder oneHolder = (OneHolder) holder;
        }
        if (type == TWO) {
            TwoHolder twoHolder = (TwoHolder) holder;
            TwoAdapter twoAdapter = new TwoAdapter(context, reBeans);
            reBeans.addAll(reBeans);
            twoHolder.two_rel.setLayoutManager(new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false));
            twoHolder.two_rel.setAdapter(twoAdapter);
        }
        if (type == FOUR){
            FourHolder fourHolder = (FourHolder) holder;
            Glide.with(context).load(re2Beans.get(position).getHeadUrl()).into(fourHolder.four_img);
            Glide.with(context).load(re2Beans.get(position).getHeadUrl()).into(fourHolder.four_img2);
            Glide.with(context).load(re2Beans.get(position).getHeadUrl()).into(fourHolder.four_img3);
            Glide.with(context).load(re2Beans.get(position).getHeadUrl()).into(fourHolder.four_img4);
            fourHolder.four_text2.setText(re2Beans.get(position).getSocialTitle());
        }
    }

    @Override
    public int getItemCount() {
        return reBeans.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return ONE;
        }
        if (position == 1) {
            return TWO;
        }

        return FOUR;
    }

    public static
    class OneHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView one_img;
        public ImageView one_img2;
        public ImageView one_img3;

        public OneHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.one_img = (ImageView) rootView.findViewById(R.id.one_img);
            this.one_img2 = (ImageView) rootView.findViewById(R.id.one_img2);
            this.one_img3 = (ImageView) rootView.findViewById(R.id.one_img3);
        }

    }

    public static
    class TwoHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView two_text;
        public TextView two_text2;
        public RecyclerView two_rel;

        public TwoHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.two_text = (TextView) rootView.findViewById(R.id.two_text);
            this.two_text2 = (TextView) rootView.findViewById(R.id.two_text2);
            this.two_rel = (RecyclerView) rootView.findViewById(R.id.two_rel);
        }

    }

    public static
    class ThreeHolder extends RecyclerView.ViewHolder {
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

    public static
    class FourHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView four_img;
        public ImageView four_img2;
        public ImageView four_img3;
        public TextView four_text2;
        public ImageView four_img4;

        public FourHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.four_img = (ImageView) rootView.findViewById(R.id.four_img);
            this.four_img2 = (ImageView) rootView.findViewById(R.id.four_img2);
            this.four_img3 = (ImageView) rootView.findViewById(R.id.four_img3);
            this.four_text2 = (TextView) rootView.findViewById(R.id.four_text2);
            this.four_img4 = (ImageView) rootView.findViewById(R.id.four_img4);
        }

    }
}
