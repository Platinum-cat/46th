package com.example.yf.sunshineairlines_android20.simpleView;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.widget.VideoView;

/**
 * Created by yf on 2020/4/10.
 * VideoView简化类
 */

public class SimpleVideoView {

    private VideoView videoView;

    public SimpleVideoView(Context context, int ifForVideoView) {
        this.videoView = ((Activity)context).findViewById(ifForVideoView);
    }

    /**
     *设置视频路径并开始播放
     * @param path
     */
    public void setVideoPath(String path){
        videoView.setVideoURI(Uri.parse(path));
        videoView.start();
    }

    /**
     * 设置循环播放
     */
    public void setLooping(){

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
                mp.setLooping(true);
            }
        });

    }

    /**
     * 设置该视屏跳转到什么位置
     * @param msec
     */
    public void seekTo(int msec) {
        videoView.seekTo(msec);
    }

    public int getProgress(){
         return videoView.getCurrentPosition();
    }
}
