package com.example.day04_zuoye;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

class MainAdapter extends FragmentStatePagerAdapter {
    private ArrayList<Fragment> fragments;
    private ArrayList<String> strings;

    public MainAdapter(FragmentManager supportFragmentManager, int behaviorResumeOnlyCurrentFragment, ArrayList<Fragment> fragments, ArrayList<String> strings) {
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
        return strings.get(position);
    }
}
