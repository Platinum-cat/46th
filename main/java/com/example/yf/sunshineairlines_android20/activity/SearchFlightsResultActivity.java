package com.example.yf.sunshineairlines_android20.activity;


import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.example.yf.sunshineairlines_android20.R;
import com.example.yf.sunshineairlines_android20.bean.FlightInfo;
import com.example.yf.sunshineairlines_android20.holder.MyHolder;
import com.example.yf.sunshineairlines_android20.holder.TicketInfoHolder;
import com.example.yf.sunshineairlines_android20.simpleView.SimpleActivity;
import com.example.yf.sunshineairlines_android20.simpleView.SimpleListView;
import com.example.yf.sunshineairlines_android20.utils.MyUtils;

import java.util.List;
import java.util.concurrent.Callable;


public class SearchFlightsResultActivity extends SimpleActivity {

    private TextView tvTotal;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_search_flights_result);
        tvTotal = (TextView) findViewById(R.id.tvTotal);
    }

    @Override
    protected void createEvent() {
        registerClickEvent(R.id.btBack);
        //拦截返回键执行对应事件
        onReturnKeyDown(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        });
        final String urlStr = intent.getStringExtra("urlStr");
        String result = null;
        try {
            //开起一个线程接收返回值
            result = startThread(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return MyUtils.getWebRes(urlStr);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (result != null){
            List<FlightInfo> flightInfos = null;
            try {
                //获取json转换的List集合
                flightInfos = MyUtils.parseJsonByBean(result, FlightInfo.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (flightInfos != null){
                if (flightInfos.size() > 0) {
                    //设置界面的总票数
                    tvTotal.setText("Total "+flightInfos.size() + " flights");
                    //存入json获取不到的数据
                    String ct = intent.getStringExtra("ct");
                    for (FlightInfo info : flightInfos) {
                        info.setCabinType(ct);
                    }
                    //实例化对应布局的Holder
                    MyHolder<FlightInfo> flightInfoMyHolder = new TicketInfoHolder(R.layout.ticket_info_item, this, flightInfos);
                    //使用SimpleListView对ListView进行操作
                    SimpleListView slv = new SimpleListView(R.id.lvTickets, this, flightInfoMyHolder){
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            FlightInfo info = (FlightInfo) view.getTag();
                            intent.putExtra("ticketInfo", info);
                            jump(SelectSeatsActivity.class);
                        }
                    };
                    //设置ListView的点击事件
                    slv.setOnItemClickListener();
                    //设置ListView的适配器
                    slv.setAdapter();
                }else {
                    //如果集合内没有元素则显示消息
                    toastMsg("没有该航班的信息!");
                }
            }
        }
    }

    /**
     * 设置Back按键的点击事件为结束当前界面
     * @param view
     */
    @Override
    protected void clickEvent(View view) {
        finish();
    }
}
