package com.example.xiaoshixun_zy.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.xiaoshixun_zy.R;
import com.example.xiaoshixun_zy.adapter.VpAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class TabFragment extends Fragment {
    private TabLayout mTabT;
    private ViewPager mVpT;
    private ArrayList<Fragment> fragments;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.tab_fragment, null);
        initView(view);
        return view;
    }

    private void initView(@NonNull final View itemView) {
        mTabT = (TabLayout) itemView.findViewById(R.id.t_tab);
        mVpT = (ViewPager) itemView.findViewById(R.id.t_vp);

        fragments = new ArrayList<>();
        ItemFragmenr itemFragmenr = new ItemFragmenr();
        PlayFragment playFragment = new PlayFragment();
        Item2Fragment item2Fragment = new Item2Fragment();

        fragments.add(itemFragmenr);
        fragments.add(playFragment);
        fragments.add(item2Fragment);

        mVpT.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
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

        mTabT.setupWithViewPager(mVpT);

        mTabT.setupWithViewPager(mVpT);
        mTabT.getTabAt(0).setText("图片");
        mTabT.getTabAt(1).setText("视频");
        mTabT.getTabAt(2).setText("文本");

    }
}
