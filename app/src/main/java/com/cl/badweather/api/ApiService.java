package com.cl.badweather.api;

import com.cl.badweather.bean.AirNowResponse;
import com.cl.badweather.bean.BiYingImgResponse;
import com.cl.badweather.bean.DailyResponse;
import com.cl.badweather.bean.HourlyResponse;
import com.cl.badweather.bean.LifestyleResponse;
import com.cl.badweather.bean.NewSearchCityResponse;
import com.cl.badweather.bean.NowResponse;
import com.cl.badweather.bean.WallPaperResponse;

import io.reactivex.Observable;
import io.reactivex.Observer;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import static com.cl.badweather.utils.Constant.API_KEY;

/**
 * API服务接口
 * @author: cl
 * @date: 2022/3/17
 */
public interface ApiService {

    /**********       以下为 V7版本API使用     **************/
    /**
     * 搜索城市  V7版本  模糊搜索，国内范围 返回10条数据
     *
     * @param location 城市名
     * @param mode     exact 精准搜索  fuzzy 模糊搜索
     * @return NewSearchCityResponse 搜索城市数据返回
     */
    @GET("/v2/city/lookup?key=" + API_KEY + "&range=cn")
    Observable<NewSearchCityResponse> newSearchCity(@Query("location") String location,
                                                    @Query("mode") String mode);
    /**
     * 实况天气
     *
     * @param location 城市名
     * @return 返回实况天气数据 NowResponse
     */
    @GET("/v7/weather/now?key=" + API_KEY + "&gzip=n")
    Observable<NowResponse> nowWeather(@Query("location") String location);
    //Call<NowResponse> nowWeather(@Query("location") String location);

    /**
     * 天气预报  因为是开发者所以最多可以获得15天的数据，但是如果你是普通用户，那么最多只能获得三天的数据
     * 分为 3天、7天、10天、15天 四种情况，这是时候就需要动态的改变请求的url
     *
     * @param type     天数类型  传入3d / 7d / 10d / 15d  通过Path拼接到请求的url里面
     * @param location 城市id
     * @return 返回天气预报数据 DailyResponse
     */
    @GET("/v7/weather/{type}?key=" + API_KEY)
    Observable<DailyResponse> dailyWeather(@Path("type") String type, @Query("location") String location);
    //Call<DailyResponse> dailyWeather(@Path("type") String type, @Query("location") String location);

    /**
     * 生活指数
     *
     * @param type     可以控制定向获取那几项数据 全部数据 0, 运动指数	1 ，洗车指数	2 ，穿衣指数	3 ，
     *                 钓鱼指数	4 ，紫外线指数  5 ，旅游指数  6，花粉过敏指数	7，舒适度指数	8，
     *                 感冒指数	9 ，空气污染扩散条件指数	10 ，空调开启指数	 11 ，太阳镜指数	12 ，
     *                 化妆指数  13 ，晾晒指数  14 ，交通指数  15 ，防晒指数	16
     * @param location 城市id
     * @return LifestyleResponse 生活指数数据返回
     */
    @GET("/v7/indices/1d?key=" + API_KEY)
    Observable<LifestyleResponse> lifestyle(@Query("type") String type,
                                            @Query("location") String location);

    /**
     * 必应每日一图
     * @return BiYingImgResponse 必应壁纸返回
     */
    @GET("/HPImageArchive.aspx?format=js&idx=0&n=1")
    Observable<BiYingImgResponse> biying();

    /**
     * 逐小时预报（未来24小时）之前是三小时
     * @param location 城市名
     * @return 返回逐小时数据
     */
    @GET("/v7/weather/24h?key="+API_KEY)
    Observable<HourlyResponse> hourlyWeather(@Query("location") String location);
    /**
     * 当天空气质量
     *
     * @param location 城市id
     * @return 返回当天空气质量数据 MoreAirFiveResponse
     */
    @GET("/v7/air/now?key=" + API_KEY)
    Observable<AirNowResponse> airNowWeather(@Query("location") String location);

    /**
     * 生活指数
     * @param type 可以控制定向获取那几项数据 全部数据 0, 运动指数	1 ，洗车指数	2 ，穿衣指数	3 ，
     *      *             钓鱼指数	4 ，紫外线指数  5 ，旅游指数  6，花粉过敏指数	7，舒适度指数	8，
     *      *             感冒指数	9 ，空气污染扩散条件指数	10 ，空调开启指数	 11 ，太阳镜指数	12 ，
     *      *             化妆指数  13 ，晾晒指数  14 ，交通指数  15 ，防晒指数	16
     * @param location 城市名
     * @return 返回当前生活指数数据
     */
    @GET("/v7/indices/1d?key=3086e91d66c04ce588a7f538f917c7f4")
    Call<LifestyleResponse> Lifestyle(@Query("type") String type,@Query("location") String location);
    /**
     * 手机壁纸API
     *
     * @return WallPaperResponse 网络壁纸数据返回
     */
    @GET("/v1/vertical/vertical?limit=30&skip=180&adult=false&first=0&order=hot")
    Observable<WallPaperResponse> getWallPaper();
    //Call<WallPaperResponse> getWallPaper();
}
