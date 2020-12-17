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
import com.example.day_03_zy_sanyemian.view.qtfragment.ImgFragment;
import com.example.day_03_zy_sanyemian.view.qtfragment.TextFragment;
import com.example.day_03_zy_sanyemian.view.qtfragment.VideoFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TwoFragment extends Fragment {


    private TabLayout mTabs;
    private ViewPager mVps;

    public TwoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {

        mTabs = view.findViewById(R.id.mTabs);
        mVps = view.findViewById(R.id.mVps);

        final ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new ImgFragment());
        fragments.add(new VideoFragment());
        fragments.add(new TextFragment());

        mVps.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
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
        mTabs.setupWithViewPager(mVps);
        mTabs.getTabAt(0).setText("图片");
        mTabs.getTabAt(2).setText("文本");
        mTabs.getTabAt(1).setText("视频");

    }

}
