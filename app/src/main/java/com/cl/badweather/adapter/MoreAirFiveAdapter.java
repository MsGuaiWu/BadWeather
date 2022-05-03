package com.cl.badweather.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cl.badweather.R;
import com.cl.badweather.bean.MoreAirFiveResponse;
import com.cl.badweather.utils.DateUtils;

import java.util.List;

/**
 * 5天气质量预报适配器
 * @author: cl
 * @date: 2022/4/24
 */
public class MoreAirFiveAdapter extends BaseQuickAdapter<MoreAirFiveResponse.DailyBean, BaseViewHolder> {
    public MoreAirFiveAdapter(int layoutResId, @Nullable List<MoreAirFiveResponse.DailyBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MoreAirFiveResponse.DailyBean item) {
        helper.setText(R.id.tv_date_info, DateUtils.Week(item.getFxDate()))//日期描述
                .setText(R.id.tv_date, DateUtils.dateSplit(item.getFxDate()))//日期
                .setText(R.id.tv_aqi,item.getAqi())//空气质量指数
                .setText(R.id.tv_category,item.getCategory())//空气质量描述
                .setText(R.id.tv_primary, item.getPrimary().equals("NA") ? "无污染" : item.getPrimary());//污染物
    }
}