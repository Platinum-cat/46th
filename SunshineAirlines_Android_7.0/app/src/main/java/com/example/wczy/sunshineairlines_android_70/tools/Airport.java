package com.example.wczy.sunshineairlines_android_70.tools;

/**
 * Created by wczy on 2020/1/4.
 */
//机场代码类
public class Airport {
    String IATA;
    String Name;

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
}
