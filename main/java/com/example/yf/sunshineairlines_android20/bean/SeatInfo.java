package com.example.yf.sunshineairlines_android20.bean;

/**
 * Created by yf on 2020/4/6.
 */

public class SeatInfo {
    private String FlightId;
    private String UserId;
    private String CabinType;
    private String ColumnName;
    private String RowNumber;

    public String getFlightId() {
        return FlightId;
    }

    public void setFlightId(String flightId) {
        FlightId = flightId;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getCabinType() {
        return CabinType;
    }

    public void setCabinType(String cabinType) {
        CabinType = cabinType;
    }

    public String getColumnName() {
        return ColumnName;
    }

    public void setColumnName(String columnName) {
        ColumnName = columnName;
    }

    public String getRowNumber() {
        return RowNumber;
    }

    public void setRowNumber(String rowNumber) {
        RowNumber = rowNumber;
    }

    public SeatInfo() {

    }
}
