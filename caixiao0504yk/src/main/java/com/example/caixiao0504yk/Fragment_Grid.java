package com.example.caixiao0504yk;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.caixiao0504yk.Adapters.MyBase;
import com.example.caixiao0504yk.Adapters.MyBase2;
import com.example.caixiao0504yk.Bean.MeiNvBean;
import com.example.caixiao0504yk.Bean.NewsBean;
import com.example.caixiao0504yk.Utils.MyTast;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshGridView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mac on 2018/5/4.
 */

public class Fragment_Grid extends Fragment {

    private PullToRefreshGridView refreshGridView;
    private String type;
    private int num = 1;
    private int opertype = 1;
    private String url;
    private List<MeiNvBean.ResultsBean> list = new ArrayList<>();
    private MyBase2 adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_grid,container,false);
        refreshGridView = view.findViewById(R.id.refreshgridview);
        type = getArguments().getString("type");
        initPull();
        LoadData();
        return view;
    }

    private void LoadData() {

        MyTast tast = new MyTast(new MyTast.IcallBack() {
            @Override
            public void getjson(String jsondata) {
                Gson gson = new Gson();
                MeiNvBean meiNvBean = gson.fromJson(jsondata, MeiNvBean.class);
                //List<meiNvBean.ResultsBean> list_results =
                List<MeiNvBean.ResultsBean> list_results = meiNvBean.getResults();
                if(opertype == 1){
                    list.clear();
                }
                list.addAll(list_results);
                setadapter();
                refreshGridView.onRefreshComplete();

            }
        });
        url = "http://gank.io/api/data/"+type+"/10/"+num;
        tast.execute(url);

    }

    private void setadapter() {
        if(adapter == null){
            adapter = new MyBase2(getActivity(),list);
            refreshGridView.setAdapter(adapter);
        }else{
            adapter.notifyDataSetChanged();
        }
    }

    private void initPull() {
        refreshGridView.setMode(PullToRefreshBase.Mode.BOTH);
        refreshGridView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<GridView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<GridView> pullToRefreshBase) {
                opertype = 1;
                num = 1;
                url = "http://gank.io/api/data/"+type+"/10/"+num;
                LoadData();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<GridView> pullToRefreshBase) {
                opertype = 2;
                num++;
                url = "http://gank.io/api/data/"+type+"/10/"+num;
                LoadData();
            }
        });
        ILoadingLayout startLabels = refreshGridView.getLoadingLayoutProxy(true, false);
        startLabels.setPullLabel("下拉刷新");
        startLabels.setRefreshingLabel("正在拉");
        startLabels.setReleaseLabel("放开刷新");
        ILoadingLayout endLabels = refreshGridView.getLoadingLayoutProxy(false, true);
        endLabels.setPullLabel("上拉刷新");
        endLabels.setRefreshingLabel("正在载入...");
        endLabels.setReleaseLabel("放开刷新...");
    }
}
