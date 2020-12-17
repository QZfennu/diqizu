package com.example.xiaoshixun_zy.fragment;

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

import com.example.xiaoshixun_zy.ApiService;
import com.example.xiaoshixun_zy.R;
import com.example.xiaoshixun_zy.adapter.PlayAdapter;
import com.example.xiaoshixun_zy.bean.PlayBean;

import java.util.ArrayList;
import java.util.List;

import cn.jzvd.JzvdStd;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class PlayFragment extends Fragment {

    private JzvdStd mJz;
    private RecyclerView mRel2;
    private ArrayList<PlayBean.DataBeanX.DataBean> beans;
    private PlayAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.play_fragment, null);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        new Retrofit.Builder()
                .baseUrl(ApiService.sUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class)
                .getPlay()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PlayBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(PlayBean playBean) {
                        List<PlayBean.DataBeanX.DataBean> data = playBean.getData().getData();
                        beans.addAll(data);
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
        mRel2 = (RecyclerView) itemView.findViewById(R.id.rel2);
        mRel2.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRel2.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        beans = new ArrayList<>();
        adapter = new PlayAdapter(getActivity(), beans);
        mRel2.setAdapter(adapter);
    }

}
