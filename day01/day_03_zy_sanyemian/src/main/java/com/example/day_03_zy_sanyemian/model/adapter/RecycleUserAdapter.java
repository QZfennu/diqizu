package com.example.day_03_zy_sanyemian.model.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.day_03_zy_sanyemian.R;
import com.example.day_03_zy_sanyemian.db.App;
import com.example.day_03_zy_sanyemian.model.bean.DataBean;

import java.util.ArrayList;

public class RecycleUserAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<DataBean> dataUser;

    public RecycleUserAdapter(Context context, ArrayList<DataBean> dataUser) {
        this.context = context;
        this.dataUser = dataUser;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.usser_layout, null);
        return new Holder1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Holder1 holder1 = (Holder1) holder;

        //图片
        Glide.with(context).load(dataUser.get(position).getIcon()).apply(new RequestOptions().circleCrop()).into(holder1.mIv);
        holder1.mTv1.setText(dataUser.get(position).getTitle());
        holder1.mTv2.setText(dataUser.get(position).getIntro());
        holder1.bt_guanzhu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long insert = App.getDaoSession().getDataBeanDao().insert(dataUser.get(position));
                if(insert>0){
                    Toast.makeText(context, "收藏成功", Toast.LENGTH_SHORT).show();
                    holder1.bt_guanzhu.setText("已关注");
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return dataUser.size();
    }

    public static
    class Holder1 extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView mIv;
        public TextView mTv1;
        public TextView mTv2;
        public Button bt_guanzhu;
        public Holder1(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.mIv = (ImageView) rootView.findViewById(R.id.mIv);
            this.mTv1 = (TextView) rootView.findViewById(R.id.mTv1);
            this.mTv2 = (TextView) rootView.findViewById(R.id.mTv2);
            this.bt_guanzhu = (Button) rootView.findViewById(R.id.bt_guanzhu);

        }

    }


}
