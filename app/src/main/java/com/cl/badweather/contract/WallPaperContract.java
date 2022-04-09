package com.cl.badweather.contract;

import android.annotation.SuppressLint;

import androidx.annotation.CheckResult;

import com.cl.badweather.api.ApiService;
import com.cl.badweather.bean.BiYingImgResponse;
import com.cl.badweather.bean.WallPaperResponse;
import com.cl.mvplibrary.base.BasePresenter;
import com.cl.mvplibrary.base.BaseView;
import com.cl.mvplibrary.net.NetworkApi;
import com.cl.mvplibrary.net.observer.BaseObserver;

/**
 * @author: cl
 * @date: 2022/3/31
 */
public class WallPaperContract {
    public static class WallPaperPresenter extends BasePresenter<IWallPaperView> {

        /**
         * 获取必应 每日一图
         */
        @SuppressLint("CheckResult")
        public void biying() {
            ApiService service = NetworkApi.createService(ApiService.class,1);
            service.biying().compose(NetworkApi.applySchedulers(new BaseObserver<BiYingImgResponse>() {
                @Override
                public void onSuccess(BiYingImgResponse biYingImgResponse) {
                    if (getView() != null) {
                        getView().getBiYingResult(biYingImgResponse);
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
        /*
            获取壁纸数据
         */
        public void getWallPaper() {
            //6 表示访问网络壁纸接口
            ApiService service = NetworkApi.createService(ApiService.class,6);
            service.getWallPaper().compose(NetworkApi.applySchedulers(new BaseObserver<WallPaperResponse>() {
                @Override
                public void onSuccess(WallPaperResponse wallPaperResponse) {
                    if (getView() != null) {
                        getView().getWallPaperResult(wallPaperResponse);
                    }
                }

                @Override
                public void onFailure(Throwable e) {

                }
            }));
        }
    }

    public interface IWallPaperView extends BaseView {
        /**
         * 获取必应每日一图返回
         * @param response BiYingImgResponse
         */
        void getBiYingResult(BiYingImgResponse response);

        /**
         * 壁纸数据返回
         * @param response WallPaperResponse
         */
        void getWallPaperResult(WallPaperResponse response);

        /**
         * 错误返回
         */
        void getDataFailed();
    }
}
