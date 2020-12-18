package com.example.mengshiyun1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.mengshiyun1.fragment.LevelFragment;
import com.example.mengshiyun1.fragment.MoneyFragment;
import com.example.mengshiyun1.fragment.SignFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class PaiActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tab;
    private ViewPager vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pai);
        initView();
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        tab = (TabLayout) findViewById(R.id.tab);
        vp = (ViewPager) findViewById(R.id.vp);
        final ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new LevelFragment());
        fragments.add(new SignFragment());
        fragments.add(new MoneyFragment());
        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
        tab.setupWithViewPager(vp);
        tab.getTabAt(0).setText("经验榜");
        tab.getTabAt(1).setText("签到榜");
        tab.getTabAt(2).setText("土豪榜");
    }
}
