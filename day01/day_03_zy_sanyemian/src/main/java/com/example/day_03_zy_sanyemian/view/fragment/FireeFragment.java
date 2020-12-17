package com.example.day_03_zy_sanyemian.view.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.day_03_zy_sanyemian.R;
import com.example.day_03_zy_sanyemian.view.userfragment.OneUserFragment;
import com.example.day_03_zy_sanyemian.view.userfragment.TwoUserFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FireeFragment extends Fragment {


    private TabLayout mTabuser;
    private ViewPager mVpuser;
    private ArrayList<Fragment> fragments;

    public FireeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_firee, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mTabuser = view.findViewById(R.id.mTabuser);
        mVpuser = view.findViewById(R.id.mVpuser);
        fragments = new ArrayList<>();
        fragments.add(new OneUserFragment());
        fragments.add(new TwoUserFragment());
        mVpuser.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
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
        mTabuser.setupWithViewPager(mVpuser);
        mTabuser.getTabAt(0).setText("关注");
        mTabuser.getTabAt(1).setText("推荐");
    }

}
