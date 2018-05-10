package com.example.caixiao0504yk.Adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.caixiao0504yk.Bean.PhoneBean;
import com.example.caixiao0504yk.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;

import java.util.List;

/**
 * Created by mac on 2018/5/4.
 */

public class MyBase3 extends BaseAdapter {

    private Context context;
    private List<PhoneBean.DataBean> list;
    private DisplayImageOptions options;

    public MyBase3(Context context, List<PhoneBean.DataBean> list) {
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
            view = View.inflate(context,R.layout.mybase3,null);
            holder = new ViewHolder();
            holder.title = view.findViewById(R.id.text_title_goods);
            holder.price = view.findViewById(R.id.text_price_goods);
            holder.imageView = view.findViewById(R.id.imageView_goods);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        holder.title.setText(list.get(i).getTitle());
        holder.price.setText("¥ "+list.get(i).getPrice()+"0");
        ImageLoader.getInstance().displayImage(list.get(i).getImages().split("\\|")[0],holder.imageView,options);

        return view;
    }

    class ViewHolder{
        TextView title,price;
        ImageView imageView;
    }


}
