package com.cl.badweather;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.NonNull;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.common.BaiduMapSDKException;
import com.cl.badweather.utils.ToastUtils;
import com.cl.mvplibrary.BaseApplication;
import com.cl.mvplibrary.net.NetworkApi;
import com.cl.mvplibrary.utils.ActivityManager;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechUtility;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreator;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreator;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;

import org.litepal.LitePal;

import pl.com.salsoft.sqlitestudioremote.SQLiteStudioService;

/**
 * @author: cl
 * @date: 2022/3/17
 */
public class WeatherApplication extends BaseApplication {
    /**
     * 应用实例
     */
    private static ActivityManager activityManager;
    private static Context context;
    private static WeatherApplication weatherApplication;
    private static Activity sActivity;
    public static Context getMyContext() {
        return weatherApplication == null ? null : weatherApplication.getApplicationContext();
    }
    private Handler myHandler;
    public Handler getMyHandler() {
        return myHandler;
    }
    public void setMyHandler(Handler handler) {
        myHandler = handler;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        SQLiteStudioService.instance().start(this);
        activityManager = new ActivityManager();
        context = getApplicationContext();
        weatherApplication = this;

        this.registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            }

            @Override
            public void onActivityStarted(Activity activity) {
                sActivity = activity;

            }

            @Override
            public void onActivityResumed(Activity activity) {

            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {

            }
        });
        //初始化网络框架
        NetworkApi.init(new NetworkRequiredInfo(this));
        //初始化数据库
        LitePal.initialize(this);
        /**
         * 设置隐私模式，默认false
         * 如果设置true,一定要保证在调用 SDKInitializer.initialize(this); 之前设置
         *
         * @param context 必须是Application Context
         * @param isEnable ture-同意隐私政策； false-不同意隐私政策；
         *
         */
        SDKInitializer.setAgreePrivacy(this,true);
        //在使用SDK各组件之前初始化context信息，传入ApplicationContext
        try {
            SDKInitializer.initialize(this);
        }catch (BaiduMapSDKException e){
            e.printStackTrace();
        }

        //自4.3.0起，百度地图SDK所有接口均支持百度坐标和国测局坐标，用此方法设置您使用的坐标类型.
        //包括BD09LL和GCJ02两种坐标，默认是BD09LL坐标。
        SDKInitializer.setCoordType(CoordType.BD09LL);
        //配置讯飞语音SDK
        SpeechUtility.createUtility(this, SpeechConstant.APPID +"=5af0a6fa");
    }
    public static ActivityManager getActivityManager() {
        return activityManager;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
    //staic 代码段可以防止内存泄露
    static {
        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator() {
            @NonNull
            @Override
            public RefreshHeader createRefreshHeader(@NonNull Context context, @NonNull RefreshLayout layout) {
                layout.setPrimaryColorsId(android.R.color.darker_gray,android.R.color.black);//全局设置
                return new ClassicsHeader(context);//.setTimeFormat(new DynamicTimeFormat("更新于 %s"));//指定为经典Header，默认是 贝塞尔雷达Header

            }
        });
        //设置全局的footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreator(new DefaultRefreshFooterCreator() {
            @NonNull
            @Override
            public RefreshFooter createRefreshFooter(@NonNull Context context, @NonNull RefreshLayout layout) {
                //指定为经典Footer,默认是BallPulseFooter
                return new ClassicsFooter(context).setDrawableArrowSize(20);
            }
        });
    }
}
