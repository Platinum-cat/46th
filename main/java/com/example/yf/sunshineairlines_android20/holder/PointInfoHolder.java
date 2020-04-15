package com.example.yf.sunshineairlines_android20.holder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.yf.sunshineairlines_android20.R;
import com.example.yf.sunshineairlines_android20.bean.PointInfo;

import java.util.List;

/**
 * Created by yf on 2020/4/15.
 */

public class PointInfoHolder extends MyHolder<PointInfo> {

    private TextView tvPoint, tvDate;

    //布局填充器
    private LayoutInflater lif;

    //Ticket布局文件的Id
    private int parentId;

    public int getTotalPoint(){
        int totalPoint = 0;
        for (PointInfo info : infos) {
            totalPoint += Integer.parseInt(info.getPoints());
        }
        return totalPoint;
    }

    /**
     * 传入Ticket布局文件的id、上下文、需要填充的数据集
     * @param parentId
     * @param context
     * @param list
     */
    public PointInfoHolder(int parentId, Context context, List list) {
        super(list);
        lif = LayoutInflater.from(context);
        this.parentId = parentId;
    }

    /**
     * 根据布局文件实例化对应控件
     * @param parentId
     * @return
     */
    private View findViewByParent(int parentId) {
        View parentView = lif.inflate(parentId, null);

        tvPoint = parentView.findViewById(R.id.tvP_Point);
        tvDate = parentView.findViewById(R.id.tvP_Time);

        return parentView;
    }

    @Override
    public View setValueByPosition(int position) {
        View viewByParent = findViewByParent(parentId);
        PointInfo pointInfo = infos.get(position);
        tvDate.setText(pointInfo.getDate());
        tvPoint.setText(pointInfo.getPoints());
        return viewByParent;
    }
}
