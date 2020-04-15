package com.example.yf.sunshineairlines_android20.simpleView;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yf on 2020/4/10.
 * ViewPager简化类
 */

public class SimpleViewPager extends PagerAdapter {
    ///需要使用的View集合
    private List<View> views;
    //布局填充器
    private LayoutInflater layoutInflater;
    //viewPager对象
    private ViewPager viewPager;

    /**
     * 根据上下文实例化布局填充器并根据id实例化ViewPager对象
     * @param context 上下文
     * @param idForViewPager viewPager的id
     */
    public SimpleViewPager(Context context, int idForViewPager) {
        this.layoutInflater = LayoutInflater.from(context);
        ViewPager viewById = ((Activity) context).findViewById(idForViewPager);
        this.viewPager = viewById;
    }

    /**
     * 添加需要的布局id
     * @param ids
     */
    public void addViews(int... ids) {
        views = new ArrayList<>();
        for (int id : ids) {
            views.add(layoutInflater.inflate(id, null));
        }
    }

    /**
     * 设置ViewPager的适配器的该类
     *      该类继承了对应的适配器并实现的对应的方法
     */
    public void setAdapter(){
        viewPager.setAdapter(this);
    }

    @Override
    public int getCount() {
        return views.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(views.get(position));
        return views.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(views.get(position));
    }
}
