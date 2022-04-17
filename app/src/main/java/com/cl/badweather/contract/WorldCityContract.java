package com.cl.badweather.contract;

import com.cl.badweather.api.ApiService;
import com.cl.badweather.bean.WorldCityResponse;
import com.cl.badweather.ui.WorldCityActivity;
import com.cl.mvplibrary.base.BasePresenter;
import com.cl.mvplibrary.base.BaseView;
import com.cl.mvplibrary.net.NetworkApi;
import com.cl.mvplibrary.net.observer.BaseObserver;

/**
 * 世界城市订阅器
 * @author: cl
 * @date: 2022/4/10
 */
public class WorldCityContract {
    public static class WorldCityPresenter extends BasePresenter<IWorldCityView>{
        /**
         * 世界城市 V7
         * @param range 类型
         */
        public void worldCity(String range){
            ApiService service = NetworkApi.createService(ApiService.class,4);
            service.
        }
    }
    public interface IWorldCityView extends BaseView {
        //热门城市返回数据 v7
        void getWorldCityResult(WorldCityResponse response);
        //错误信息返回
        void getDataFailed();
    }
}
