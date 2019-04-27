package com.example.mymusicplayer.activities;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mymusicplayer.R;

public class BaseActivity extends Activity {

    private ImageView ivBack;
    private TextView tvTitle;
    private ImageView ivHome;


    private <T extends View> T fd(@IdRes int resId) {
        return findViewById(resId);
    }

    protected void initNavBar(boolean isShowBack, String title, boolean isShowHome) {
        //ivBack = (ImageView) fd(R.id.iv_back);
        ivBack = (ImageView) findViewById(R.id.iv_back);
        tvTitle = (TextView) findViewById(R.id.tv_show_title);
        ivHome = (ImageView) findViewById(R.id.iv_home);

        ivBack.setVisibility(isShowBack ? View.VISIBLE : View.GONE);
        ivHome.setVisibility(isShowHome ? View.VISIBLE : View.GONE);
        tvTitle.setText(title);

        ivBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        ivHome.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //跳转到个人中心
                startActivity(new Intent(BaseActivity.this, MeActivity.class));
            }
        });
    }
}
