package com.example.demo4.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo4.Api.ApiService;
import com.example.demo4.Bean.MpBean;
import com.example.demo4.Bean.PnBean;
import com.example.demo4.R;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SPFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SPFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView mRecycler;
    private List<MpBean.DataBeanX.DataBean> list;
    private SpAdapter spAdapter;

    public SPFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SPFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SPFragment newInstance(String param1, String param2) {
        SPFragment fragment = new SPFragment();
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
        View inflate = inflater.inflate(R.layout.fragment_s_p, container, false);
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {
        new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(ApiService.baseUrkb)
                .build()
                .create(ApiService.class)
                .getb()
                .subscribeOn( Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MpBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MpBean mpBean) {
                        List<MpBean.DataBeanX.DataBean> data = mpBean.getData().getData();
                        list.addAll(data);
                        spAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    private void initView(@NonNull final View itemView) {
        mRecycler = (RecyclerView) itemView.findViewById(R.id.recycler);
        mRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        list = new ArrayList<>();
        spAdapter = new SpAdapter(getActivity(),list);
        mRecycler.setAdapter(spAdapter);
    }
}