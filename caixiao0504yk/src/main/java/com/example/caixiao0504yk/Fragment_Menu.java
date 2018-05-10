package com.example.caixiao0504yk;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.caixiao0504yk.Adapters.MyBase_menu;
import com.example.caixiao0504yk.Bean.MenuBean;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mac on 2018/5/4.
 */

public class Fragment_Menu extends Fragment {

    private ListView list_menu;
    private List<MenuBean> list = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.menu_list,container,false);
        list_menu = view.findViewById(R.id.list_menu);
        list.add(new MenuBean("商品",R.drawable.drawer_icon_client));
        list.add(new MenuBean("瞎推荐",R.drawable.drawer_icon_recommend));
        MyBase_menu adapter = new MyBase_menu(getActivity(),list);
        list_menu.setAdapter(adapter);

        list_menu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String title = list.get(i).getTitle();
                if(title.equals("商品")){
                    Intent it = new Intent(getActivity(),GoodsActivity.class);
                    startActivity(it);
                }else{
                    Toast.makeText(getActivity(), "瞎推荐", Toast.LENGTH_SHORT).show();
                }

            }
        });

        return view;
    }
}
