package com.cl.badweather.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.cl.badweather.R;
import com.cl.badweather.adapter.WallPaperAdapter;
import com.cl.badweather.bean.BiYingImgResponse;
import com.cl.badweather.bean.WallPaperResponse;
import com.cl.badweather.contract.WallPaperContract;
import com.cl.badweather.utils.ToastUtils;
import com.cl.mvplibrary.mvp.MvpActivity;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WallPaperActivity extends MvpActivity<WallPaperContract.WallPaperPresenter> implements WallPaperContract.IWallPaperView {
    /**
     * 标题
     */
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    /**
     * AppBarLayout布局
     */
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    /**
     * 数据列表
     */
    @BindView(R.id.rv)
    RecyclerView rv;
    /**
     * 底部浮动按钮
     */
    @BindView(R.id.fab_setting)
    FloatingActionButton fabSetting;
    /**
     * 壁纸数据列表
     */
    private List<WallPaperResponse.ResBean.VerticalBean> mList = new ArrayList<>();
    /**
     * 壁纸数据适配器
     */
    private WallPaperAdapter mAdapter;
    /**
     * item高度列表
     */
    private List<Integer> heightList = new ArrayList<>();
    /**
     * 壁纸数量
     */
    private static final int WALLPAPER_NUM = 30;
    /**
     * 头部和底部的item数据
     */
    private WallPaperResponse.ResBean.VerticalBean topBean, bottomBean;

    /**
     * 必应的每日壁纸
     */
    private String biyingUrl = null;
    /**
     * 底部弹窗
     */
    AlertDialog bottomSettingDialog = null;

    @Override
    public void initDate(Bundle savedInstanceState) {
        //加载弹窗
        showLoadingDialog();
        //高亮状态栏
        //左上角的返回
        initWallPaperList();
    }

    private void initWallPaperList() {
        heightList.add(100);
        for (int i = 0; i < WALLPAPER_NUM; i++) {
            heightList.add(300);
        }
        heightList.add(100);

        mAdapter = new WallPaperAdapter(R.layout.item_wallpaper_list, mList, heightList);
        //瀑布流
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        //设置布局管理
        rv.setLayoutManager(manager);
        //设置数据适配器
        rv.setAdapter(mAdapter);
        //请求数据
        mPresent.getWallPaper();
        //获取必应壁纸
        mPresent.biying();
        mAdapter.setOnItemChildClickListener((adapter,view,position) -> {
            //这里的列表数据实际上有32条，有两条假数据，就是首尾这两条，所以点击的时候要做判断处理
            if (position == 0 || position == mList.size() - 1) {//是否为第一条或者最后一条
                startActivity(new Intent(context,AboutUsActivity.class));
            } else {
                Intent intent = new Intent(context, ImageActivity.class);
                intent.putExtra("position", position - 1);
                startActivity(intent);
            }
        });
        //滑动监听
        rv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy <= 0) {
                    fabSetting.show();
                } else {//上滑
                    fabSetting.hide();
                }
            }
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_wall_paper;
    }

    @Override
    protected WallPaperContract.WallPaperPresenter createPresent() {
        return new WallPaperContract.WallPaperPresenter();
    }

    @Override
    public void getBiYingResult(BiYingImgResponse response) {
        if (response.getImages() != null){
            //得到的图片地址是没有前缀的，所以加上前缀否则显示不出来
            biyingUrl = "http://cn.bing.com" + response.getImages().get(0).getUrl();
            Log.d("type-->", biyingUrl);
        }else {
            ToastUtils.showShortToast(context,"未获取到必应的图片");
        }
    }

    @Override
    public void getWallPaperResult(WallPaperResponse response) {
        if (response.getMsg())
    }

    @OnClick(R.id.fab_setting)
    public void onViewClicked() {
    }
}
