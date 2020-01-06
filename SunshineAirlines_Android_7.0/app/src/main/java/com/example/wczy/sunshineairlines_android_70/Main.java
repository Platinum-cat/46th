package com.example.wczy.sunshineairlines_android_70;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.wczy.sunshineairlines_android_70.tools.Tools;

import org.json.JSONArray;
import org.json.JSONObject;

public class Main extends AppCompatActivity {
    //声明控件
    private Button bt_sf, bt_mmp, bt_logout;
    private VideoView vv_video;
    private TextView tv_sponsors;
    //接收消息进行操作
    Handler h = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 2:
                    StringBuffer stringBuffer = new StringBuffer();
                    String obj = (String) msg.obj;
                    try {
                        //解析json
                        JSONArray jsonArray = new JSONArray(obj);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            //添加进字符缓存
                            stringBuffer.append(jsonObject.getString("Name")+ " ");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    //设置赞助商信息
                    tv_sponsors.setText(stringBuffer.toString());
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //找到控件
        tv_sponsors = (TextView) findViewById(R.id.tv_M_sponsors);
        bt_sf = (Button) findViewById(R.id.bt_M_sf);
        bt_logout = (Button) findViewById(R.id.bt_M_logout);
        vv_video = (VideoView) findViewById(R.id.vv_M_video);
        tv_sponsors.setSelected(true);
        //设置播放视频路径
        vv_video.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.video));
        vv_video.start();
        vv_video.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.start();
                //循环播放
                mediaPlayer.setLooping(true);
            }
        });
        setTv_sponsors();
    }
    public void setTv_sponsors(){
        //开启子线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                //获取网页返回值
                String jsonCode = Tools.getJsonCode(Tools.LIST_OF_SPONSORS);
                //发送到界面
                h.sendMessage(Tools.getMessage(2,jsonCode));
            }
        }).start();
    }
    //跳转到查询航班界面
    public void mSf(View v){
        startActivity(new Intent(Main.this,Search_Flights.class));
        finish();
    }
    //返回到登录界面
    public void mLogout(View v){
        startActivity(new Intent(Main.this,Login.class));
        finish();
    }
    //跳转到积分界面
    public void mMmp(View v){
        startActivity(new Intent(Main.this,My_Mileage_Points.class));
        finish();
    }
}
