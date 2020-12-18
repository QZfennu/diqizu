package com.example.tongpao;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.tongpao.adapter.AdapterPager;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class PaoziActivity extends AppCompatActivity {

    private Toolbar toolbar_qiandao;
    private ViewPager viewpage_qiandao;
    private TabLayout table_one;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paozi);
        initView();
    }

    private void initView() {
        table_one = (TabLayout) findViewById(R.id.table_one);
        toolbar_qiandao = (Toolbar) findViewById(R.id.toolbar_qiandao);
        toolbar_qiandao.setTitle("签到");
        toolbar_qiandao.setTitleMargin(300, 0, 0, 0);
        viewpage_qiandao = (ViewPager) findViewById(R.id.viewpage_qiandao);

        ArrayList<Fragment> list = new ArrayList<>();
        list.add(new oneFragment());
        list.add(new oneFragment());
        list.add(new oneFragment());

        AdapterPager adapterPager = new AdapterPager(getSupportFragmentManager(), list);
        viewpage_qiandao.setAdapter(adapterPager);
       table_one.setupWithViewPager(viewpage_qiandao);

    }
}