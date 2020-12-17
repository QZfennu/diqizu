package com.example.day3_zuoye;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.day3_zuoye.fragment.FindFragment;
import com.example.day3_zuoye.fragment.HomeFragment;
import com.example.day3_zuoye.fragment.SofaFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager vp_main;
    private TabLayout tab_main;
    private MainAdapter mainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        vp_main = (ViewPager) findViewById(R.id.vp_main);
        tab_main = (TabLayout) findViewById(R.id.tab_main);
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new SofaFragment());
        fragments.add(new HomeFragment());
        fragments.add(new FindFragment());
        fragments.add(new HomeFragment());
        ArrayList<String> strings = new ArrayList<>();
        strings.add("首页");
        strings.add("沙发");
        strings.add("");
        strings.add("发现");
        strings.add("我的");
        mainAdapter = new MainAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,fragments,strings);
        vp_main.setAdapter(mainAdapter);
        tab_main.setupWithViewPager(vp_main);
        tab_main.getTabAt(0).setIcon(R.drawable.icon_tab_home);
        tab_main.getTabAt(1).setIcon(R.drawable.icon_tab_sofa);
        tab_main.getTabAt(2).setIcon(R.drawable.icon_tab_publish);
        tab_main.getTabAt(3).setIcon(R.drawable.icon_tab_find);
        tab_main.getTabAt(4).setIcon(R.drawable.icon_tab_mine);
    }
}
