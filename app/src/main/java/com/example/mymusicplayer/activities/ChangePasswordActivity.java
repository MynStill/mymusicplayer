package com.example.mymusicplayer.activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.mymusicplayer.R;

public class ChangePasswordActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        initView();
    }

    /**
     * 初始化View
     * */
    private void initView() {
        initNavBar(true, "修改密码", false);
    }

    /**
     * 确认修改密码
     * */
    public void onConfirmChangeClick(View v) {
        Toast.makeText(this, "确认修改密码", Toast.LENGTH_SHORT).show();
    }
}
