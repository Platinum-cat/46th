package com.example.yf.sunshineairlines_android20.holder;

import android.view.View;

import java.util.List;

/**
 * Created by yf on 2020/4/6.
 * Holder类，处理布局文件内控件
 */

public abstract class MyHolder<infoType> {
    public List<infoType> infos;

    public MyHolder(List<infoType> infos) {
        this.infos = infos;
    }

    public abstract View setValueByPosition(int position);
}
