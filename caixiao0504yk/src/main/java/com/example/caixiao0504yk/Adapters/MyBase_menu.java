package com.example.caixiao0504yk.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.caixiao0504yk.Bean.MenuBean;
import com.example.caixiao0504yk.R;

import java.util.List;

/**
 * Created by mac on 2018/5/4.
 */

public class MyBase_menu extends BaseAdapter {

    private Context context;
    private List<MenuBean> list;

    public MyBase_menu(Context context, List<MenuBean> list) {
        this.context = context;
        this.list = list;
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
            view = View.inflate(context, R.layout.mybase_menu,null);
            holder = new ViewHolder();
            holder.title = view.findViewById(R.id.texttitle_menulist);
            holder.imageView = view.findViewById(R.id.imageView_menulist);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        holder.imageView.setImageResource(list.get(i).getImage());
        holder.title.setText(list.get(i).getTitle());

        return view;
    }

    class ViewHolder{
        TextView title;
        ImageView imageView;
    }
}
