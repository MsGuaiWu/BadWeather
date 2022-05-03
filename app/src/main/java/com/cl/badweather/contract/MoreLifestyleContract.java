package com.cl.badweather.contract;

import android.annotation.SuppressLint;

import com.cl.badweather.api.ApiService;
import com.cl.badweather.bean.LifestyleResponse;
import com.cl.mvplibrary.base.BasePresenter;
import com.cl.mvplibrary.base.BaseView;
import com.cl.mvplibrary.net.NetworkApi;
import com.cl.mvplibrary.net.observer.BaseObserver;

/**
 * 更多生活指数订阅器
 */
public class MoreLifestyleContract {

    public static class MoreLifestylePresenter extends BasePresenter<IMoreLifestyleView> {

        /**
         * 更多生活指数  V7
         * @param location  城市id
         */
        @SuppressLint("CheckResult")
        public void worldCity(String location) {
            ApiService service = NetworkApi.createService(ApiService.class,3);
            service.lifestyle("0",location).compose(NetworkApi.applySchedulers(new BaseObserver<LifestyleResponse>() {
                @Override
                public void onSuccess(LifestyleResponse lifestyleResponse) {
                    if(getView() != null){
                        getView().getMoreLifestyleResult(lifestyleResponse);
                    }
                }

                @Override
                public void onFailure(Throwable e) {
                    if(getView() != null){
                        getView().getDataFailed();
                    }
                }
            }));
        }

    }

    public interface IMoreLifestyleView extends BaseView {

        //更多生活指数返回数据 V7
        void getMoreLifestyleResult(LifestyleResponse response);

        //错误返回
        void getDataFailed();
    }
}