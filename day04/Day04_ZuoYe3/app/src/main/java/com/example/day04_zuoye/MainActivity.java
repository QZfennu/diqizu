package com.example.day04_zuoye;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.day04_zuoye.fragment.FindFragment;
import com.example.day04_zuoye.fragment.HomeFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager vp_main;
    private TabLayout tab_main;
    private MainAdapter mainAdapter;
    private Toolbar toolbar_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        vp_main = (ViewPager) findViewById(R.id.vp_main);
        tab_main = (TabLayout) findViewById(R.id.tab_main);
        toolbar_main = (Toolbar) findViewById(R.id.toolbar_main);
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new FindFragment());
        fragments.add(new HomeFragment());
        fragments.add(new HomeFragment());
        fragments.add(new HomeFragment());
        ArrayList<String> strings = new ArrayList<>();
        strings.add("首页");
        strings.add("发现");
        strings.add("");
        strings.add("商城");
        strings.add("我的");
        mainAdapter = new MainAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, fragments, strings);
        vp_main.setAdapter(mainAdapter);
        tab_main.setupWithViewPager(vp_main);
        for (int i = 0; i < tab_main.getTabCount(); i++) {
            tab_main.getTabAt(i).setIcon(R.drawable.select_tab);
        }
        tab_main.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                toolbar_main.setTitle(tab.getText());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
