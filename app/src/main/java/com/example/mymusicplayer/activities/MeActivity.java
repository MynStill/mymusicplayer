package com.example.mymusicplayer.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.mymusicplayer.R;
import com.example.mymusicplayer.utils.UserUtils;

public class MeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me);

        initView();
    }

    /**
     * 初始化View
     * */
    public void initView(){
        initNavBar(true, "个人中心", false);
    }

    /**
     * 修改密码
     * */
    public void onChangeClick(View v) {
        startActivity(new Intent(MeActivity.this, ChangePasswordActivity.class));
    }

    /**
     * 退出登录
     * */

    public void onLogoutClick(View v) {
        UserUtils.logout(this);
    }
}
