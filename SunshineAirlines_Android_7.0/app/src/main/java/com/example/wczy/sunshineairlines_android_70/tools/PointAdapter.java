package com.example.wczy.sunshineairlines_android_70.tools;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.wczy.sunshineairlines_android_70.R;

import java.util.List;

/**
 * Created by wczy on 2020/1/5.
 */
//积分适配器
public class PointAdapter extends BaseAdapter {
    public PointAdapter(List<Point> point, Context context) {
        this.points = point;
        this.lif = LayoutInflater.from(context);
    }

    List<Point> points;
    LayoutInflater lif;



    @Override
    public int getCount() {
        return points.size();
    }

    @Override
    public Object getItem(int position) {
        return points.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = lif.inflate(R.layout.item_point,null);
        TextView viewById = v.findViewById(R.id.tv_P_point);
        TextView viewById1 = v.findViewById(R.id.tv_P_date);
        viewById.setText(points.get(position).getPoints()+" Points");
        viewById1.setText(points.get(position).getDate());
        return v;
    }
}
