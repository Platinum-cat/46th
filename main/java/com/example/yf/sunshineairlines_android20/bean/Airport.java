package com.example.yf.sunshineairlines_android20.bean;

/**
 * Created by yf on 2020/4/4.
 */

/**
 * 航班类
 */
public class Airport {
    private String IATA;
    private String Name;

    public Airport() {
    }

    public String getIATA() {
        return IATA;
    }

    public void setIATA(String IATA) {
        this.IATA = IATA;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return Name;
    }

    public Airport(String IATA, String name) {
        this.IATA = IATA;
        Name = name;
    }
}
