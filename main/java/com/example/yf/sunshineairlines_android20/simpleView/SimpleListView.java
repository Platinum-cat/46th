package com.example.yf.sunshineairlines_android20.simpleView;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.example.yf.sunshineairlines_android20.holder.MyHolder;

/**
 * Created by yf on 2020/4/14.
 * ListView简化类
 */

public class SimpleListView extends BaseAdapter implements AdapterView.OnItemClickListener {

    //Holder对象
    private MyHolder myHolder;

    //ListView对象
    private ListView listView;

    public void setHolder(MyHolder myHolder) {
        this.myHolder = myHolder;
    }

    /**
     * 为ListView设置当Item点击事件为自己
     */
    public void setOnItemClickListener(){
        listView.setOnItemClickListener(this);
    }

    public SimpleListView() {
    }

    /**
     * 传入需要的布局文件Id、上下文、和holder对象
     * @param idForListView
     * @param context
     * @param holder
     */
    public SimpleListView(int idForListView, Context context, MyHolder holder) {
        this.listView = ((Activity)context).findViewById(idForListView);
        this.myHolder = holder;
    }

    /**
     *  设置ListView的适配器为自己
     */
    public void setAdapter(){
        listView.setAdapter(this);
    }

    @Override
    public int getCount() {
        return myHolder.infos.size();
    }

    @Override
    public Object getItem(int position) {
        return myHolder.infos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return myHolder.setValueByPosition(position);
    }

    /**
     * 点击事件
     * @param parent
     * @param view
     * @param position
     * @param id
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
