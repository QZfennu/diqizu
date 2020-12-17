package com.example.day_03_zy_sanyemian.view.qtfragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day_03_zy_sanyemian.callback.ApiService;
import com.example.day_03_zy_sanyemian.R;
import com.example.day_03_zy_sanyemian.model.adapter.RecycleAdapterText;
import com.example.day_03_zy_sanyemian.model.bean.MainDataText;

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
public class TextFragment extends Fragment {


    private RecyclerView mReText;
    private ArrayList<MainDataText.DataBeanX.DataBean> text;
    private RecycleAdapterText adapterText;

    public TextFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_text, container, false);
        initView(view);
        initData();
        return view;
    }

    private void initView(View view) {
        mReText = view.findViewById(R.id.mReText);
        mReText.setLayoutManager(new LinearLayoutManager(getActivity()));
        text = new ArrayList<>();
        adapterText = new RecycleAdapterText(getActivity(), text);
        mReText.setAdapter(adapterText);
    }

    private void initData() {
        new Retrofit.Builder()
                .baseUrl(ApiService.BACK_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build().create(ApiService.class)
                .getDatatext()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MainDataText>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MainDataText mainDataText) {
                        List<MainDataText.DataBeanX.DataBean> data = mainDataText.getData().getData();
                        text.addAll(data);
                        adapterText.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
