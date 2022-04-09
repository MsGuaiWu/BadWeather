package com.cl.badweather.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cl.badweather.R;
import com.cl.badweather.bean.CityResponse;

import java.util.List;

import javax.crypto.BadPaddingException;

/**
 * 省列表适配器
 * @author: cl
 * @date: 2022/3/23
 */
public class ProvinceAdapter extends BaseQuickAdapter<CityResponse, BaseViewHolder> {
    public ProvinceAdapter(int layoutResId, @Nullable List<CityResponse> data) {
        super(layoutResId, data);
    }
    @Override
    protected void convert(BaseViewHolder helper, CityResponse item) {
        //省名称
        helper.setText(R.id.tv_city,item.getName());
        helper.addOnClickListener(R.id.item_city);
    }
}
