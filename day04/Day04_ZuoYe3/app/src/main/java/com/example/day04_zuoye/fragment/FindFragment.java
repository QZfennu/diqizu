package com.example.day04_zuoye.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.day04_zuoye.R;
import com.example.day04_zuoye.bean.ClassifyBean;
import com.example.day04_zuoye.bean.HotActivityBean;
import com.example.day04_zuoye.fragment.findfragment.HotFragment;
import com.example.day04_zuoye.fragment.findfragment.MeFragment;
import com.example.day04_zuoye.presenter.MyPresenter;
import com.example.day04_zuoye.view.MyView;
import com.google.android.material.tabs.TabLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FindFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FindFragment extends Fragment implements MyView {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    public RecyclerView rv_find1;
    public TabLayout tab_find;
    public ViewPager vp_find;
    public SmartRefreshLayout srl_find;
    private FindVpAdapter findVpAdapter;
    private FindRvAdapter findRvAdapter;
    private MyPresenter myPresenter;

    public FindFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FindFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FindFragment newInstance(String param1, String param2) {
        FindFragment fragment = new FindFragment();
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
        View inflate = inflater.inflate(R.layout.fragment_find, container, false);
        myPresenter = new MyPresenter(this);
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {
        myPresenter.getClassify();
        myPresenter.getHotActivity();
    }

    private void initView(View inflate) {
        rv_find1 = (RecyclerView) inflate.findViewById(R.id.rv_find1);
        tab_find = (TabLayout) inflate.findViewById(R.id.tab_find);
        vp_find = (ViewPager) inflate.findViewById(R.id.vp_find);
        srl_find = inflate.findViewById(R.id.srl_find);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false);
        rv_find1.setLayoutManager(linearLayoutManager);
        ArrayList<HotActivityBean.DataDTO> list = new ArrayList<>();
        findRvAdapter = new FindRvAdapter(list,getActivity());
        rv_find1.setAdapter(findRvAdapter);
    }

    @Override
    public void onSuccess(Object bean) {
        if (bean instanceof ClassifyBean){
            ClassifyBean classifyBean = (ClassifyBean) bean;
            ArrayList<Fragment> fragments = new ArrayList<>();

            fragments.add(HotFragment.newInstance(classifyBean.getData().get(0).getType()+"",null));
            fragments.add(HotFragment.newInstance(classifyBean.getData().get(1).getType()+"",null));
            fragments.add(HotFragment.newInstance(classifyBean.getData().get(2).getType()+"",null));
            fragments.add(new MeFragment());
            ArrayList<ClassifyBean.DataDTO> strings = new ArrayList<>();
            strings.addAll(classifyBean.getData());
            findVpAdapter = new FindVpAdapter(getActivity().getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,fragments,strings);
            vp_find.setAdapter(findVpAdapter);
            tab_find.setupWithViewPager(vp_find);
        }else if (bean instanceof HotActivityBean){
            HotActivityBean hotActivityBean = (HotActivityBean) bean;
            findRvAdapter.list.addAll(hotActivityBean.getData());
            findRvAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onFiled(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }
}
