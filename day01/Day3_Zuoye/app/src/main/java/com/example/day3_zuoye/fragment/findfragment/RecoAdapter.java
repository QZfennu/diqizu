package com.example.day3_zuoye.fragment.findfragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.day3_zuoye.R;
import com.example.day3_zuoye.app.BaseApp;
import com.example.day3_zuoye.bean.DataDTO;
import com.example.day3_zuoye.bean.RecoBean;

import java.util.ArrayList;

class RecoAdapter extends RecyclerView.Adapter {
    public ArrayList<DataDTO> list;
    private Context context;
    public ArrayList<Boolean> booleans;

    public RecoAdapter(ArrayList<DataDTO> list, Context context,ArrayList<Boolean> booleans) {
        this.list = list;
        this.context = context;
        this.booleans = booleans;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_reco, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder view = (ViewHolder) holder;
        DataDTO dataDTO = list.get(position);
        Glide.with(context).load(dataDTO.getIcon()).into(view.iv_reco);
        view.tv_intro.setText(dataDTO.getIntro());
        view.tv_title.setText(dataDTO.getTitle());
        Boolean aBoolean = dataDTO.getHasFollow();
        if (aBoolean){
            view.btn_reco.setText("已关注");
        }else {
            view.btn_reco.setText("关注");
        }
        view.btn_reco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (aBoolean){
                    dataDTO.setHasFollow(false);
                    notifyDataSetChanged();
                    BaseApp.getsInstance()
                            .getDaoSession()
                            .getDataDTODao()
                            .delete(list.get(position));
                }else {
                    dataDTO.setHasFollow(true);
                    notifyDataSetChanged();
                    BaseApp.getsInstance()
                            .getDaoSession()
                            .getDataDTODao()
                            .insertOrReplace(list.get(position));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView iv_reco;
        public TextView tv_title;
        public TextView tv_intro;
        public Button btn_reco;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv_reco = (ImageView) rootView.findViewById(R.id.iv_reco);
            this.tv_title = (TextView) rootView.findViewById(R.id.tv_title);
            this.tv_intro = (TextView) rootView.findViewById(R.id.tv_intro);
            this.btn_reco = (Button) rootView.findViewById(R.id.btn_reco);
        }

    }
}
