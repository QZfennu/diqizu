package com.example.day3_zuoye.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.day3_zuoye.R;
import com.example.day3_zuoye.fragment.sofafragment.ImageFragment;
import com.example.day3_zuoye.fragment.sofafragment.TextFragment;
import com.example.day3_zuoye.fragment.sofafragment.VideoFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SofaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SofaFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private SofaAdapter sofaAdapter;

    public SofaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SofaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SofaFragment newInstance(String param1, String param2) {
        SofaFragment fragment = new SofaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_sofa, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        TabLayout tab_sofa = inflate.findViewById(R.id.tab_sofa);
        ViewPager vp_sofa = inflate.findViewById(R.id.vp_sofa);
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new ImageFragment());
        fragments.add(new VideoFragment());
        fragments.add(new TextFragment());
        ArrayList<String> strings = new ArrayList<>();
        strings.add("图片");
        strings.add("视频");
        strings.add("文字");
        sofaAdapter = new SofaAdapter(getActivity().getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,fragments,strings);
        vp_sofa.setAdapter(sofaAdapter);
        tab_sofa.setupWithViewPager(vp_sofa);
    }
}
