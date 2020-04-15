package com.example.yf.sunshineairlines_android20.simpleView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.inputmethodservice.Keyboard;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.security.Key;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Created by yf on 2020/4/4.
 * AppCompatActivity简化类
 *      封装实用方法
 */
public abstract class SimpleActivity extends AppCompatActivity {

    protected Intent intent;

    private Toast toast;

    //可以获取返回值的线程
    private FutureTask futureTask;

    //轻型数据存储类
    protected SharedPreferences sharedPreferences;
    protected SharedPreferences.Editor editor;
    private Runnable keyEvent;

    /**
     * 加载页面
     * @param savedInstanceState
     */
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        intent = getIntent();
        initView();
        createEvent();
    }

    /**
     * 初始化操作和查找控件的方法
     */
    protected abstract void initView();

    /**
     * 具体逻辑事件
     */
    protected abstract void createEvent();

    /**
     * 实例化轻型数据存储类
     */
    protected void useSharedPreferences(){
        sharedPreferences = getPreferences(MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    /**
     * 弹出消息
     * @param msg 消息
     */
    protected void toastMsg(String msg){
        if (toast == null){
            toast = Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT);
        }else {
            toast.setText(msg);
        }
        toast.show();
    }

    /**
     * 开启一个线程
     * @param event
     */
    protected void startThread(final Runnable event){
        new Thread(event).start();
    }

    /**
     * 开启一个线程并且返回一个值
     * @param event
     * @param <T>
     * @return
     * @throws Exception
     */
    protected <T> T startThread(final Callable<T> event) throws Exception {
        futureTask = new FutureTask<T>(event);
        startThread(futureTask);
        return (T)getFutureResult();
    }

    /**
     * 获取线程返回的结果
     * @return
     * @throws Exception
     */
    private Object getFutureResult() throws Exception {
        return futureTask.get();
    }

    /**
     * 给对应id设注册点击事件
     * @param ids
     */
    protected void registerClickEvent(int... ids){
        for (int id : ids) {
            View viewById = findViewById(id);
            viewById.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickEvent(v);
                }
            });
        }
    }

    /**
     *给对应id设设置点击事件
     * @param view
     */
    protected void clickEvent(View view){
        toastMsg("这是默认点击事件！");
    }

    /**
     * 跳转界面执行相应事件并结束当前界面
     * @param target 目标界面
     */
    protected void jumpAndFinish(Class target){
        jump(target);
        finish();
    }
    /**
     * 跳转界面执行相应事件
     * @param target 目标界面
     */
    protected void jump(Class target){
        intent.setClass(getApplicationContext(), target);
        startActivity(intent);
    }

    /**
     * 向内部的File文件夹写入数据
     * @param name  数据名
     * @param mode  访问模式
     * @param resStr    数据
     */
    protected void writeFileData(String name, int mode, String resStr){
        BufferedWriter bw = null;
        try {

            bw = new BufferedWriter(new OutputStreamWriter(openFileOutput(name, mode)));

            bw.write(resStr);

            bw.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            closeRes(bw);
        }
    }

    /**
     * 获得内部的File对应name的数据
     * @param name  数据名
     * @return 数据
     */
    protected String readFileData(String name){
        BufferedReader br = null;
        try {

            br = new BufferedReader(new InputStreamReader(openFileInput(name)));

            String line = null;

            StringBuffer sb = new StringBuffer();

            while ((line = br.readLine()) != null){
                sb.append(line);
            }

            return sb.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally {
            closeRes(br);
        }
    }

    /**
     * 关闭资源
     * @param resources
     */
    private void closeRes(Closeable... resources){
        for (Closeable resource : resources) {
            if (resource != null){
                try {
                    resource.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 拦截返回键按键执行keyEvent事件
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == event.KEYCODE_BACK){
            if (keyEvent != null){
                keyEvent.run();
                return true;
            }else {
                return super.onKeyDown(keyCode, event);
            }
        }else {
            return super.onKeyDown(keyCode, event);
        }
    }

    /**
     * 设置返回键事件
     * @param keyEvent
     */
    protected void onReturnKeyDown(Runnable keyEvent){
        this.keyEvent = keyEvent;
    }
}
