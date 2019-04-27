package com.example.mymusicplayer.activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.mymusicplayer.R;

public class RegisterActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initView();
    }

    /**
     * 初始化View
     * */
    private void initView(){
        initNavBar(true, "注册", false);
    }

    /**
     * 注册成功
     * */
    public void onRegisterClick(View v){
        Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
    }
}
