package com.example.myapplication.adapter;

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
import com.example.myapplication.R;
import com.example.myapplication.bean.PiceBean;

import java.util.ArrayList;

public class PiceAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<PiceBean.DataBeanX.DataBean> list;

    public PiceAdapter(Context context, ArrayList<PiceBean.DataBeanX.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.pice_item, parent, false);
        return new ViewHolder1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder1 holder1= (ViewHolder1) holder;
        holder1.title.setText(list.get(position).getFeeds_text());
        Glide.with(context).load(list.get(position).getAuthor().getAvatar()).apply(new RequestOptions().circleCrop()).into(holder1.img);
        Glide.with(context).load(list.get(position).getCover()).into(holder1.pic);
        holder1.name.setText(list.get(position).getAuthor().getName());
        holder1.text.setText(list.get(position).getActivityText());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder1 extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView img;
        public TextView name;
        public TextView title;
        public ImageView pic;
        public TextView text;

        public ViewHolder1(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.img = (ImageView) rootView.findViewById(R.id.img);
            this.name = (TextView) rootView.findViewById(R.id.name);
            this.title = (TextView) rootView.findViewById(R.id.title);
            this.pic = (ImageView) rootView.findViewById(R.id.pic);
            this.text = (TextView) rootView.findViewById(R.id.text);
        }

    }
}
