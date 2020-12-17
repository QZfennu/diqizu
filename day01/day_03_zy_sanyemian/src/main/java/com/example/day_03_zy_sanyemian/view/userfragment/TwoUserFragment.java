package com.example.day_03_zy_sanyemian.view.userfragment;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day_03_zy_sanyemian.R;
import com.example.day_03_zy_sanyemian.callback.ApiService;
import com.example.day_03_zy_sanyemian.model.adapter.RecycleUserAdapter;
import com.example.day_03_zy_sanyemian.model.bean.DataBean;
import com.example.day_03_zy_sanyemian.model.bean.MainDataFax;

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
 */
public class TwoUserFragment extends Fragment {


    private RecyclerView mReuser;
    private ArrayList<DataBean> dataUser;
    private RecycleUserAdapter adapter;

    public TwoUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_twpo, container, false);
        initView(view);
        initData();
        return view;
    }


    private void initView(View view) {
        mReuser = view.findViewById(R.id.mReuser);
        mReuser.setLayoutManager(new LinearLayoutManager(getActivity()));
        dataUser = new ArrayList<>();
        adapter = new RecycleUserAdapter(getActivity(), dataUser);
        mReuser.setAdapter(adapter);
    }

    private void initData() {
        new Retrofit.Builder()
                .baseUrl(ApiService.BACK_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(ApiService.class)
                .getDatauser()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MainDataFax>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MainDataFax mainDataFax) {
                        List<DataBean> data = mainDataFax.getData().getData();
                        dataUser.addAll(data);
                        adapter.notifyDataSetChanged();
                        Log.i("TAG", "数据库请求成功: ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("TAG", "数据库请求失败 "+e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
