package com.example.day04_zuoye.fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.day04_zuoye.bean.ClassifyBean;

import java.util.ArrayList;

class FindVpAdapter extends FragmentStatePagerAdapter {
    public ArrayList<Fragment> fragments;
    public ArrayList<ClassifyBean.DataDTO> strings;

    public FindVpAdapter(FragmentManager supportFragmentManager, int behaviorResumeOnlyCurrentFragment, ArrayList<Fragment> fragments, ArrayList<ClassifyBean.DataDTO> strings) {
        super(supportFragmentManager,behaviorResumeOnlyCurrentFragment);
        this.fragments = fragments;
        this.strings = strings;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return strings.get(position).getName();
    }
}
