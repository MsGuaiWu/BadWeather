package com.cl.badweather.utils;

import retrofit2.http.PUT;

/**
 * 统一管理缓存中对应的KEY
 * @author: cl
 * @date: 2022/3/17
 */
public class Constant {
    /**
     * 和风天气KEY
     */
    public static final String API_KEY = "a2e9c15bf0244959b7972921fc1356c8";
    /**
     * 更新APP的用户id
     */
    public static final String UPDATE_USER_ID = "626d0bf4f945484e5998ad9d";
    /**
     * 更新APP的用户Token
     */
    public static final String UPDATE_API_TOKEN = "8a933c76074583d1b14e9d2c3ac83008";
    /**
     * 返回成功码
     */
    public static final String SUCCESS_CODE = "200";
    /**
     * 市
     */
    public static final String CITY = "city";
    /**
     * 区/县
     */
    public static final String DISTRICT = "district";
    /**
     * 通过搜索接口得到的城市id,在V7中所有数据通过id来查询
     */
    public static final String LOCATION_ID = "locationId";
    /**
     * 每日图片开关
     */
    public static final String EVERYDAY_IMG = "everyday_img";
    /**
     * 图片列表开关
     */
    public static final String IMG_LIST = "img_list";
    /**
     * 手动定义开关
     */
    public static final String CUSTOM_IMG = "custom_img";
    /**
     * 选中的本地背景图片
     */
    public static final String IMG_POSITION = "img_position";
    /**
     * 启动相册标识
     */
    public final static int SELECT_PHOTO = 2;
    /**
     * 手动上传图片地址
     */
    public static final String CUSTOM_IMG_PATH = "custom_img_path";
    /**
     * 跳转页面的标识
     */
    public static final String FLAG_OTHER_RETURN = "flag_other_return";
    public static final String LOCATION = "location";
    /**
     * App首次启动
     */
    public static final String APP_FIRST_START = "appFirstStart";
    /**
     * 今日启动APP的时间
     */
    public static final String START_UP_APP_TIME = "startAppTime";
    /**
     * 成功
     */
    public static final String SUCCESS = "success";

    /**
     * 壁纸地址
     */
    public static final String WALLPAPER_URL = "wallpaperUrl";
    /**
     * 壁纸类型  1  壁纸列表  2  每日一图  3  手动上传  4  默认壁纸
     */
    public static final String WALLPAPER_TYPE = "wallpaperType";

    /**
     * 每日提示弹窗的背景图
     */
    public static final String EVERYDAY_TIP_IMG = "everydayTipImg";

    /**
     * 每日提示弹窗是否弹出
     */
    public static final String EVERYDAY_POP_BOOLEAN = "everydayPopBoolean";
    /**
     * 语音搜索是否关闭
     */
    public static final String VOICE_SEARCH_BOOLEAN = "voiceSearchBoolean";

    /**
     * 播报人
     */
    public static final String VOICE_NAME = "voiceName";

    /**
     * 语速
     */
    public static final String SPEED = "speed";

    /**
     * 音调
     */
    public static final String PITCH = "pitch";

    /**
     * 音量
     */
    public static final String VOLUME = "volume";
}
