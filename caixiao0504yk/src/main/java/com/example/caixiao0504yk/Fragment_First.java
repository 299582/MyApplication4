package com.example.caixiao0504yk;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.caixiao0504yk.Bean.TabBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mac on 2018/5/4.
 */

public class Fragment_First extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<TabBean> list_tab = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first,container,false);

        tabLayout = view.findViewById(R.id.tablayout);
        viewPager = view.findViewById(R.id.viewpagr);

        initData();
        MyAdapter myAdapter = new MyAdapter(getChildFragmentManager());
        viewPager.setAdapter(myAdapter);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setOffscreenPageLimit(list_tab.size());

        return view;
    }

    class MyAdapter extends FragmentPagerAdapter{

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return list_tab.get(position).getTitle();
        }

        @Override
        public Fragment getItem(int position) {
            String title = list_tab.get(position).getTitle();
            if(title.equals("福利")){
                Fragment_Grid fragment_grid = new Fragment_Grid();
                Bundle bundle = new Bundle();
                bundle.putString("type", list_tab.get(position).getType());
                fragment_grid.setArguments(bundle);
                return fragment_grid;
            }else {
                Fragment_Tab fragment_tab = new Fragment_Tab();
                Bundle bundle = new Bundle();
                bundle.putString("type", list_tab.get(position).getType());
                fragment_tab.setArguments(bundle);
                return fragment_tab;
            }
        }

        @Override
        public int getCount() {
            return list_tab.size();
        }
    }

    private void initData() {
        list_tab.add(new TabBean("Android","it"));
        list_tab.add(new TabBean("IOS","apple"));
        list_tab.add(new TabBean("福利","%E7%A6%8F%E5%88%A9"));

    }
}
