package com.example.yf.sunshineairlines_android20.utils;

import android.os.Handler;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yf on 2020/4/10.
 */

public class MyUtils extends Handler {
    //根路径
    private static final String ROOT_URL = "http://192.168.1.103:8080";

    private MyUtils(){}

    /**
     * 获取网络资源默认GET请求
     * @param path  资源路径
     * @return  返回获取到的资源
     */
    public static String getWebRes(String path){
        return getWebRes(path, "GET");
    }

    /**
     * 获取网络资源
     * @param path  资源路径
     * @param mode  请求模式
     * @return  返回获取到的资源
     */
    public static String getWebRes(String path, String mode){
        BufferedReader bis = null;
        StringBuffer stringBuffer = null;
        try{
            URL url = new URL(ROOT_URL + path);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(mode);
            bis = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line = null;
            stringBuffer = new StringBuffer("");
            while ((line = bis.readLine()) != null){
                stringBuffer.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (bis != null){
                try {
                    bis.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return stringBuffer.toString();
    }

    /**
     * 根据对应的key解析Json返回拼接好的字符串
     * @param jsonStr  Json字符串
     * @param key
     * @return
     */
    public static String parseJsonbyKey(String jsonStr, String key) throws JSONException{
        StringBuffer stringBuffer = new StringBuffer();
        JSONArray jsonArray = new JSONArray(jsonStr);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            stringBuffer.append(jsonObject.get(key));
            if (i < jsonArray.length() - 1) {
                stringBuffer.append(", ");
            }
        }
        return stringBuffer.toString();
    }

    /**
     * 根据bean类型解析Json并填充bean 返回 bean集合
     * @param jsonStr Json 字符串
     * @param bean 对应对象
     * @param <T>   对象类型
     * @return  bean集合
     */
    public static <T> List<T> parseJsonByBean(String jsonStr, Class<T> bean) throws Exception{
        //创建jsonArray对象
        JSONArray jsonArray = new JSONArray(jsonStr);
        //创建就集合存储实例好的T对象
        List<T> beans = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            //获取jsonObject
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            //实例化T对象
            T tInstance = bean.newInstance();
            //获得全部T的属性
            Field[] declaredFields = bean.getDeclaredFields();
            //遍历所有属性
            for (Field declaredField : declaredFields) {
                Object o = null;
                try{
                    //更具属性的名称获取jsonObject对应的值
                    o = jsonObject.get(declaredField.getName());
                }catch (Exception e){
                    Log.d(declaredField.getName(), "未赋值！");
                }
                if (o != null) {
                    //禁用属性的安全检查
                    declaredField.setAccessible(true);
                    //设置instance的对应属性
                    declaredField.set(tInstance, o);
                }
            }
            //将设置好属性的tInstance对象加进List里
            beans.add(tInstance);
        }
        return beans;
    }


}
