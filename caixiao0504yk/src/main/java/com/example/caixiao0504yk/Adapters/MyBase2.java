package com.example.caixiao0504yk.Adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.caixiao0504yk.Bean.MeiNvBean;
import com.example.caixiao0504yk.Bean.NewsBean;
import com.example.caixiao0504yk.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;

import java.util.List;

/**
 * Created by mac on 2018/5/4.
 */

public class MyBase2 extends BaseAdapter {

    private Context context;
    private List<MeiNvBean.ResultsBean> list;
    private DisplayImageOptions options;


    public MyBase2(Context context, List<MeiNvBean.ResultsBean> list) {
        this.context = context;
        this.list = list;
        options = new DisplayImageOptions.Builder()
                .cacheInMemory(true)//使用内存缓存
                .cacheOnDisk(true)//使用磁盘缓存
                .showImageOnLoading(R.drawable.placeholder)//设置正在下载的图片
                .showImageForEmptyUri(R.drawable.placeholder)//url为空或请求的资源不存在时
                .showImageOnFail(R.drawable.placeholder)//下载失败时显示的图片
                .bitmapConfig(Bitmap.Config.RGB_565)//设置图片色彩模式
                .imageScaleType(ImageScaleType.EXACTLY)//设置图片的缩放模式
                .build();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null){
            view = View.inflate(context,R.layout.mybase2,null);
            holder = new MyBase2.ViewHolder();
            holder.imageView = view.findViewById(R.id.imageView_grid);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        ImageLoader.getInstance().displayImage(list.get(i).getUrl(),holder.imageView,options);
        return view;
    }
    class ViewHolder{
        ImageView imageView;
    }
}
