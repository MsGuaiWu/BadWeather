package com.cl.badweather.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * @author: cl
 * @date: 2022/5/1
 */
public class APKVersionInfoUtils  {
    /**
     * 获取当前本地apk的版本
     * @param mContext
     * @return
     */
    public static int getVersionCode(Context mContext){
        int versionCode = 0;
        try {
            //获取软件版本号，对应AndroidMainifest.xml下android:versionCode
            versionCode = mContext.getPackageManager().getPackageInfo(mContext.getPackageName(),0).versionCode;
        }catch (PackageManager.NameNotFoundException e){
            e.printStackTrace();
        }
        return versionCode;
    }

    /**
     * 获取版本号名称
     * @param context
     * @return
     */
    public static String getVerName(Context context) {
        String verName = "";
        try {
            verName = context.getPackageManager().getPackageInfo(context.getPackageName(),0).versionName;

        }catch (PackageManager.NameNotFoundException e){
            e.printStackTrace();
        }
        return verName;
    }
}
