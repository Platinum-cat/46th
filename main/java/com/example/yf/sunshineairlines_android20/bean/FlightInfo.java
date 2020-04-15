package com.example.yf.sunshineairlines_android20.bean;

/**
 * Created by yf on 2020/4/4.
 */

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 航班信息类
 */
public class FlightInfo implements Serializable {
    private String Id;
    private String AirlineName;
    private String FlightNumber;
    private String Price;
    private String DepartureTime;
    private String ArriveTime;
    private String Aircraft;
    private String AvailableTickets;
    private String From;
    private String cabinType;

    public FlightInfo() {
    }

    @Override
    public String toString() {
        return "Id = "+ Id + ",AirlineName = " + AirlineName;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getAirlineName() {
        return AirlineName;
    }

    public void setAirlineName(String airlineName) {
        AirlineName = airlineName;
    }

    public String getFlightNumber() {
        return FlightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        FlightNumber = flightNumber;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getDepartureTime() {
        return DepartureTime;
    }

    public void setDepartureTime(String departureTime) {
        DepartureTime = departureTime;
    }

    public String getArriveTime() {
        return ArriveTime;
    }

    public void setArriveTime(String arriveTime) {
        ArriveTime = arriveTime;
    }

    public String getAirCraft() {
        return Aircraft;
    }

    public void setAirCraft(String airCraft) {
        Aircraft = airCraft;
    }

    public String getAvailableTickets() {
        return AvailableTickets;
    }

    public void setAvailableTickets(String availableTickets) {
        AvailableTickets = availableTickets;
    }

    public String getFrom() {
        return From;
    }

    public void setFrom(String from) {
        From = from;
    }

    public String getTo() {
        return To;
    }

    public void setTo(String to) {
        To = to;
    }

    public FlightInfo(String id, String airlineName, String flightNumber, String price, String departureTime, String arriveTime, String airCraft, String availableTickets, String from, String to) {

        Id = id;
        AirlineName = airlineName;
        FlightNumber = flightNumber;
        Price = price;
        DepartureTime = departureTime;
        ArriveTime = arriveTime;
        Aircraft = airCraft;
        AvailableTickets = availableTickets;
        From = from;
        To = to;
    }

    private String To;
    public String getTime(){
        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm");
        long actualTime = -1;
        try {
            Date depTime = simpleDateFormat.parse(DepartureTime);
            Date arrTime = simpleDateFormat.parse(ArriveTime);
            actualTime = arrTime.getTime() - depTime.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (actualTime > 0){
            simpleDateFormat.applyPattern("HH:mm");
            String format = simpleDateFormat.format(new Date(actualTime));
            return format;
        }
        return "时间获取异常！";
    }

    public String getCabinType() {
        return cabinType;
    }

    public void setCabinType(String cabinType) {
        this.cabinType = cabinType;
    }
}
