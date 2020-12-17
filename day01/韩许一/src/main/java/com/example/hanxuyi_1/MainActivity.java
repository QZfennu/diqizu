package com.example.hanxuyi_1;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private FrameLayout frame;
    private TabLayout table_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        frame = (FrameLayout) findViewById(R.id.frame);
        table_main = (TabLayout) findViewById(R.id.table_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame,new ImageFragment()).commit();
       table_main.addTab(table_main.newTab().setText("首页").setIcon(R.drawable.icon_tab_home));
       table_main.addTab(table_main.newTab().setText("沙发").setIcon(R.drawable.icon_tab_sofa));
       table_main.addTab(table_main.newTab().setText("").setIcon(R.drawable.icon_tab_publish));
       table_main.addTab(table_main.newTab().setText("发现").setIcon(R.drawable.icon_tab_find));
       table_main.addTab(table_main.newTab().setText("我的").setIcon(R.drawable.icon_tab_mine));
    }
}
