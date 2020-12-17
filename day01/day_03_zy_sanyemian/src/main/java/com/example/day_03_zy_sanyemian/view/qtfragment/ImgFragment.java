package com.example.day_03_zy_sanyemian.view.qtfragment;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day_03_zy_sanyemian.callback.ApiService;
import com.example.day_03_zy_sanyemian.R;
import com.example.day_03_zy_sanyemian.model.adapter.RecycleAdapterImg;
import com.example.day_03_zy_sanyemian.model.bean.MainImgDataBean;

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
public class ImgFragment extends Fragment {


    private RecyclerView mReImg;
    private ArrayList<MainImgDataBean.DataBeanX.DataBean> imgBean;
    private RecycleAdapterImg adapterImg;

    public ImgFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_img, container, false);
        initView(view);
        initData();


        return view;
    }


    private void initView(View view) {
        mReImg = view.findViewById(R.id.mReImg);
        mReImg.setLayoutManager(new LinearLayoutManager(getActivity()));
        imgBean = new ArrayList<>();
        adapterImg = new RecycleAdapterImg(getActivity(), imgBean);
        mReImg.setAdapter(adapterImg);
    }

    private void initData() {
        new Retrofit.Builder()
                .baseUrl(ApiService.BACK_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build().create(ApiService.class)
                .getDataImg()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MainImgDataBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MainImgDataBean mainImgDataBean) {
                        List<MainImgDataBean.DataBeanX.DataBean> data = mainImgDataBean.getData().getData();
                        imgBean.addAll(data);

                        adapterImg.notifyDataSetChanged();
                        Log.i("TAG", "图片页面请求成功 ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("TAG", "图片请求失败 " + e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


}
