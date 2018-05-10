package com.example.caixiao0504yk;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.caixiao0504yk.Adapters.MyBase;
import com.example.caixiao0504yk.Bean.NewsBean;
import com.example.caixiao0504yk.Utils.MyTast;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mac on 2018/5/4.
 */

public class Fragment_Tab extends Fragment {
    private PullToRefreshListView refreshListView;
    private String type;
    private int num = 1;
    private int opertype = 1;
    private String url;
    private MyBase adapter;
    private List<NewsBean.NewslistBean> list = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab,container,false);
        refreshListView = view.findViewById(R.id.refreshlistview);
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
                NewsBean newsBean = gson.fromJson(jsondata, NewsBean.class);
                List<NewsBean.NewslistBean> results = newsBean.getNewslist();
                if(opertype == 1){
                    list.clear();
                }
                list.addAll(results);
                setadapter();
                refreshListView.onRefreshComplete();

            }
        });
        url = "http://api.tianapi.com/"+type+"/?key=87295cc515b3ccc32bf0f1c9add36460&num=10&page="+num;
        tast.execute(url);
    }

    private void setadapter() {
        if(adapter == null){
            adapter = new MyBase(getActivity(),list);
            refreshListView.setAdapter(adapter);
        }else{
            adapter.notifyDataSetChanged();
        }
    }

    private void initPull() {
        refreshListView.setMode(PullToRefreshBase.Mode.BOTH);
        refreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> pullToRefreshBase) {
                opertype = 1;
                num = 1;
                url = "http://api.tianapi.com/"+type+"/?key=87295cc515b3ccc32bf0f1c9add36460&num=10&page="+num;
                LoadData();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> pullToRefreshBase) {
                opertype = 2;
                num++;
                url = "http://api.tianapi.com/"+type+"/?key=87295cc515b3ccc32bf0f1c9add36460&num=10&page="+num;
                LoadData();
            }
        });
        ILoadingLayout startLabels = refreshListView.getLoadingLayoutProxy(true, false);
        startLabels.setPullLabel("下拉刷新");
        startLabels.setRefreshingLabel("正在拉");
        startLabels.setReleaseLabel("放开刷新");
        ILoadingLayout endLabels = refreshListView.getLoadingLayoutProxy(false, true);
        endLabels.setPullLabel("上拉刷新");
        endLabels.setRefreshingLabel("正在载入...");
        endLabels.setReleaseLabel("放开刷新...");
    }
}
