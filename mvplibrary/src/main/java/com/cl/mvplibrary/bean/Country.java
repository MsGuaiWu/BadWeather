package com.cl.mvplibrary.bean;

import org.litepal.crud.LitePalSupport;

/**
 * 世界城市
 * @author: cl
 * @date: 2022/4/9
 */
public class Country extends LitePalSupport {
    private String name;//名称
    private  String code; //代码

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
