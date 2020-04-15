package com.example.yf.sunshineairlines_android20.activity;

import android.view.View;
import android.widget.TextView;

import com.example.yf.sunshineairlines_android20.R;
import com.example.yf.sunshineairlines_android20.simpleView.SimpleActivity;
import com.example.yf.sunshineairlines_android20.simpleView.SimpleVideoView;
import com.example.yf.sunshineairlines_android20.utils.MyUtils;

import org.json.JSONException;

import java.util.concurrent.Callable;

public class MainActivity extends SimpleActivity {

    private TextView tvSp;

    private SimpleVideoView svv;

    @Override
    protected void initView(){
        setContentView(R.layout.activity_main);
        tvSp = (TextView) findViewById(R.id.tvSponsorInfo);
        svv = new SimpleVideoView(MainActivity.this, R.id.vvVideo);
    }

    @Override
    protected void createEvent() {
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.main;
        //设置视频播发路径
        svv.setVideoPath(videoPath);
        //设置循环播放
        svv.setLooping();
        //给对应按钮设置点击事件事件
        registerClickEvent(R.id.btLogout, R.id.btMyMileagePoints, R.id.btSearchFlights);
        //设置赞助商控件为被选中状态
        tvSp.setSelected(true);
        //获取File文件夹的赞助商信息
        String sponsorNames = readFileData("sponsorNames.txt");
        if (sponsorNames != null){
            //如果不为空则设置赞助商控件的文字为该信息
            tvSp.setText(sponsorNames);
        }else {
            //为空则获取网络资源
            String result = null;
            try {
                result = startThread(new Callable<String>() {
                    @Override
                    public String call() throws Exception {
                        return MyUtils.getWebRes("/api/sponsor/list");
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (result != null) {
                String names = null;
                try {
                    names = MyUtils.parseJsonbyKey(result, "Name");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (names != null) {
                    tvSp.setText(names);
                }
                writeFileData("sponsorNames.txt", MODE_PRIVATE, names);
            }
        }
    }
    /**
     * 设置点击事件
     */
    @Override
    protected void clickEvent(View view) {
        switch (view.getId()){
            case R.id.btLogout:
                jumpAndFinish(LoginActivity.class);
                break;
            case R.id.btMyMileagePoints:
                intent.putExtra("msec", svv.getProgress());
                jump(MyMileagePointsActivity.class);
                break;
            case R.id.btSearchFlights:
                intent.putExtra("msec", svv.getProgress());
                jump(SearchFlightActivity.class);
                break;
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        svv.seekTo(intent.getIntExtra("msec", 0));
    }
}
