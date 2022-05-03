package com.cl.badweather.adapter;

import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.baidu.platform.comjni.map.searchengine.NASearchEngine;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cl.badweather.R;
import com.cl.badweather.bean.TodayDetailBean;

import java.util.List;

/**
 * 地图天气中 今日天气详情数据
 * @author: cl
 * @date: 2022/4/30
 */
public class TodayDetailAdapter extends BaseQuickAdapter<TodayDetailBean, BaseViewHolder> {
    public TodayDetailAdapter(int layoutResId, @Nullable List<TodayDetailBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, TodayDetailBean item) {
        ImageView imageView = helper.getView(R.id.iv_icon);
        imageView.setImageResource(item.getIcon()); //图标
        helper.setText(R.id.tv_value,item.getValue())//值
            .setText(R.id.tv_name,item.getName());//名称
    }
}
