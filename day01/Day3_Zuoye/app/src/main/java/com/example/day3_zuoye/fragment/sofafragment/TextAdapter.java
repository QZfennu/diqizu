package com.example.day3_zuoye.fragment.sofafragment;

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
import com.example.day3_zuoye.R;
import com.example.day3_zuoye.bean.SofaTextBean;

import java.util.ArrayList;

class TextAdapter extends RecyclerView.Adapter {
    public ArrayList<SofaTextBean.DataDTOX.DataDTO> list;
    private Context context;

    public TextAdapter(ArrayList<SofaTextBean.DataDTOX.DataDTO> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_text, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder view = (ViewHolder) holder;
        SofaTextBean.DataDTOX.DataDTO dataDTO = list.get(position);
        Glide.with(context).load(dataDTO.getAuthor().getAvatar()).apply(new RequestOptions().circleCrop()).into(view.iv_sofatext_avatar);
        view.tv_sofatext_name.setText(dataDTO.getAuthor().getName());
        view.tv_sofatext_feeds.setText(dataDTO.getFeedsText() + "");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView iv_sofatext_avatar;
        public TextView tv_sofatext_name;
        public TextView tv_sofatext_feeds;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv_sofatext_avatar = (ImageView) rootView.findViewById(R.id.iv_sofatext_avatar);
            this.tv_sofatext_name = (TextView) rootView.findViewById(R.id.tv_sofatext_name);
            this.tv_sofatext_feeds = (TextView) rootView.findViewById(R.id.tv_sofatext_feeds);
        }

    }
}
