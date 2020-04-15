package com.example.yf.sunshineairlines_android20.bean;

/**
 * Created by yf on 2020/4/4.
 */

/**
 * 用户及分类
 */
public class PointInfo {
    private String UserId;
    private String Points;
    private String Date;

    public PointInfo() {
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getPoints() {
        return Points;
    }

    public void setPoints(String points) {
        Points = points;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public PointInfo(String userId, String points, String date) {

        UserId = userId;
        Points = points;
        Date = date;
    }
}
