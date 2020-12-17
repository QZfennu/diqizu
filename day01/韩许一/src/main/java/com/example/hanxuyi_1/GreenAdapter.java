package com.example.hanxuyi_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class GreenAdapter extends RecyclerView.Adapter {
    private ArrayList<GreenBeans.DataBeanX.DataBean> list;
    private Context context;

    public GreenAdapter(ArrayList<GreenBeans.DataBeanX.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_green_list, parent, false);

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder view = (ViewHolder) holder;
        view.green_name.setText(list.get(position).getTitle());
        view.green_title.setText(list.get(position).getIntro());
        Glide.with(context).load(list.get(position).getIcon()).into(view.image_green);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder extends WebRecyAdapter.ViewHolder {
        public View rootView;
        public ImageView image_green;
        public TextView green_name;
        public TextView green_title;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.image_green = (ImageView) rootView.findViewById(R.id.image_green);
            this.green_name = (TextView) rootView.findViewById(R.id.green_name);
            this.green_title = (TextView) rootView.findViewById(R.id.green_title);
        }

    }
}
