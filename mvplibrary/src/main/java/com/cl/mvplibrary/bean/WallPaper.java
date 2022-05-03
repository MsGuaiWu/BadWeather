package com.cl.mvplibrary.bean;

import org.litepal.crud.LitePalSupport;

/**
 * 壁纸表
 * @author: cl
 * @date: 2022/5/2
 */
public class WallPaper extends LitePalSupport {
    private String ImgUrl;
    public String getImgUrl() {
        return ImgUrl;
    }
    public void setImgUrl(String imgUrl){
        ImgUrl = imgUrl;
    }
}
