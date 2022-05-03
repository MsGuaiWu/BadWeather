package com.cl.badweather.adapter;

import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cl.badweather.R;
import com.cl.badweather.bean.DailyResponse;
import com.cl.badweather.utils.DateUtils;
import com.cl.badweather.utils.WeatherUtil;

import java.util.List;

/**
 * 地图天气中 未来天气的天气列表适配器
 * @author: cl
 * @date: 2022/4/30
 */
public class SevenDailyAdapter extends BaseQuickAdapter<DailyResponse.DailyBean, BaseViewHolder> {
    public SevenDailyAdapter(int layoutResId, @Nullable List<DailyResponse.DailyBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DailyResponse.DailyBean item) {
        helper.setText(R.id.tv_date, DateUtils.dateSplitPlus(item.getFxDate()) +
                DateUtils.Week(item.getFxDate()))//日期
                .setText(R.id.tv_temp_height, item.getTempMax() + "℃")//最高温
                .setText(R.id.tv_temp_low, " / " + item.getTempMin() + "℃");//最低温

        //天气状态图片
        ImageView weatherStateIcon = helper.getView(R.id.iv_weather_state);
        int code = Integer.parseInt(item.getIconDay());//获取天气状态码，根据状态码来显示图标
        WeatherUtil.changeIcon(weatherStateIcon, code);//调用工具类中写好的方法
    }
}
