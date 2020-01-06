package com.example.wczy.sunshineairlines_android_70.tools;

/**
 * Created by wczy on 2020/1/4.
 */
//机票类
public class Ticket {
    String Id;
    String AirlineName;
    String FlightNumber;
    String Price;
    String DepartureTime;
    String ArriveTime;
    String Aircraft;
    String AvailableTickets;
    String From;
    String To;

    public String getCabinType() {
        return CabinType;
    }

    public void setCabinType(String cabinType) {
        CabinType = cabinType;
    }

    String CabinType;

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

    public String getAircraft() {
        return Aircraft;
    }

    public void setAircraft(String aircraft) {
        Aircraft = aircraft;
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
}
