package com.example.rk0510;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;

import java.util.List;

public class MyBase extends BaseAdapter {

    private Context context;
    private List<NewsBean.NewslistBean> list;
    private DisplayImageOptions options;

    public MyBase(Context context, List<NewsBean.NewslistBean> list) {
        this.context = context;
        this.list = list;
        options = new DisplayImageOptions.Builder()
        .cacheInMemory(true)//使用内存缓存
                .cacheOnDisk(true)//使用磁盘缓存
                .showImageOnLoading(R.mipmap.ic_launcher)//设置正在下载的图片
                .showImageForEmptyUri(R.mipmap.ic_launcher)//url为空或请求的资源不存在时
                .showImageOnFail(R.mipmap.ic_launcher)//下载失败时显示的图片
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
            view = View.inflate(context,R.layout.mybase,null);
            holder = new ViewHolder();
            holder.title = view.findViewById(R.id.textView);
            holder.content = view.findViewById(R.id.textView2);
            holder.imageView = view.findViewById(R.id.imageView);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        holder.title.setText(list.get(i).getTitle());
        holder.content.setText(list.get(i).getCtime());
        ImageLoader.getInstance().displayImage(list.get(i).getPicUrl(),holder.imageView,options);
        return view;
    }

    class ViewHolder{
        TextView title,content;
        ImageView imageView;
    }
}
