package com.example.swq_tp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.swq_tp.ApiService;
import com.example.swq_tp.R;
import com.example.swq_tp.adapter.FaAdapter;
import com.example.swq_tp.bean.Re2Bean;
import com.example.swq_tp.bean.ReBean;
import com.example.swq_tp.presenter.MainPresenter;
import com.example.swq_tp.view.MainView;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class FaFragment extends Fragment implements MainView {
    private RecyclerView mRel;
    private ArrayList<ReBean.DataBean> reBeans;
    private FaAdapter adapter;
    private ArrayList<Re2Bean.DataBean> re2Beans;
    private MainPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fa_fragment, null);
        presenter = new MainPresenter(this);
        initView(view);
        initData();
        initData2();
        return view;
    }

    private void initData2() {
        presenter.getData();
    }

    private void initData() {
        new Retrofit.Builder()
                .baseUrl(ApiService.sUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class)
                .getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ReBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ReBean reBean) {
                        List<ReBean.DataBean> data = reBean.getData();
                        reBeans.addAll(data);
                        adapter.notifyDataSetChanged();
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
        mRel = (RecyclerView) itemView.findViewById(R.id.rel);
        mRel.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRel.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
       // mRel.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        reBeans = new ArrayList<>();
        re2Beans = new ArrayList<>();
        adapter = new FaAdapter(getContext(), reBeans,re2Beans);
        mRel.setAdapter(adapter);
    }

    @Override
    public void onSuccess(Re2Bean re2Bean) {
        if (re2Bean!=null && re2Bean.getData()!=null){
            List<Re2Bean.DataBean> data = re2Bean.getData();
            re2Beans.addAll(data);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onFail(String msg) {

    }
}
