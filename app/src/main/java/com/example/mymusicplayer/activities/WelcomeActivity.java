package com.example.mymusicplayer.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.mymusicplayer.R;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

// 1、进入WELCOME页面
// 2、3秒后进入MainActicity页面
public class WelcomeActivity extends BaseActivity {

    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        init();
    }

    /*
    * 初始化
    * */
    private void init(){
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                //在主线程当中运行
                //Log.e("WelcomeActivity", "当前线程：" + Thread.currentThread());
                //toMian();
                toLogin();
            }
        }, 3 * 1000);
    }

    /**
     * 在MainActivity中运行
     * */
    private void toMian() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    /**
     * 在LoginActivity中运行
     * */
    private void toLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
