package com.example.hanxuyi_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class WebRecyAdapter extends RecyclerView.Adapter {
    private ArrayList<WebBeans.DataBeanX.DataBean> list;
    private Context context;

    public WebRecyAdapter(ArrayList<WebBeans.DataBeanX.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_list_wev, parent, false);

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            ViewHolder view = (ViewHolder) holder;
            Glide.with(context).load(list.get(position).getAuthor().getAvatar()).into(view.image_web);
            view.text_web_name.setText(list.get(position).getAuthor().getName());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder extends RecyOneAdapter.ViewHolder {
        public View rootView;
        public ImageView image_web;
        public TextView text_web_name;
        public CheckBox but_zan;
        public CheckBox but_liuyan;
        public CheckBox but_cai;
        public CheckBox but_fenxiang;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.image_web = (ImageView) rootView.findViewById(R.id.image_web);
            this.text_web_name = (TextView) rootView.findViewById(R.id.text_web_name);
            this.but_zan = (CheckBox) rootView.findViewById(R.id.but_zan);
            this.but_liuyan = (CheckBox) rootView.findViewById(R.id.but_liuyan);
            this.but_cai = (CheckBox) rootView.findViewById(R.id.but_cai);
            this.but_fenxiang = (CheckBox) rootView.findViewById(R.id.but_fenxiang);
        }

    }
}
