package com.cl.badweather.adapter;


import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cl.badweather.R;
import com.cl.mvplibrary.bean.ResidentCity;

import java.util.List;

/**
 * 主页面左右滑动切换常用城市列表适配器
 *
 * @author cl
 */
public class MainChangeCommonlyCityAdapter extends BaseQuickAdapter<ResidentCity, BaseViewHolder> {
    public MainChangeCommonlyCityAdapter(int layoutResId, @Nullable List<ResidentCity> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ResidentCity item) {
        helper.setText(R.id.tv_city, item.getLocation())
                .addOnClickListener(R.id.tv_city);

    }
}
