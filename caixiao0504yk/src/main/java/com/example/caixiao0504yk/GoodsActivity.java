package com.example.caixiao0504yk;

import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;

import com.example.caixiao0504yk.Adapters.MyBase3;
import com.example.caixiao0504yk.Adapters.MyBase_vp;
import com.example.caixiao0504yk.Bean.ImgBean;
import com.example.caixiao0504yk.Bean.PhoneBean;
import com.example.caixiao0504yk.Utils.MyTast;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;

import java.util.ArrayList;
import java.util.List;

public class GoodsActivity extends AppCompatActivity {

    private LinearLayout lin_point;
    private ViewPager viewPager;
    private PullToRefreshScrollView scrollView;
    private ListView listView;
    private int num = 1;
    private String url = "https://www.zhaoapi.cn/product/searchProducts?keywords=%E6%89%8B%E6%9C%BA&source=android&page="+num;
    private String imgurl = "https://www.zhaoapi.cn/quarter/getAd";
    private int opertype = 1;
    private MyBase3 adapter;
    private List<PhoneBean.DataBean> list = new ArrayList<>();
    private List<ImageView> imglist = new ArrayList<>();
    private List<ImgBean.DataBean> data;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            int currentItem = viewPager.getCurrentItem();
            currentItem++;
            viewPager.setCurrentItem(currentItem);
            selectorpoint(currentItem%imglist.size());
            handler.sendEmptyMessageDelayed(1,3000);

        }
    };

    private void selectorpoint(int index) {
        for (int i = 0; i < imglist.size(); i++) {
            if(i == index){
                imglist.get(i).setImageResource(R.drawable.selector);
            }else{
                imglist.get(i).setImageResource(R.drawable.unselector);
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods);

        lin_point = findViewById(R.id.lin_point);
        viewPager = findViewById(R.id.viewpager);
        scrollView = findViewById(R.id.scrollview);
        listView = findViewById(R.id.listview_first);
        initPull();
        LoadData();
        LoadImg();

        viewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        handler.removeMessages(1);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        handler.removeMessages(1);
                        break;
                    case MotionEvent.ACTION_UP:
                        handler.sendEmptyMessageDelayed(1,3000);
                        break;
                }
                return true;
            }
        });

    }

    private void LoadImg() {
        MyTast tast = new MyTast(new MyTast.IcallBack() {
            @Override
            public void getjson(String jsondata) {
                Gson gson = new Gson();
                ImgBean imgBean = gson.fromJson(jsondata, ImgBean.class);
                data = imgBean.getData();
                MyBase_vp adapter = new MyBase_vp(GoodsActivity.this, data);
                viewPager.setAdapter(adapter);
                viewPager.setCurrentItem(data.size()*100);
                initpoint();
                handler.sendEmptyMessageDelayed(1,3000);

            }
        });
        tast.execute(imgurl);
    }

    private void initpoint() {
        for (int i = 0; i < data.size(); i++) {
            ImageView imageView = new ImageView(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(0,0,15,0);
            if(i == 0){
                imageView.setImageResource(R.drawable.selector);
            }else{
                imageView.setImageResource(R.drawable.unselector);
            }
            lin_point.addView(imageView,params);
            imglist.add(imageView);
        }
    }

    private void LoadData() {
        MyTast tast = new MyTast(new MyTast.IcallBack() {
            @Override
            public void getjson(String jsondata) {
                Gson gson = new Gson();
                PhoneBean phoneBean = gson.fromJson(jsondata, PhoneBean.class);
                List<PhoneBean.DataBean> phonedata = phoneBean.getData();
                if(opertype == 1){
                    list.clear();
                }
                list.addAll(phonedata);
                setadapter();
                scrollView.onRefreshComplete();
            }
        });
        tast.execute(url);
    }

    private void setadapter() {
        if(adapter == null){
            adapter = new MyBase3(GoodsActivity.this,list);
            listView.setAdapter(adapter);
        }else{
            adapter.notifyDataSetChanged();
        }
    }

    private void initPull() {
        scrollView.setMode(PullToRefreshBase.Mode.BOTH);
        scrollView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ScrollView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ScrollView> pullToRefreshBase) {
                opertype = 1;
                num = 1;
                url = "https://www.zhaoapi.cn/product/searchProducts?keywords=%E6%89%8B%E6%9C%BA&source=android&page="+num;
                LoadData();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ScrollView> pullToRefreshBase) {
                opertype = 2;
                num++;
                url = "https://www.zhaoapi.cn/product/searchProducts?keywords=%E6%89%8B%E6%9C%BA&source=android&page="+num;
                LoadData();
            }
        });
        ILoadingLayout startLabels = scrollView.getLoadingLayoutProxy(true, false);
        startLabels.setPullLabel("下拉刷新");
        startLabels.setRefreshingLabel("正在拉");
        startLabels.setReleaseLabel("放开刷新");
        ILoadingLayout endLabels = scrollView.getLoadingLayoutProxy(false, true);
        endLabels.setPullLabel("上拉刷新");
        endLabels.setRefreshingLabel("正在载入...");
        endLabels.setReleaseLabel("放开刷新...");
    }
}
