package com.example.wczy.sunshineairlines_android_70.tools;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.wczy.sunshineairlines_android_70.R;

import java.util.List;

/**
 * Created by wczy on 2020/1/4.
 */
//机票适配器
public class TicketAdapter extends BaseAdapter {
    List<Ticket> tickets;
    LayoutInflater lif;

    public TicketAdapter(List<Ticket> lt, Context context) {
        this.tickets = lt;
        this.lif = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return tickets.size();
    }

    @Override
    public Object getItem(int i) {
        return tickets.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = lif.inflate(R.layout.item_ticket,null);
        TextView viewById = v.findViewById(R.id.tv_T_an);
        viewById.setText(tickets.get(i).getAirlineName());
        TextView viewById1 = v.findViewById(R.id.tv_T_avatic);
        viewById1.setText(tickets.get(i).getAvailableTickets()+" available tickets");
        TextView viewById2 = v.findViewById(R.id.tv_T_fn);
        viewById2.setText("Flight Number: "+tickets.get(i).getFlightNumber());
        TextView viewById3 = v.findViewById(R.id.tv_T_date);
        viewById3.setText(tickets.get(i).getDepartureTime().split(" ")[0]);
        TextView viewById4 = v.findViewById(R.id.tv_T_price);
        viewById4.setText("Price: "+tickets.get(i).getPrice());
        TextView viewById5 = v.findViewById(R.id.tv_T_ct);
        viewById5.setText("Cabin Type: "+tickets.get(i).getCabinType());
        TextView viewById6 = v.findViewById(R.id.tv_T_air);
        viewById6.setText("Aircraft: "+tickets.get(i).getAircraft());
        TextView viewById7 = v.findViewById(R.id.tv_T_use);
        viewById7.setText(Tools.useTime(tickets.get(i).getDepartureTime(),tickets.get(i).ArriveTime));
        return v;
    }

}
