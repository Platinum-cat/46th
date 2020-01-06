package com.example.wczy.sunshineairlines_android_70;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;

public class Logo_under extends AppCompatActivity {
    //声明控件
    private ViewPager vp;
    private ArrayList<View> views;
    private SharedPreferences spf;
    private SharedPreferences.Editor editor;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo_under);
        //找到控件
        vp = (ViewPager) findViewById(R.id.viewPager);
        //确定需要跳转的页面
        intent = new Intent(Logo_under.this,Login.class);
        //获取data文件
        spf = getSharedPreferences("data",MODE_PRIVATE);
        editor =spf.edit();
        boolean isOpen = spf.getBoolean("isOpen", false);
        //判断改页面是否是第一次开启
        if (isOpen == true){
            startActivity(intent);
        }
        //实例化集合
        views = new ArrayList<>();
        //布局填充器找到三个界面
        LayoutInflater lif = getLayoutInflater();
        View v1 = lif.inflate(R.layout.logo01, null);
        View v2 = lif.inflate(R.layout.logo02, null);
        View v3 = lif.inflate(R.layout.logo03,null);
        //添加进集合
        views.add(v1);
        views.add(v2);
        views.add(v3);
        //设置适配器
        vp.setAdapter(new PagerAdapter() {
            @Override
            //返回集合长度
            public int getCount() {
                return views.size();
            }

            @Override
            //判断是否在集合内
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            //销毁视图
            public void destroyItem(View container, int position, Object object) {
                ((ViewPager)container).removeView(views.get(position));
            }

            @Override
            //添加视图
            public Object instantiateItem(View container, int position) {
                ((ViewPager)container).addView(views.get(position));
                return views.get(position);
            }
        });
    }
    //跳转到登录界面
    public void lSkips(View v){
        startActivity(intent);
        //点击按钮时传入数据标记该页面已经开启过
        editor.putBoolean("isOpen",true);
        editor.apply();
        finish();
    }
}
