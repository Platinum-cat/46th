package gx.com.sunshineairlines_android;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import gx.com.sunshineairlines_android.Utils.HttpUtils;

/**
 * Created by 77344 on 2020/1/5.
 */

/**
 * 菜单界面
 */
public class MainScreen extends Activity {
    Handler h = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    //获取赞助商信息
                    String jsonZanZhuShang = (String) msg.obj;
                    StringBuffer sb = new StringBuffer();
                    try {
                        JSONArray ja = new JSONArray(jsonZanZhuShang);
                        for (int i = 0; i < ja.length() ; i++) {
                            JSONObject jo = ja.getJSONObject(i);
                            sb.append(jo.get("Name")+"   ");
                        }
                        Log.i("json",sb.toString());
                        TextView textView = (TextView) findViewById(R.id.zanZhuShang);
                        textView.setText(sb.toString());
                        //让跑马灯跑起来
                        textView.setSelected(true);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainscreen);

        new Thread(){
            @Override
            public void run() {
                super.run();
                String jsonZanZhuShang = HttpUtils.getJsonCode(HttpUtils.ReturnJSONDataListOfSponsors,"POST");
                Log.i("json",jsonZanZhuShang.toString());
                Message message = new Message();
                message.what=1;
                message.obj=jsonZanZhuShang;
                h.sendMessage(message);
            }
        }.start();

        //视频路径
        final String _filePath = "android.resource://" + getPackageName() + "/" + R.raw.video;
        //获得控件
        VideoView videoView = (VideoView) findViewById(R.id.videoView);
        //设置路径
        videoView.setVideoPath(_filePath);
        //启动播放
        videoView.start();
        //添加事件
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
                mp.setLooping(true);
            }
        });

        //设置3个BUTTON,设置对应的转跳
        Button button_sf = (Button) findViewById(R.id.MainScreenButton_SeachFlight);
        button_sf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainScreen.this, ScreenFlightActivity.class));
            }
        });

        Button button_my = (Button) findViewById(R.id.MainScreenButton_My);
        button_my.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainScreen.this, MyActivity.class));
            }
        });

        Button button_logout = (Button) findViewById(R.id.MainScreenButton_Logout);
        button_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainScreen.this, LoginActivity.class));
            }
        });
    }


}
