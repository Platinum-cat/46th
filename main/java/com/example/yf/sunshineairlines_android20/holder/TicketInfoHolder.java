package com.example.yf.sunshineairlines_android20.holder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.yf.sunshineairlines_android20.R;
import com.example.yf.sunshineairlines_android20.bean.FlightInfo;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by yf on 2020/4/14.
 * 处理Ticket布局文件的类
 */

public class TicketInfoHolder extends MyHolder<FlightInfo> {

    //ticket布局文件内的控件
    public TextView AirlineName, AvailableTickets, FlightNumber, DepartureTime;

    public TextView Price, cabinType, Aircraft, Time;

    //布局填充器
    private LayoutInflater lif;

    //Ticket布局文件的Id
    private int parentId;


    /**
     * 传入Ticket布局文件的id、上下文、需要填充的数据集
     * @param parentId
     * @param context
     * @param list
     */
    public TicketInfoHolder(int parentId, Context context, List list) {
        super(list);
        lif = LayoutInflater.from(context);
        this.parentId = parentId;
    }

    /**
     * 根据布局文件实例化对应控件
     * @param parentId
     * @return
     */
    private View findViewByParent(int parentId) {
        View parentView = lif.inflate(parentId, null);
        
        AirlineName = parentView.findViewById(R.id.tvT_AirlineName);
        AvailableTickets = parentView.findViewById(R.id.tvT_AvailableTickets);
        FlightNumber = parentView.findViewById(R.id.tvT_FlightNumber);
        DepartureTime = parentView.findViewById(R.id.tvT_DepartureTime);
        Price = parentView.findViewById(R.id.tvT_Price);
        cabinType = parentView.findViewById(R.id.tvT_CabinType);
        Aircraft = parentView.findViewById(R.id.tvT_Aircraft);
        Time = parentView.findViewById(R.id.tvT_Time);

        return parentView;
    }

    /**
     * 根据position设置控件的值
     * @param position
     * @return
     */
    @Override
    public View setValueByPosition(int position) {
        View viewByParent = findViewByParent(parentId);
        FlightInfo flightInfo = infos.get(position);
        //设置当前数据的对象可带到下一个界面
        viewByParent.setTag(flightInfo);
        AirlineName.setText(flightInfo.getAirlineName());
        AvailableTickets.setText(flightInfo.getAvailableTickets() + " available tickets");
        FlightNumber.setText("FlightNumber: "+flightInfo.getFlightNumber());
        Aircraft.setText("Aircraft: "+flightInfo.getAirCraft());
        DepartureTime.setText(flightInfo.getDepartureTime());
        Time.setText("Time: "+flightInfo.getTime());
        Price.setText("Price: "+flightInfo.getPrice());
        cabinType.setText("Cabin Type: " + flightInfo.getCabinType());
      return viewByParent;
    }
}
