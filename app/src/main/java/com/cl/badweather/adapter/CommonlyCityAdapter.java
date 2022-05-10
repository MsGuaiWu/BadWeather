package com.cl.badweather.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cl.badweather.R;
import com.cl.mvplibrary.bean.ResidentCity;

import java.util.List;

/**
 * 常用城市列表适配器
 *
 * @author cl
 */
public class CommonlyCityAdapter extends BaseQuickAdapter<ResidentCity, BaseViewHolder> {
    public CommonlyCityAdapter(int layoutResId, @Nullable List<ResidentCity> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ResidentCity item) {
        helper.setText(R.id.tv_city_name, item.getLocation());
        //添加点击事件
        helper.addOnClickListener(R.id.tv_city_name)
                .addOnClickListener(R.id.btn_delete);
    }
}
