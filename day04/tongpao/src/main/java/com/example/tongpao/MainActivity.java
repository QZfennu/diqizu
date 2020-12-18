package com.example.tongpao;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.tongpao.adapter.FaxianFragment;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private FrameLayout frame;
    private TabLayout table_main;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        frame = (FrameLayout) findViewById(R.id.frame);
        table_main = (TabLayout) findViewById(R.id.table_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame,new FaxianFragment()).commit();
        table_main.addTab(table_main.newTab().setText("首页").setIcon(R.drawable.home1));
        table_main.addTab(table_main.newTab().setText("发现").setIcon(R.drawable.faxian1));
        table_main.addTab(table_main.newTab().setText("").setIcon(R.drawable.add1));
        table_main.addTab(table_main.newTab().setText("商城").setIcon(R.drawable.shangcheng1));
        table_main.addTab(table_main.newTab().setText("我的").setIcon(R.drawable.my1));

    }
}
