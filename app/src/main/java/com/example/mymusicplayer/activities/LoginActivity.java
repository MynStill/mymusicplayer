package com.example.mymusicplayer.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.mymusicplayer.R;
import com.example.mymusicplayer.utils.UserUtils;
import com.example.mymusicplayer.views.InputView;

public class LoginActivity extends BaseActivity {

    private InputView mInputPhone, mInputPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
    }

    /**
     * 初始化View
     * */
    private void initView() {
        initNavBar(false, "登陆", false);

        mInputPhone = (InputView) findViewById(R.id.input_phone);
        mInputPassword = (InputView) findViewById(R.id.input_password);

    }

    /**
     * 跳转注册页面点击事件
     * */
    public void onRegisterClick(View v) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
        finish();
    }

    /**
     * 登录
     * */
    public void onCommitClick(View v) {
        String phone = mInputPhone.getInputStr();
        String password = mInputPassword.getInputStr();
        //验证登录是否成功
        /*if( !UserUtils.validateLogin(this, phone, password)){
            return;
        }*/
        //跳转到主页面
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
