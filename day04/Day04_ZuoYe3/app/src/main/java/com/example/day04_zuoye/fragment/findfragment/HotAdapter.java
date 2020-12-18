package com.example.day04_zuoye.fragment.findfragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.day04_zuoye.R;
import com.example.day04_zuoye.bean.HotBean;

import java.util.ArrayList;

class HotAdapter extends RecyclerView.Adapter {
    private static final int IMTE_A = 0;
    private static final int IMTE_B = 1;
    private static final int IMTE_C = 2;
    public ArrayList<HotBean.DataDTO.ListDTO> list;
    private Context context;

    public HotAdapter(ArrayList<HotBean.DataDTO.ListDTO> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        return position % 3;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        int type = getItemViewType(viewType);
        switch (type) {
            case IMTE_A:
                View view1 = LayoutInflater.from(context).inflate(R.layout.item_rv1, parent, false);
                return new ViewHolder1(view1);
            case IMTE_B:
                View view2 = LayoutInflater.from(context).inflate(R.layout.item_rv2, parent, false);
                return new ViewHolder2(view2);
            case IMTE_C:
                View view3 = LayoutInflater.from(context).inflate(R.layout.item_rv3, parent, false);
                return new ViewHolder3(view3);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int type = getItemViewType(position);
        HotBean.DataDTO.ListDTO listDTO = list.get(position);
        switch (type){
            case IMTE_A:
                ViewHolder1 view1 = (ViewHolder1) holder;
                Glide.with(context).load(listDTO.getFilePathList().get(0).getFilePath()).into(view1.iv_rv11);
                Glide.with(context).load(listDTO.getFilePathList().get(1).getFilePath()).into(view1.iv_rv12);
                Glide.with(context).load(listDTO.getFilePathList().get(2).getFilePath()).into(view1.iv_rv13);
                view1.tv_rv1.setText(listDTO.getTitle());
                view1.tv_rv12.setText(listDTO.getCreateTime());
                break;
            case IMTE_B:
                ViewHolder2 view2 = (ViewHolder2) holder;
                Glide.with(context).load(listDTO.getFilePathList().get(0).getFilePath()).into(view2.iv_rv2);
                view2.tv_rv21.setText(listDTO.getTitle());
                view2.tv_rv22.setText(listDTO.getCreateTime());
                break;
            case IMTE_C:
                ViewHolder3 view3 = (ViewHolder3) holder;
                view3.tv_rv33.setText(listDTO.getTitle());
                view3.tv_rv34.setText(listDTO.getCreateTime());
                break;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder1 extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView tv_rv1;
        public ImageView iv_rv11;
        public ImageView iv_rv12;
        public ImageView iv_rv13;
        public LinearLayout ll_rv;
        public TextView tv_rv12;

        public ViewHolder1(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.tv_rv1 = (TextView) rootView.findViewById(R.id.tv_rv1);
            this.iv_rv11 = (ImageView) rootView.findViewById(R.id.iv_rv11);
            this.iv_rv12 = (ImageView) rootView.findViewById(R.id.iv_rv12);
            this.iv_rv13 = (ImageView) rootView.findViewById(R.id.iv_rv13);
            this.ll_rv = (LinearLayout) rootView.findViewById(R.id.ll_rv);
            this.tv_rv12 = (TextView) rootView.findViewById(R.id.tv_rv12);
        }

    }

    public static
    class ViewHolder2 extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView tv_rv21;
        public ImageView iv_rv2;
        public TextView tv_rv22;

        public ViewHolder2(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.tv_rv21 = (TextView) rootView.findViewById(R.id.tv_rv21);
            this.iv_rv2 = (ImageView) rootView.findViewById(R.id.iv_rv2);
            this.tv_rv22 = (TextView) rootView.findViewById(R.id.tv_rv22);
        }

    }

    public static
    class ViewHolder3 extends RecyclerView.ViewHolder{
        public View rootView;
        public TextView tv_rv33;
        public TextView tv_rv34;

        public ViewHolder3(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.tv_rv33 = (TextView) rootView.findViewById(R.id.tv_rv33);
            this.tv_rv34 = (TextView) rootView.findViewById(R.id.tv_rv34);
        }

    }
}
