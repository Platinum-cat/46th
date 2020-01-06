package com.example.wczy.sunshineairlines_android_70;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.wczy.sunshineairlines_android_70.tools.Point;
import com.example.wczy.sunshineairlines_android_70.tools.PointAdapter;
import com.example.wczy.sunshineairlines_android_70.tools.Tools;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class My_Mileage_Points extends AppCompatActivity {
    //声明控件
    private ListView lv;
    private List<Point> a_p;
    private TextView tv_point,tv_user;
    private SharedPreferences spf;
    String userName;
    int sum = 0;
    //接收消息
    Handler h = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 5:
                    String code = (String) msg.obj;
                    try {
                        //实例化集合
                        a_p = new ArrayList<>();
                        //解析json
                        JSONArray jsonArray = new JSONArray(code);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            //创建积分对象
                            Point point = new Point();
                            //设置积分对象里面的值
                            point.setUserId(jsonObject.getString("UserId"));
                            point.setDate(jsonObject.getString("Date"));
                            point.setPoints(jsonObject.getString("Points"));
                            //将积分转换为整型再相加获得总积分
                            Integer integer = new Integer(jsonObject.getString("Points"));
                            sum += integer;
                            //将对象加进集合
                            a_p.add(point);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    //设置LIstView适配器
                    lv.setAdapter( new PointAdapter(a_p,My_Mileage_Points.this));
                    tv_point.setText(sum+" Points");
                    break;
                case 6:
                    //设置用户名
                    String code1 = (String) msg.obj;
                    String firstName = null;
                    String lastName = null;
                    try {
                        JSONArray jsonArray = new JSONArray(code1);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            firstName = jsonObject.getString("FirstName");
                            lastName = jsonObject.getString("LastName");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    tv_user.setText("Hi,Mr "+firstName+" "+lastName+" Your total mileage point is");
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my__mileage__points);
        //找到控件
        lv = (ListView) findViewById(R.id.lv_MMP_lv);
        tv_point = (TextView) findViewById(R.id.tv_MMP_points);
        tv_user = (TextView) findViewById(R.id.tv_MMP_name);
        //接收在Login存入的用户名
        spf = getSharedPreferences("data",MODE_PRIVATE);
        userName = spf.getString("userName",null);
        userName = userName.substring(0,8);
        getCode();
    }
    public void getCode(){
        //开启子线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                //获取json字符串
                String get = Tools.getJsonCode(Tools.POINT_BY_USERID, "GET");
                String get1 = Tools.getJsonCode(Tools.USER_BY_EMAIL + userName, "GET");
                //发送消息
                h.sendMessage(Tools.getMessage(5,get));
                h.sendMessage(Tools.getMessage(6,get1));
            }
        }).start();
    }
    //返回主界面
    public void mmBack(View v){
        startActivity(new Intent(My_Mileage_Points.this,Main.class));
    }
}
