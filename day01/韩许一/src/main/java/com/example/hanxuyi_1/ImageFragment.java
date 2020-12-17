package com.example.hanxuyi_1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;


public class ImageFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_image, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(View view) {
        TabLayout table = view.findViewById(R.id.table_image);
        ViewPager vp =view.findViewById(R.id.viewpage_image);
        ArrayList<Fragment> list = new ArrayList<>();
        list.add(new ShipinFragment());
        list.add(new Recy_one_Fragment());
        list.add(new WebFragment());
        ImVpAdapter imVpAdapter = new ImVpAdapter(getChildFragmentManager(), list);
        vp.setAdapter(imVpAdapter);
        table.setupWithViewPager(vp);

    }
}