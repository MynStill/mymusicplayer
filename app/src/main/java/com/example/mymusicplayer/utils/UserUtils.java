package com.example.mymusicplayer.utils;

import android.content.Context;
import android.content.Intent;
import android.service.autofill.RegexValidator;
import android.text.TextUtils;
import android.widget.Toast;

import com.blankj.utilcode.util.RegexUtils;
import com.example.mymusicplayer.activities.LoginActivity;

public class UserUtils {

    /**
     * 验证登录是否成功
     * */
    public static boolean validateLogin(Context context, String phone, String password){
        if(!RegexUtils.isMobileExact(phone)){
            Toast.makeText(context, "无效手机号", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(context, "密码不能为空", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    /**
     * 退出登录 并返回到登录界面
     * */
    public static void logout(Context context){
        Intent intent = new Intent(context, LoginActivity.class);
        //退出登录跳到登录界面后，需要清掉栈中所有Activity
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
