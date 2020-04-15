package com.example.yf.sunshineairlines_android20.activity;

import android.view.View;
import android.widget.EditText;

import com.example.yf.sunshineairlines_android20.R;
import com.example.yf.sunshineairlines_android20.bean.User;
import com.example.yf.sunshineairlines_android20.simpleView.SimpleActivity;
import com.example.yf.sunshineairlines_android20.utils.MyUtils;

import java.util.List;
import java.util.concurrent.Callable;

public class LoginActivity extends SimpleActivity {
    //声明需要的控件
    private EditText etEmail, etPwd;

    @Override
    protected void initView(){
        setContentView(R.layout.activity_login);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPwd = (EditText) findViewById(R.id.etPwd);
    }

    @Override
    protected void createEvent() {
        //给对应id设置点击事件
        registerClickEvent(R.id.btLogin);
    }

    @Override
    protected void clickEvent(View view) {
        String result = null;
        try {
            //开启一个有返回值的线程并接受返回值
            result = startThread(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    String email = etEmail.getText().toString().trim();
                    String pwd = etPwd.getText().toString().trim();
                    //使用自定义的工具类获取网络资源
                    return MyUtils.getWebRes("/api/login?Email=" + email + "&Password=" + pwd);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (result != null) {
            //判断登录是否成功
            if ("true".equals(result)) {
                toastMsg("登陆成功！");
                String userInfo = null;
                try {
                    //根据email获取该用户信息
                    userInfo = startThread(new Callable<String>() {
                        @Override
                        public String call() throws Exception {
                            return MyUtils.getWebRes("/api/user/" + etEmail.getText());
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (userInfo != null){
                    List<User> users = null;
                    try {
                        //根据用户信息Json解析为对应对象
                        users = MyUtils.parseJsonByBean(userInfo, User.class);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (users != null){
                        //将该对象存入intent
                        intent.putExtra("userInfo", users.get(0));
                    }
                }
                jumpAndFinish(MainActivity.class);
            } else {
                toastMsg("登陆失败！");
            }
        }
    }
}
