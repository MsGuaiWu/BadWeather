package com.cl.mvplibrary.base;

import android.os.Bundle;

/**
 * Ui回调接口
 * @author: cl
 * @date: 2022/3/9
 */
public interface UiCallBack {
    //初始化savedInstanceState
    void initBeforeView(Bundle savedInstanceState);

    //初始化
    void initDate(Bundle savedInstanceState);
    //布局
    int getLayoutId();
}
