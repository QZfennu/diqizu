package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.App;
import com.example.myapplication.R;
import com.example.myapplication.bean.DataBean;

import java.util.ArrayList;

public class LogAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<DataBean> list;

    public LogAdapter(Context context, ArrayList<DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new ViewHolder1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder1 holder1= (ViewHolder1) holder;
        holder1.title.setText(list.get(position).getTitle());
        holder1.text.setText(list.get(position).getIntro());
        Glide.with(context).load(list.get(position).getIcon()).into(holder1.img);
        holder1.but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = holder1.but.getText().toString();
                    holder1.but.setText("已关注");
                    long insert = App.getmDaoSession().getDataBeanDao().insert(list.get(position));
                    if (insert>0){
                        Toast.makeText(context, "已关注", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder1 extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView img;
        public TextView title;
        public TextView text;
        public Button but;

        public ViewHolder1(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.img = (ImageView) rootView.findViewById(R.id.img);
            this.title = (TextView) rootView.findViewById(R.id.title);
            this.text = (TextView) rootView.findViewById(R.id.text);
            this.but = (Button) rootView.findViewById(R.id.but);
        }

    }
}
