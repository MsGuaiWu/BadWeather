package com.cl.badweather.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cl.badweather.R;
import com.cl.badweather.bean.CityResponse;

import java.util.List;

/**
 * 市列表适配器
 *
 * @author cl
 */
public class CityAdapter extends BaseQuickAdapter<CityResponse.CityBean, BaseViewHolder> {
    public CityAdapter(int layoutResId, @Nullable List<CityResponse.CityBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CityResponse.CityBean item) {
        //市名称
        helper.setText(R.id.tv_city, item.getName());
        //点击事件  点击进入区/县列表
        helper.addOnClickListener(R.id.item_city);
    }
}
