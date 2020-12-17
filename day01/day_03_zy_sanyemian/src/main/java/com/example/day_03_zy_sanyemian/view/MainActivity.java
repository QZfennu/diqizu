package com.example.day_03_zy_sanyemian.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.day_03_zy_sanyemian.R;
import com.example.day_03_zy_sanyemian.view.fragment.FireeFragment;
import com.example.day_03_zy_sanyemian.view.fragment.FiveFragment;
import com.example.day_03_zy_sanyemian.view.fragment.OneFragment;
import com.example.day_03_zy_sanyemian.view.fragment.ThreeFragment;
import com.example.day_03_zy_sanyemian.view.fragment.TwoFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager mVp;
    private TabLayout mTab;
    private ArrayList<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mVp = (ViewPager) findViewById(R.id.mVp);
        mTab = (TabLayout) findViewById(R.id.mTab);

        fragments = new ArrayList<>();
        fragments.add(new OneFragment());
        fragments.add(new TwoFragment());
        fragments.add(new ThreeFragment());
        fragments.add(new FireeFragment());
        fragments.add(new FiveFragment());
        mVp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
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
        mTab.setupWithViewPager(mVp);
        mTab.getTabAt(0).setText("首页").setIcon(R.drawable.icon_tab_home);
        mTab.getTabAt(1).setText("沙发").setIcon(R.drawable.icon_tab_sofa);
        mTab.getTabAt(2).setText("").setIcon(R.drawable.icon_tab_publish);
        mTab.getTabAt(3).setText("发现").setIcon(R.drawable.icon_tab_find);
        mTab.getTabAt(4).setText("我的").setIcon(R.drawable.icon_tab_mine);
    }
}
