package com.example.caixiao0504yk;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RadioGroup;


import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

public class ShowActivity extends AppCompatActivity {

    private FrameLayout frameLayout;
    private RadioGroup group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        initMenu();

        frameLayout = findViewById(R.id.fragment);
        group = findViewById(R.id.group);
        getFragment(new Fragment_First());
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.but1:
                        getFragment(new Fragment_First());
                        break;
                    case R.id.but2:
                        getFragment(new Fragment_Class());
                        break;
                    case R.id.but3:
                        getFragment(new Fragment_Mind());
                        break;
                }
            }
        });


    }

    private void getFragment(Fragment f) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment,f).commit();
    }

    private void initMenu() {

        SlidingMenu menu = new SlidingMenu(this);
        menu.setMode(SlidingMenu.LEFT);
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
        //设置阴影的宽度
        menu.setShadowWidthRes(R.dimen.shadow_witdh);
        //设置阴影的图片
        // 设置滑动菜单视图的宽度
        menu.setBehindOffsetRes(R.dimen.slidingmenu_setoff);
        // 设置渐入渐出效果的值
        menu.setFadeDegree(0.35f);
        menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        //为侧滑菜单设置布局
        menu.setMenu(R.layout.menu_layout);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_menu,new Fragment_Menu()).commit();

    }
}
