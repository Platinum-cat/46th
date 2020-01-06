package com.example.wczy.sunshineairlines_android_70.tools;

import android.os.Message;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by wczy on 2020/1/4.
 */
//工具类
public class Tools {
    //定义需要的api网址
    public final static String ROOT_URL = "http://192.168.72.145:8080";
    public final static String USER_LOGIN_PARAM1 = "/api/login?Email=";
    public final static String USER_LOGIN_PARAM2 = "&Password=";
    public final static String LIST_OF_SPONSORS = "/api/sponsor/list";
    public final static String LIST_OF_AIRPORTS = "/api/airport/list";
    public final static String DATA_OF_FLIGHTS_PARAM1 = "/api/flight/list?From=";
    public final static String DATA_OF_FLIGHTS_PARAM2 = "&To=";
    public final static String DATA_OF_FLIGHTS_PARAM3 = "&CabinType=";
    public final static String DATA_OF_FLIGHTS_END= "&Date=2018-0625&isAsc=1";
    public final static String POINT_BY_USERID = "/api/mileagepoints/1";
    public final static String USER_BY_EMAIL = "/api/user/";
    //获取json码
    public static String getJsonCode(String url, String type){
        StringBuffer stringBuffer = new StringBuffer();
        try{
            URL url1 = new URL(ROOT_URL + url);
            //打开链接
            HttpURLConnection urlConnection = (HttpURLConnection) url1.openConnection();
            //设置亲求方式
            urlConnection.setRequestMethod(type);
            //获取数据流
            InputStream inputStream =urlConnection.getInputStream();
            //读取数据流
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            //读取数据
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String code = null;
            //当读取的数据不为空时存入字符缓存器
            while ((code = bufferedReader.readLine()) != null){
                stringBuffer.append(code);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        //返回字符串
        return stringBuffer.toString();
    }
    //重载默认post请求
    public static String getJsonCode(String url){
        return getJsonCode(url,"POST");
    }
    //装载消息
    public static Message getMessage(int what,String obj){
        //创建消息对象
        Message message = new Message();
        //设置消息类型
        message.what = what;
        //设置消息内容
        message.obj = obj;
        //返回消息
        return message;
    }
    //获取航班用时
    public static String useTime(String departureTime, String arriveTime){
        //分开出发日期、返回日期的年月日和时分
        String[] split1 = departureTime.split(" ");
        String[] split2 = arriveTime.split(" ");
        //分开出发日期、返回日期的时和分
        String[] split1_1 = split1[1].split(":");
        String[] split2_1 = split2[1].split(":");
        //将出发日期、返回日期的时分转换成整型
        int d_h = new Integer(split1_1[0]);
        int d_m = new Integer(split1_1[1]);
        int a_h = new Integer(split2_1[0]);
        int a_m = new Integer(split2_1[1]);
        //将到达时间减去出发时间算出实际耗时
        int h = ((a_h * 60 + a_m) - (d_h * 60 + d_m)) / 60;
        int m = ((a_h * 60 + a_m) - (d_h * 60 + d_m)) % 60;
        //如果时和分小于10在前面加"0"
        String hou = "";
        String min = "";
        if(h < 10){
            hou = new String("0" + h);
        }else {
            hou = String.valueOf(h);
        }
        if(m < 10){
            min = new String("0" + m);
        }else {
            min = String.valueOf(m);
        }
        //以时：分的格式返回实际用时
        return hou + ":" + min;
    }
}
