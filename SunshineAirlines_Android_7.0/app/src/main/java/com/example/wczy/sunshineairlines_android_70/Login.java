package com.example.wczy.sunshineairlines_android_70;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.wczy.sunshineairlines_android_70.tools.Tools;

public class Login extends AppCompatActivity {
    //声明控件
    private EditText et_email,et_pwd;
    private Button bt_login;
    private SharedPreferences spf;
    private SharedPreferences.Editor editor;
    //接受消息进行处理
    Handler h = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    String obj = (String) msg.obj;
                    //判断接受的值是否为true
                    if ("true".equals(obj)){
                        Toast.makeText(Login.this,"登陆成功！",Toast.LENGTH_SHORT).show();
                        spf = getSharedPreferences("data",MODE_PRIVATE);
                        editor = spf.edit();
                        editor.putString("userName",et_email.getText().toString());
                        editor.apply();
                        startActivity(new Intent(Login.this, Main.class));
                        finish();
                    }else {
                        Toast.makeText(Login.this,"登陆失败，用户名或密码错误！",Toast.LENGTH_SHORT).show();
                    }
                    break;

            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //找到控件
        et_email = (EditText) findViewById(R.id.et_L_email);
        et_pwd = (EditText) findViewById(R.id.et_L_pwd);
        bt_login = (Button) findViewById(R.id.bt_L_login);
        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //开启子线程
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        //获取网页返回值
                        String jsonCode = Tools.getJsonCode(Tools.USER_LOGIN_PARAM1 + et_email.getText() + Tools.USER_LOGIN_PARAM2 + et_pwd.getText());
                        //发送返回的值到界面
                        h.sendMessage(Tools.getMessage(1,jsonCode));
                    }
                }).start();
            }
        });
    }
}
