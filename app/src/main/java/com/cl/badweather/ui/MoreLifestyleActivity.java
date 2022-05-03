package com.cl.badweather.ui;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cl.badweather.R;
import com.cl.badweather.adapter.MoreLifestyleAdapter;
import com.cl.badweather.bean.LifestyleResponse;
import com.cl.badweather.contract.MoreLifestyleContract;
import com.cl.badweather.utils.CodeToStringUtils;
import com.cl.badweather.utils.Constant;
import com.cl.badweather.utils.StatusBarUtil;
import com.cl.badweather.utils.ToastUtils;
import com.cl.mvplibrary.mvp.MvpActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.cl.mvplibrary.utils.RecyclerViewAnimation.runLayoutAnimation;

/**
 * 更多生活建议展示
 *
 * @author: cl
 * @date: 2022/4/24
 */
public class MoreLifestyleActivity extends MvpActivity<MoreLifestyleContract.MoreLifestylePresenter> implements MoreLifestyleContract.IMoreLifestyleView {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.rv)
    RecyclerView rv;

    @Override
    protected MoreLifestyleContract.MoreLifestylePresenter createPresent() {
        return new MoreLifestyleContract.MoreLifestylePresenter();
    }

    /**
     * 更多生活质量返回
     * @param response
     */
    @Override
    public void getMoreLifestyleResult(LifestyleResponse response) {
        dismissLoadingDialog();
        if (response.getCode().equals(Constant.SUCCESS_CODE)) {
            List<LifestyleResponse.DailyBean> data = response.getDaily();
            if (data != null && data.size() > 0) {
                MoreLifestyleAdapter adapter = new MoreLifestyleAdapter(R.layout.item_more_lifestyle_list, data);
                rv.setLayoutManager(new LinearLayoutManager(context));
                rv.setAdapter(adapter);
                runLayoutAnimation(rv);
            } else {
                ToastUtils.showShortToast(context, "生活质量数据为空");
            }
        } else {
            ToastUtils.showShortToast(context, CodeToStringUtils.WeatherCode(response.getCode()));
        }
    }

    /**
     * 其他 异常返回
     */
    @Override
    public void getDataFailed() {
        dismissLoadingDialog();
        ToastUtils.showShortToast(context,"更多天气数据获取异常");
    }

    @Override
    public void initDate(Bundle savedInstanceState) {
        StatusBarUtil.transparencyBar(context); //透明状态栏
        Back(toolbar);
        showLoadingDialog();
        tvTitle.setText(getIntent().getStringExtra("cityName"));
        mPresent.worldCity(getIntent().getStringExtra("locationId"));
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_more_lifestyle;
    }

}
