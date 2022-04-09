package com.cl.mvplibrary.net;

import android.app.Application;

/**
 * App运行信息接口
 * @author: cl
 * @date: 2022/3/9
 */
public interface INetworkRequiredInfo {
    /*
    * 获取APP版本名
    * */
    String getAppVersionName();

    /**
     * 获取App版本号
     * @return
     */
    String getAppVersionCode();

    /**
     * 判断是否为Debug模式
     * @return
     */
    boolean isDebug();

    /**
     * 获取全局上下文参数
     * @return
     */
    Application getApplicationContext();
}
