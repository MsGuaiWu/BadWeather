package com.cl.badweather.utils;

import android.content.Context;
import android.widget.Toast;

/*
* 消息提示工具类
* */
public class ToastUtils {
    public static void showLongToast(Context context,CharSequence cl){
        Toast.makeText(context.getApplicationContext(),cl,Toast.LENGTH_LONG).show();
    }
    public static void showShortToast(Context context,CharSequence cl){
        Toast.makeText(context.getApplicationContext(),cl,Toast.LENGTH_SHORT).show();
    }
}
