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
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class RecyOneAdapter extends RecyclerView.Adapter {
    private ArrayList<ImageBeans.DataBeanX.DataBean> list;
    private Context context;

    public RecyOneAdapter(ArrayList<ImageBeans.DataBeanX.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_one_item, parent, false);

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder view = (ViewHolder) holder;
        view.text_name.setText(list.get(position).getAuthor().getName());
        view.text_title.setText(list.get(position).getFeeds_text());
        Glide.with(context).load(list.get(position).getCover()).into(view.image_i_one);//设置图片
        Glide.with(context).load(list.get(position).getAuthor().getAvatar())
                .apply(RequestOptions.bitmapTransform(new CircleCrop())).into(view.image_touxiang);//设置头像
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public static
    class ViewHolder  extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView image_touxiang;
        public TextView text_name;
        public TextView text_title;
        public ImageView image_i_one;
        public CheckBox but_zan;
        public CheckBox but_liuyan;
        public CheckBox but_cai;
        public CheckBox but_fenxiang;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.image_touxiang = (ImageView) rootView.findViewById(R.id.image_touxiang);
            this.text_name = (TextView) rootView.findViewById(R.id.text_name);
            this.text_title = (TextView) rootView.findViewById(R.id.text_title);
            this.image_i_one = (ImageView) rootView.findViewById(R.id.image_i_one);
            this.but_zan = (CheckBox) rootView.findViewById(R.id.but_zan);
            this.but_liuyan = (CheckBox) rootView.findViewById(R.id.but_liuyan);
            this.but_cai = (CheckBox) rootView.findViewById(R.id.but_cai);
            this.but_fenxiang = (CheckBox) rootView.findViewById(R.id.but_fenxiang);
        }

    }
}

