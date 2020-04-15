package com.example.yf.sunshineairlines_android20.activity;

import android.view.View;
import android.widget.TextView;

import com.example.yf.sunshineairlines_android20.R;
import com.example.yf.sunshineairlines_android20.bean.FlightInfo;
import com.example.yf.sunshineairlines_android20.simpleView.SimpleActivity;

import java.io.Serializable;

public class SelectSeatsActivity extends SimpleActivity {

    private TextView tvFN, tvDT, tvAA, tvCT;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_select_seats);
        tvFN = (TextView) findViewById(R.id.tvFN);
        tvDT = (TextView) findViewById(R.id.tvDT);
        tvAA = (TextView) findViewById(R.id.tvAA);
        tvCT = (TextView) findViewById(R.id.tvCT);
    }

    @Override
    protected void createEvent() {

        //获取intent对象里面的FlightInfo对象
        FlightInfo ticketInfo = (FlightInfo) intent.getSerializableExtra("ticketInfo");
        //设置对应的值
        tvFN.setText("Flight Number: " + ticketInfo.getFlightNumber());
        tvDT.setText("Departure Time: " + ticketInfo.getDepartureTime());
        tvAA.setText("Aircraft Airbus: " + ticketInfo.getAirCraft());
        tvCT.setText("Cabin Type: " + ticketInfo.getCabinType());
        registerClickEvent(R.id.btSubmit, R.id.btBack);
        //拦截返回键
        onReturnKeyDown(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        });
    }

    @Override
    protected void clickEvent(View view) {
        switch (view.getId()){
            case R.id.btBack:
                finish();
                break;
            case R.id.btSubmit:
                toastMsg("提交功能未完善！");
                break;
        }

    }
}
