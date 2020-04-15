package com.example.yf.sunshineairlines_android20.activity;


import android.view.View;
import android.widget.TextView;

import com.example.yf.sunshineairlines_android20.R;
import com.example.yf.sunshineairlines_android20.bean.PointInfo;
import com.example.yf.sunshineairlines_android20.bean.User;
import com.example.yf.sunshineairlines_android20.holder.PointInfoHolder;
import com.example.yf.sunshineairlines_android20.simpleView.SimpleActivity;
import com.example.yf.sunshineairlines_android20.simpleView.SimpleListView;
import com.example.yf.sunshineairlines_android20.utils.MyUtils;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.Callable;

public class MyMileagePointsActivity extends SimpleActivity {

    private TextView tvUser, tvPoint;


    @Override
    protected void initView() {
        setContentView(R.layout.activity_my_mileage_points);
        tvPoint = (TextView) findViewById(R.id.tvPoints);
        tvUser = (TextView) findViewById(R.id.tvUserInfo);

    }

    @Override
    protected void createEvent() {
        registerClickEvent(R.id.btBack);
        onReturnKeyDown(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        });
        //获取intent里面的User对象
        final User userInfo = (User) intent.getSerializableExtra("userInfo");
        if (userInfo != null){
            //裁剪字符串
            CharSequence charSequence1 = tvUser.getText().subSequence(0, 3);
            CharSequence charSequence2 = tvUser.getText().subSequence(6, tvUser.getText().length());
            //拼接未一个新字符串并显示
            tvUser.setText(charSequence1 + userInfo.getFirstName() +" "+ userInfo.getLastName() + charSequence2);
        }

        String result = null;
        try {
            //根据userID获取Point信息
            result = startThread(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return MyUtils.getWebRes("/api/mileagepoints/" + Integer.parseInt(userInfo.getID()));
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (result != null){
            List<PointInfo> pointInfos = null;
            try {
                //解析PointJson为对应对象
                pointInfos = MyUtils.parseJsonByBean(result, PointInfo.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (pointInfos != null){
                //实例化对应布局的Holder
                PointInfoHolder pointInfoHolder = new PointInfoHolder(R.layout.point_info_item, this, pointInfos);
                //获取总point并显示
                tvPoint.setText(pointInfoHolder.getTotalPoint() + " Points  ");
                //使用SimpleListView对ListView进行操作
                SimpleListView simpleListView = new SimpleListView(R.id.lvPointInfo, this, pointInfoHolder);
                //为ListView设置对应的适配器
                simpleListView.setAdapter();

            }
        }

    }

    @Override
    protected void clickEvent(View view) {
        finish();
    }
}
