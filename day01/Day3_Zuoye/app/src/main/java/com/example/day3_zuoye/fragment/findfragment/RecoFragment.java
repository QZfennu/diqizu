package com.example.day3_zuoye.fragment.findfragment;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.day3_zuoye.R;
import com.example.day3_zuoye.bean.DataDTO;
import com.example.day3_zuoye.bean.RecoBean;
import com.example.day3_zuoye.net.ApiService;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RecoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RecoFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecoAdapter recoAdapter;

    public RecoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RecoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RecoFragment newInstance(String param1, String param2) {
        RecoFragment fragment = new RecoFragment();
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
        View inflate = inflater.inflate(R.layout.fragment_reco, container, false);
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {
        new Retrofit.Builder()
                .baseUrl(ApiService.findUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService.class)
                .getReco()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<RecoBean>() {
                    @SuppressLint("CheckResult")
                    @Override
                    public void onNext(RecoBean recoBean) {
                        List<DataDTO> data = recoBean.getData().getData();
                        for (int i = 0; i <data.size(); i++) {
                            recoAdapter.booleans.add(false);
                        }
                        recoAdapter.list.addAll(data);
                        recoAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void initView(View inflate) {
        RecyclerView rv_reco = inflate.findViewById(R.id.rv_reco);
        rv_reco.setLayoutManager(new LinearLayoutManager(getActivity()));
        ArrayList<DataDTO> list = new ArrayList<>();
        ArrayList<Boolean> booleans = new ArrayList<>();
        recoAdapter = new RecoAdapter(list, getActivity(),booleans);
        rv_reco.setAdapter(recoAdapter);
    }
}