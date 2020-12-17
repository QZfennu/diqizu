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


import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class RecyJiaoziAdapter extends RecyclerView.Adapter {
    private ArrayList<ShipinBeans.DataBeanX.DataBean> list;
    private Context context;

    public RecyJiaoziAdapter(ArrayList<ShipinBeans.DataBeanX.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_list_shipin, parent, false);
        return new ViewHolder_view(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder_view view = (ViewHolder_view) holder;
        view.text_name.setText(list.get(position).getAuthor().getName());
        view.text_title.setText(list.get(position).getAuthor().getName());
        view.jiaozi.setUp(list.get(position).getUrl(),JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL,list.get(position).getCreateTime());
        view.jiaozi.startVideo();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public static
    class ViewHolder_view extends RecyOneAdapter.ViewHolder {
        public View rootView;
        public ImageView image_touxiang;
        public TextView text_name;
        public TextView text_title;
        public JCVideoPlayerStandard jiaozi;
        public CheckBox but_zan;
        public CheckBox but_liuyan;
        public CheckBox but_cai;
        public CheckBox but_fenxiang;

        public ViewHolder_view(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.image_touxiang = (ImageView) rootView.findViewById(R.id.image_touxiang);
            this.text_name = (TextView) rootView.findViewById(R.id.text_name);
            this.text_title = (TextView) rootView.findViewById(R.id.text_title);
            this.jiaozi = (JCVideoPlayerStandard) rootView.findViewById(R.id.jiaozi);
            this.but_zan = (CheckBox) rootView.findViewById(R.id.but_zan);
            this.but_liuyan = (CheckBox) rootView.findViewById(R.id.but_liuyan);
            this.but_cai = (CheckBox) rootView.findViewById(R.id.but_cai);
            this.but_fenxiang = (CheckBox) rootView.findViewById(R.id.but_fenxiang);
        }

    }
}
