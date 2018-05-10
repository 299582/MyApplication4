package com.example.caixiao0504yk.Adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.caixiao0504yk.Bean.ImgBean;
import com.example.caixiao0504yk.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;

import java.util.List;

/**
 * Created by mac on 2018/5/4.
 */

public class MyBase_vp extends PagerAdapter {

    private Context context;
    private List<ImgBean.DataBean> list;
    private DisplayImageOptions options;

    public MyBase_vp(Context context, List<ImgBean.DataBean> list) {
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
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        ImageLoader.getInstance().displayImage(list.get(position%list.size()).getIcon(),imageView,options);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = list.get(position % list.size()).getTitle();
                Toast.makeText(context, title, Toast.LENGTH_SHORT).show();
            }
        });
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //super.destroyItem(container, position, object);
        container.removeView((View) object);
    }
}
