package com.example.rk0510;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private PullToRefreshListView refreshListView;
    private int num = 10;
    private String url = "http://api.tianapi.com/meinv/?key=87295cc515b3ccc32bf0f1c9add36460&num="+num;
    private int opertype = 1;
    private MyBase adapter;
    private List<NewsBean.NewslistBean> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        refreshListView = findViewById(R.id.refreshlistview);
        initPull();
        LoadData();

    }

    private void LoadData() {
        Utils utils = new Utils(new Utils.IcallBack() {
            @Override
            public void getJson(String jsondata) {
                Gson gson = new Gson();
                NewsBean newsBean = gson.fromJson(jsondata, NewsBean.class);
                List<NewsBean.NewslistBean> newslist = newsBean.getNewslist();
                if(opertype == 1){
                    list.clear();
                }
                list.addAll(newslist);
                setadapter();
                refreshListView.onRefreshComplete();
            }
        });
        utils.execute(url);
    }

    private void setadapter() {
        if(adapter == null){
            adapter = new MyBase(this,list);
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
                url = "http://api.tianapi.com/meinv/?key=87295cc515b3ccc32bf0f1c9add36460&num="+num;
                LoadData();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> pullToRefreshBase) {
                opertype = 2;
                num+=10;
                url = "http://api.tianapi.com/meinv/?key=87295cc515b3ccc32bf0f1c9add36460&num="+num;
                LoadData();
            }
        });
    }
}
