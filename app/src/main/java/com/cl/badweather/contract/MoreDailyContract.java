package com.cl.badweather.contract;

import android.annotation.SuppressLint;

import com.cl.badweather.api.ApiService;
import com.cl.badweather.bean.DailyResponse;
import com.cl.mvplibrary.base.BasePresenter;
import com.cl.mvplibrary.base.BaseView;
import com.cl.mvplibrary.net.NetworkApi;
import com.cl.mvplibrary.net.observer.BaseObserver;

/**
 * 更多天气预报订阅器
 * @author: cl
 * @date: 2022/4/23
 */
public class MoreDailyContract {
    public  static class MoreDailyPresenter extends BasePresenter<IMoreDailyView>{
        /**
         * 更多天气预报 V7
         * @param location
         */
        @SuppressLint("CheckResult")
        public void dailyWeather(String location) {
            ApiService service = NetworkApi.createService(ApiService.class,3);
            service.dailyWeather("15d",location).compose(NetworkApi.applySchedulers(new BaseObserver<DailyResponse>() {
                @Override
                public void onSuccess(DailyResponse dailyResponse) {
                    if (getView() != null){
                        getView().getMoreDailyResult(dailyResponse);
                    }
                }

                @Override
                public void onFailure(Throwable e) {
                    if (getView() != null){
                        getView().getDataFailed();
                    }
                }
            }));
        }
    }

    public interface IMoreDailyView extends BaseView {
        //更多天气预报返回数据 v7
        void getMoreDailyResult(DailyResponse response);
        //错误返回
        void getDataFailed();
    }
}
