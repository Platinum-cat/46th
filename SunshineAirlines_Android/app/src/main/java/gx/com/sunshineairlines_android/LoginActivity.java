package gx.com.sunshineairlines_android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import gx.com.sunshineairlines_android.Utils.HttpUtils;


/**
 * Created by 77344 on 2020/1/3.
 */

/**
 * 登录页面
 */
public class LoginActivity extends Activity {
    EditText email;
    EditText password;

    android.os.Handler h = new android.os.Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    // 判断账号密码
                    String loginTest = (String) msg.obj;
//                    Log.i("测试",loginTest);
                    if (loginTest.equals("true")){
                        Toast.makeText(LoginActivity.this,"登录完成",Toast.LENGTH_SHORT);
                        startActivity(new Intent(LoginActivity.this,MainScreen.class));
                        finish();
                    }else{
                        Toast.makeText(LoginActivity.this,"登录失败",Toast.LENGTH_SHORT);
                        finish();
                    }
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//        final ArrayList<Float> list =new ArrayList<>();
//        findViewById(R.id.pake1).setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                switch (event.getAction()){
//                    case MotionEvent.ACTION_MOVE:
//                        float rawx=event.getRawX();
//                        list.add(rawx);
//                        if (list.size()>2&&list.get(list.size()-1)-list.get(list.size()-2)>5){
//                            startActivity(new Intent(LoginActivity.this,MainActivity.class));
//                        }else  if (list.size()>2&&list.get(list.size()-1)-list.get(list.size()-2)<5){
//
//                        }
//
//                }
//                return false;
//            }
//        });

        //获取组件
        email = (EditText) findViewById(R.id.editText_email);
        password = (EditText) findViewById(R.id.editText_password);

        final String[] loginText = {null};
        //获取登录按钮
        Button button_login = (Button) findViewById(R.id.login_buttonLogin);
        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new Thread(new Runnable() {//子线程请求网络
                    @Override
                    public void run() {
                        String loginResponse = HttpUtils.Login(email.getText().toString(), password.getText().toString());
//                        Log.i("HAHA", "run: "+loginResponse);
                        Message msg = new Message();
                        msg.what=1;
                        msg.obj=loginResponse;
                        h.sendMessage(msg);
                    }
                }).start();
            }
        });
    }
}
