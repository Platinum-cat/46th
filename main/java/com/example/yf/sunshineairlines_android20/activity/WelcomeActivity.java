package com.example.yf.sunshineairlines_android20.activity;

import android.content.Intent;
import android.view.View;

import com.example.yf.sunshineairlines_android20.R;
import com.example.yf.sunshineairlines_android20.simpleView.SimpleActivity;
import com.example.yf.sunshineairlines_android20.simpleView.SimpleViewPager;


public class WelcomeActivity extends SimpleActivity {

    @Override
    protected void initView() {
        //设置改页面绑定的布局文件
        setContentView(R.layout.activity_welcome);
        //实例化轻型数据存储类
        useSharedPreferences();
    }

    /**
     * 第一个界面实例化一个Intent
     * @return
     */
    @Override
    public Intent getIntent() {
        return new Intent();
    }

    @Override
    protected void createEvent() {
        //判断当前界面是否打开过
        if (sharedPreferences.getBoolean("isOpen", false)){
            cEvent(null);
        }
        //实例化SimpleViewPager
        SimpleViewPager svp = new SimpleViewPager(WelcomeActivity.this, R.id.activity_welcome);
        //添加需要使用的布局文件
        svp.addViews(R.layout.welcome_logo01, R.layout.welcome_logo02, R.layout.welcome_logo03);
        //设置ViewPager的适配器
        svp.setAdapter();
    }

    /**
     * Skip的点击事件，该点击事件在布局文件中使用
     * @param v
     */
    public void cEvent(View v){
        //添加一个已经打开过的标记
        editor.putBoolean("isOpen", true);
        //提交
        editor.apply();
        //跳转页面
        jumpAndFinish(LoginActivity.class);
    }
}