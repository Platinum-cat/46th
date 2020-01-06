package com.example.wczy.sunshineairlines_android_70;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.wczy.sunshineairlines_android_70.tools.Airport;
import com.example.wczy.sunshineairlines_android_70.tools.Tools;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Search_Flights extends AppCompatActivity {
    //声明控件
    private Spinner sp_from, sp_to, sp_ct;
    private ImageView iv_bt;
    private Button bt_search;
    private EditText et_date;
    private Intent intent;
    private ArrayList<Airport> airports;
    //接受消息进行处理
    Handler h = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 3:
                    //实例化Airport集合
                    airports = new ArrayList<>();
                    String obj = (String) msg.obj;
                    try {
                        //解析json码
                        JSONArray jsonArray = new JSONArray(obj);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            //创建Airport对象
                            Airport airport = new Airport();
                            //设置机场代码和城市
                            airport.setIATA(jsonObject.getString("IATA"));
                            airport.setName(jsonObject.getString("Name"));
                            //存入集合
                            airports.add(airport);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    //设置出发城市和到达城市下拉框的值
                    sp_from.setAdapter(new ArrayAdapter<>(Search_Flights.this,R.layout.support_simple_spinner_dropdown_item,airports));
                    sp_to.setAdapter(new ArrayAdapter<>(Search_Flights.this,R.layout.support_simple_spinner_dropdown_item,airports));
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search__flights);
        //找到控件
        sp_from = (Spinner) findViewById(R.id.sp_SF_from);
        sp_to = (Spinner) findViewById(R.id.sp_SF_to);
        sp_ct = (Spinner) findViewById(R.id.sp_SF_ct);
        bt_search = (Button) findViewById(R.id.bt_SF_search);
        iv_bt = (ImageView) findViewById(R.id.iv_SF_calender);
        et_date = (EditText) findViewById(R.id.et_SF_date);
        //设置默认日期
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date d = new Date(System.currentTimeMillis());
        et_date.setText(simpleDateFormat.format(d));
        //设置日历点击事件
        iv_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDateDailog();
            }
        });
        bt_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //获取出发城市的机场代码
                String iata = airports.get(sp_from.getSelectedItemPosition()).getIATA();
                //获取到达城市的机场代码
                String iata1 = airports.get(sp_to.getSelectedItemPosition()).getIATA();
                //获取cabintype
                String s = sp_ct.getSelectedItem().toString();
                //获取日期
                    //不用获取
                //组合成网址发送到下一个界面
                String url = Tools.DATA_OF_FLIGHTS_PARAM1+iata+Tools.DATA_OF_FLIGHTS_PARAM2+iata1+Tools.DATA_OF_FLIGHTS_PARAM3+s.toLowerCase()+Tools.DATA_OF_FLIGHTS_END;
                intent = new Intent(Search_Flights.this,Search_Flights_Results.class);
                intent.putExtra("ct",s);
                intent.putExtra("url",url);
                startActivity(intent);
                finish();
            }
        });
        //设置cabinType下拉框的值
        String[] ctValues = {"Economy","Business","First"};
        sp_ct.setAdapter(new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,ctValues));
        //获取需要的json码
        getJson();
    }
    //返回主界面
    public void sfBack(View v){
        startActivity(new Intent(Search_Flights.this,Main.class));
        finish();
    }
    //获取需要的json码
    public void getJson(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                String jsonCode = Tools.getJsonCode(Tools.LIST_OF_AIRPORTS,"GET");
                h.sendMessage(Tools.getMessage(3,jsonCode));
            }
        }).start();
    }
    //显示日期选择框
    public void showDateDailog(){
        Calendar calender = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(Search_Flights.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                et_date.setText(i + "-" + (i1+ 1) + "-" + i2);
            }
        },calender.get(Calendar.YEAR),calender.get(Calendar.MONTH),calender.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }
}