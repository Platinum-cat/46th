package com.example.yf.sunshineairlines_android20.activity;


import android.app.DatePickerDialog;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.yf.sunshineairlines_android20.R;
import com.example.yf.sunshineairlines_android20.bean.Airport;
import com.example.yf.sunshineairlines_android20.simpleView.SimpleActivity;
import com.example.yf.sunshineairlines_android20.utils.MyUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;


public class SearchFlightActivity extends SimpleActivity {

    private Spinner spFrom, spTo, spCT;

    private EditText etDate;

    private DatePickerDialog dpd;


    @Override
    protected void initView() {
        setContentView(R.layout.activity_search_flight);
        etDate = (EditText) findViewById(R.id.etDate);
        spFrom = (Spinner) findViewById(R.id.spFrom);
        spTo = (Spinner) findViewById(R.id.spTo);
        spCT = (Spinner) findViewById(R.id.spCT);
    }

    @Override
    protected void createEvent() {
        //设置日历弹窗
        dpd = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                etDate.setText(view.getYear() + "-" + (view.getMonth() + 1) + "-" + view.getDayOfMonth());
            }
        }, 2018, 01, 01);
        //设置默认显示时间
        etDate.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        //设置对应下拉框值
        setSpinnerValues();
        //注册点击事件
        registerClickEvent(R.id.btBack, R.id.btSearch, R.id.etDate, R.id.ivDate);
        //拦截返回键执行对应事件
        onReturnKeyDown(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        });
    }

    /**
     * 设置点击事件
     * @param view
     */
    @Override
    protected void clickEvent(View view) {
        switch (view.getId()){
            case R.id.btBack:
                finish();
                break;
            case R.id.btSearch:
                //获取对应下拉框的值
                Airport airportInfo01 = (Airport)spFrom.getSelectedItem();
                Airport airportInfo02 = (Airport) spTo.getSelectedItem();
                String selectedItem = (String) spCT.getSelectedItem();
                //将值凭借成url
                String url = "/api/flight/list?From="+
                        airportInfo01.getIATA()+
                        "&To="+
                        airportInfo02.getIATA()+
                        "&CabinType="+
                        selectedItem.toLowerCase()+
                        //这里date参数的有问题
                        //Asc是排列方式
                        "&Date=12312321&isAsc=1";
                //将url发送给下个界面
                intent.putExtra("urlStr",url);
                intent.putExtra("ct",selectedItem);
                jump(SearchFlightsResultActivity.class);
                break;
            //关于日期的控件点击事件设置为显示日历弹窗
            case R.id.etDate: case R.id.ivDate: dpd.show(); break;
        }
    }

    /**
     * 设置对应下拉框值
     */
    private void setSpinnerValues(){
        int layoutRes = R.layout.support_simple_spinner_dropdown_item;
        spCT.setAdapter(new ArrayAdapter(this, layoutRes, new String[]{"Economy", "Business", "First"}));
        String result = null;
        try {
            result = startThread(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return MyUtils.getWebRes("/api/airport/list");
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (result != null){
            List<Airport> airports = null;
            try {
                airports = MyUtils.parseJsonByBean(result, Airport.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (airports != null){
                spFrom.setAdapter(new ArrayAdapter(this, layoutRes, airports));
                spTo.setAdapter(new ArrayAdapter(this, layoutRes, airports));
            }
        }
    }
}
