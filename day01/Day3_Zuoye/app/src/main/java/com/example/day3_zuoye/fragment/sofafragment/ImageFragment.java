package com.example.day3_zuoye.fragment.sofafragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.day3_zuoye.R;
import com.example.day3_zuoye.bean.SofaImageBean;
import com.example.day3_zuoye.presenter.MyPresenter;
import com.example.day3_zuoye.view.MyView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ImageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ImageFragment extends Fragment implements MyView {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private SofaImageAdapter sofaImageAdapter;
    private MyPresenter myPresenter;

    public ImageFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ImageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ImageFragment newInstance(String param1, String param2) {
        ImageFragment fragment = new ImageFragment();
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
        View inflate = inflater.inflate(R.layout.fragment_image, container, false);
        myPresenter = new MyPresenter(this);
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {
        int pagecount = 12;
        String feed = "pics";
        myPresenter.getSofaImage(pagecount,feed);
    }

    private void initView(View inflate) {
        RecyclerView rv_sofaimage = inflate.findViewById(R.id.rv_sofaimage);
        ArrayList<SofaImageBean.DataDTOX.DataDTO> list = new ArrayList<>();
        sofaImageAdapter = new SofaImageAdapter(list,getActivity());
        rv_sofaimage.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv_sofaimage.setAdapter(sofaImageAdapter);
        rv_sofaimage.addItemDecoration(new DividerItemDecoration(getActivity(),1));
    }

    @Override
    public void onSuccess(Object bean) {
        if (bean instanceof SofaImageBean){
            SofaImageBean sofaImageBean = (SofaImageBean) bean;
            sofaImageAdapter.list.addAll(sofaImageBean.getData().getData());
            sofaImageAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onFiled(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }
}
