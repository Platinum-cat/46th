package com.example.wczy.sunshineairlines_android_70;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wczy.sunshineairlines_android_70.tools.Ticket;
import com.example.wczy.sunshineairlines_android_70.tools.TicketAdapter;
import com.example.wczy.sunshineairlines_android_70.tools.Tools;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Search_Flights_Results extends AppCompatActivity {
    //声明控件
    private TextView tv_tf;
    private ListView lv_list;
    private List<Ticket> tickets;
    private Intent intent;
    private String ct,url;
    //接收消息
    Handler h = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 4:
                    //实例化tickets对象
                    tickets = new ArrayList<Ticket>();
                    JSONArray ja = null;
                    String code = (String) msg.obj;
                    try {
                        //解析json
                        ja = new JSONArray(code);
                        //解析的json对象为零个则提示消息
                        if(ja.length() == 0){
                            Toast.makeText(Search_Flights_Results.this,"搜索失败！请选择正确的航班",Toast.LENGTH_SHORT).show();
                        }
                        for (int i = 0; i < ja.length(); i++) {
                            JSONObject jsonObject = ja.getJSONObject(i);
                            //创建ticket对象
                            Ticket ticket = new Ticket();
                            //设置票内的信息
                            ticket.setId(jsonObject.getString("Id"));
                            ticket.setAirlineName(jsonObject.getString("AirlineName"));
                            ticket.setFlightNumber(jsonObject.getString("FlightNumber"));
                            ticket.setPrice(jsonObject.getString("Price"));
                            ticket.setDepartureTime(jsonObject.getString("DepartureTime"));
                            ticket.setArriveTime(jsonObject.getString("ArriveTime"));
                            ticket.setAircraft(jsonObject.getString("Aircraft"));
                            ticket.setAvailableTickets(jsonObject.getString("AvailableTickets"));
                            ticket.setFrom(jsonObject.getString("From"));
                            ticket.setTo(jsonObject.getString("To"));
                            ticket.setCabinType(ct);
                            //添加到集合
                            tickets.add(ticket);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    //设置搜索到票的总数
                    tv_tf.setText("Total "+ tickets.size()+ " flights");
                    //创建ticket适配器
                    TicketAdapter ticketAdapter = new TicketAdapter(tickets, Search_Flights_Results.this);
                    //添加到ListView里面
                    lv_list.setAdapter(ticketAdapter);
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search__flights__results);
        //找到控件
        tv_tf = (TextView) findViewById(R.id.tv_SFR_TF);
        lv_list = (ListView) findViewById(R.id.lv_SFR_list);
        //接收上一个界面发送过来的消息
        intent = getIntent();
        ct = intent.getStringExtra("ct");
        url = intent.getStringExtra("url");
        getcode(url);
    }
    //获取json码
    public void getcode(final String url1){
        new Thread(new Runnable() {
            @Override
            public void run() {
                String jsonCode = Tools.getJsonCode(url1,"GET");
                h.sendMessage(Tools.getMessage(4,jsonCode));
            }
        }).start();
    }
    //返回到查询航班界面
    public void sfrBack(View v){
        startActivity(new Intent(Search_Flights_Results.this,Search_Flights.class));
        finish();
    }
}
