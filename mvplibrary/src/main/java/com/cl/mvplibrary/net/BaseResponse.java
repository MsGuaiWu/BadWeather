package com.cl.mvplibrary.net;

import android.content.Intent;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author: cl
 * @date: 2022/3/15
 */
public class BaseResponse {
    //返回码
    @SerializedName("res_code")
    @Expose
    public Integer responseCode;
    //返回的错误信息
    @SerializedName("res_error")
    @Expose
    public String responseError;
}
