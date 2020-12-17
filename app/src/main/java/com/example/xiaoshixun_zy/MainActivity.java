package com.example.xiaoshixun_zy;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.xiaoshixun_zy.adapter.VpAdapter;
import com.example.xiaoshixun_zy.fragment.Item2Fragment;
import com.example.xiaoshixun_zy.fragment.ItemFragmenr;
import com.example.xiaoshixun_zy.fragment.PlayFragment;
import com.example.xiaoshixun_zy.fragment.TabFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TabLayout tab;
    private ViewPager vp;
    private ArrayList<Fragment> list;
    private VpAdapter vpAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }


    private void initView() {
        tab = (TabLayout) findViewById(R.id.tab);
        vp = (ViewPager) findViewById(R.id.vp);
        list = new ArrayList<>();
        list.add(new ItemFragmenr());
        list.add(new PlayFragment());
        list.add(new Item2Fragment());
        list.add(new TabFragment());
        vpAdapter = new VpAdapter(getSupportFragmentManager(), list);
        vp.setAdapter(vpAdapter);
        tab.setupWithViewPager(vp);
//        tab.addTab(tab.newTab().setText("首页").setIcon(R.drawable.yuan));
//        tab.addTab(tab.newTab().setText("沙发").setIcon(R.drawable.yuan2));
//        tab.addTab(tab.newTab().setIcon(R.drawable.yuan5));
//        tab.addTab(tab.newTab().setText("发现").setIcon(R.drawable.yuan3));
//        tab.addTab(tab.newTab().setText("我的").setIcon(R.drawable.yuan4));
        tab.getTabAt(0).setText("首页").setIcon(R.drawable.yuan);;
        tab.getTabAt(1).setText("沙发").setIcon(R.drawable.yuan2);
//        tab.getTabAt(2).setIcon(R.drawable.yuan5);
        tab.getTabAt(3).setText("发现").setIcon(R.drawable.yuan3);
        tab.getTabAt(2).setText("我的").setIcon(R.drawable.yuan4);

    }
}
