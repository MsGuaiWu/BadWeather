package com.cl.badweather;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.cl.badweather.adapter.AreaAdapter;
import com.cl.badweather.adapter.CityAdapter;
import com.cl.badweather.adapter.DailyAdapter;
import com.cl.badweather.adapter.HourlyAdapter;
import com.cl.badweather.adapter.MainChangeCommonlyCityAdapter;
import com.cl.badweather.adapter.MinutePrecAdapter;
import com.cl.badweather.adapter.ProvinceAdapter;
import com.cl.badweather.bean.AirNowResponse;
import com.cl.badweather.bean.CityResponse;
import com.cl.badweather.bean.DailyResponse;
import com.cl.badweather.bean.HourlyResponse;
import com.cl.badweather.bean.LifestyleResponse;
import com.cl.badweather.bean.NewSearchCityResponse;
import com.cl.badweather.bean.NowResponse;
import com.cl.badweather.contract.WeatherContract;
import com.cl.badweather.eventbus.SearchCityEvent;
import com.cl.badweather.ui.CommonlyUsedCityActivity;
import com.cl.badweather.ui.SearchCityActivity;
import com.cl.badweather.ui.WallPaperActivity;
import com.cl.badweather.ui.WorldCityActivity;
import com.cl.badweather.utils.CodeToStringUtils;
import com.cl.badweather.utils.Constant;
import com.cl.badweather.utils.DateUtils;
import com.cl.badweather.utils.SPUtils;
import com.cl.badweather.utils.StatusBarUtil;
import com.cl.badweather.utils.ToastUtils;
import com.cl.badweather.utils.WeatherUtil;
import com.cl.mvplibrary.bean.ResidentCity;
import com.cl.mvplibrary.mvp.MvpActivity;
import com.cl.mvplibrary.utils.AnimationUtil;
import com.cl.mvplibrary.utils.LiWindow;
import com.cl.mvplibrary.utils.SizeUtils;
import com.cl.mvplibrary.view.MarqueeTextView;
import com.cl.mvplibrary.view.RoundProgressBar;
import com.cl.mvplibrary.view.WhiteWindmills;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.litepal.LitePal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.cl.mvplibrary.utils.RecyclerViewAnimation.runLayoutAnimation;
import static com.cl.mvplibrary.utils.RecyclerViewAnimation.runLayoutAnimationRight;

@RequiresApi(api = Build.VERSION_CODES.M)
public class MainActivity extends MvpActivity<WeatherContract.WeatherPresenter> implements WeatherContract.IWeatherView, View.OnScrollChangeListener {

    @BindView(R.id.tv_info)
    TextView tvInfo;//天气状况
    @BindView(R.id.tv_temperature)
    TextView tvTemperature;//温度
    @BindView(R.id.tv_temp_height)
    TextView tvTempHeight;  //最高温
    @BindView(R.id.tv_temp_low)
    TextView tvTempLow;//最低温
    @BindView(R.id.tv_city)
    TextView tvCity;//城市
    @BindView(R.id.tv_old_time)
    TextView tvOldTime;//最近更新时间
    @BindView(R.id.iv_location)
    ImageView ivLocation;  //定位图标
    @BindView(R.id.bg)
    ImageView bg;  //背景图
    @BindView(R.id.iv_map)
    ImageView ivMap;  //地图天气
    @BindView(R.id.tv_title)
    TextView tvTitle;  //标题
    @BindView(R.id.iv_add)
    ImageView ivAdd; //
    @BindView(R.id.tv_warn)
    MarqueeTextView tvWarn;
    @BindView(R.id.tv_week)
    TextView tvWeek;
    @BindView(R.id.tv_broadcast_state)
    TextView tvBroadcastState;
    @BindView(R.id.tv_air_info)
    TextView tvAirInfo;
    @BindView(R.id.rv_change_city)
    RecyclerView rvChangeCity;
    @BindView(R.id.lay_slide_area)
    LinearLayout laySlideArea;
    @BindView(R.id.tv_precipitation)
    TextView tvPrecipitation;
    @BindView(R.id.tv_prec_more)
    TextView tvPrecMore;
    @BindView(R.id.rv_prec_detail)
    RecyclerView rvPrecDetail;
    @BindView(R.id.rv_hourly)
    RecyclerView rvHourly;
    @BindView(R.id.rv)
    RecyclerView rv;
    @BindView(R.id.tv_more_daily)
    TextView tvMoreDaily;
    @BindView(R.id.tv_more_air)
    TextView tvMoreAir;
    /*空气质量*/
    @BindView(R.id.rpb_aqi)
    RoundProgressBar rpbAqi;
    @BindView(R.id.tv_pm10)
    TextView tvPm10;
    @BindView(R.id.tv_pm25)
    TextView tvPm25;
    @BindView(R.id.tv_no2)
    TextView tvNo2;
    @BindView(R.id.tv_o3)
    TextView tvO3;
    @BindView(R.id.tv_co)
    TextView tvCo;
    @BindView(R.id.tv_so2)
    TextView tvSo2;
    @BindView(R.id.ww_big) //大风车
            WhiteWindmills wwBig;
    @BindView(R.id.ww_small)  //小风车
            WhiteWindmills wwSmall;
    @BindView(R.id.r1_wind)
    RelativeLayout r1Wind;
    @BindView(R.id.tv_wind_direction)//风向
            TextView tvWindDirection;
    @BindView(R.id.tv_wind_power)// 风力
            TextView tvWindPower;
    @BindView(R.id.tv_more_lifestyle) //更多生活建议
            TextView tvMoreLifestyle;
    @BindView(R.id.tv_uv)
    TextView tvUv; //紫外线
    @BindView(R.id.tv_comf)
    TextView tvComf; //舒适度
    @BindView(R.id.tv_trav)
    TextView tvTrav; //旅游指数
    @BindView(R.id.tv_sport)
    TextView tvSport; //运动指数
    @BindView(R.id.tv_cw)
    TextView tvCw;  //洗车指数
    @BindView(R.id.tv_air)
    TextView tvAir;  //空气指数
    @BindView(R.id.tv_drsg)
    TextView tvDrsg;  //穿衣指数
    @BindView(R.id.tv_flu)
    TextView tvFlu;  //感冒指数
    @BindView(R.id.scroll_view)
    NestedScrollView scrollView;  //滑动view
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh; //刷新布局

    //private RxPermissions rxPermissions; /*权限请求框架*/ 放到欢迎页里面

    private List<String> list;//字符串列表
    private List<CityResponse> provinceList;//省列表数据
    private List<CityResponse.CityBean> citylist;//市列表数据
    private List<CityResponse.CityBean.AreaBean> arealist;//区/县列表数据
    private ProvinceAdapter provinceAdapter;//省数据适配器
    private CityAdapter cityAdapter;//市数据适配器
    private AreaAdapter areaAdapter;//县/区数据适配器
    private String provinceTitle;//标题
    private LiWindow liWindow;//自定义弹窗

    private String district = null;//区/县 改为全局的静态变量，方便更换城市之后也能进行下拉刷新
    private String city; //市 国控站点数据  用于请求空气质量
    private boolean flag = true; //图标显示标识,true显示，false不显示,只有定位的时候才为true,切换城市和常用城市都为false
    //百度定位器
    public LocationClient mLocationClient = null;
    private MyLocationListener myListener = new MyLocationListener();

    private String lon = null; // j经度
    private String lat = null; // 纬度

    //右上角的弹窗
    private PopupWindow mPopupWindow;
    private AnimationUtil animUtil;
    private float bgAlpha = 1f;
    private boolean bright = false;
    private static final long DURATION = 500;//0.5s
    private static final float START_ALPHA = 0.7f;//开始透明度
    private static final float END_ALPHA = 1f;//结束透明度
    private String locationId = null; //城市id,用于查询城市数据  v7版本中 才有
    //v7版本
    private List<DailyResponse.DailyBean> dailyListV7 = new ArrayList<>(); //天气预报数据列表
    private DailyAdapter mAdapterDailyV7; //天气预报适配器
    private List<HourlyResponse.HourlyBean> hourlyListV7 = new ArrayList<>(); //逐小时天气预报数据列表
    private HourlyAdapter mAdapterHourlyV7; //逐小时天气预报适配器

    //主页面切换城市列表适配器
    private MainChangeCommonlyCityAdapter changeCityAdapter;
    //常用城市切换列表
    private List<ResidentCity> residentCityList = new ArrayList<>();
    private boolean isChangeCity = false; //是否可以展开，如果没有添加常用城市，自然不能展开
    private boolean changeCityState;  // 常用城市列表 收缩状态 false 收缩 true 展开
    private String stationName;


    /**
     * 初始化天气预报 和逐小时 数据列表
     */
    private void initList() {
        /*      V7版本    */
        mAdapterDailyV7 = new DailyAdapter(R.layout.item_weather_forecast_list, dailyListV7);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(mAdapterDailyV7);
        mAdapterDailyV7.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                DailyResponse.DailyBean data = dailyListV7.get(position);
                showForecastWindow(data);
            }
        });

        //逐小时天气预报 24小时
        mAdapterHourlyV7 = new HourlyAdapter(R.layout.item_weather_hourly_list, hourlyListV7);
        LinearLayoutManager managerHourly = new LinearLayoutManager(context);
        managerHourly.setOrientation(RecyclerView.HORIZONTAL); //设置列表为横向
        rvHourly.setLayoutManager(managerHourly);
        rvHourly.setAdapter(mAdapterDailyV7);
        //逐小时天气预报列表item点击事件
        mAdapterDailyV7.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                //赋值
                HourlyResponse.HourlyBean data = hourlyListV7.get(position);
                //小时天气详情弹窗
                showHourlyWindow(data);
            }
        });
        //分钟级降水
        mAdapterMinutePrec = new MinutePrecAdapter(R.layout.item_prec_detail_list, minutelyList);
        GridLayoutManager managerMinutePrec = new GridLayoutManager(context, 2);
        managerMinutePrec.setOrientation(RecyclerView.HORIZONTAL);
        rvPrecDetail.setLayoutManager(managerMinutePrec);
        rvPrecDetail.setAdapter(mAdapterMinutePrec);
    }

    /**
     * 显示小时详情天气信息弹窗
     *
     * @param data
     */
    private void showHourlyWindow(HourlyResponse.HourlyBean data) {
        liWindow = new LiWindow(context);
        final View view = LayoutInflater.from(context).inflate(R.layout.window_hourly_detail, null);
        TextView tv_time = view.findViewById(R.id.tv_time);//时间
        TextView tv_tem = view.findViewById(R.id.tv_tem);//温度
        TextView tv_cond_txt = view.findViewById(R.id.tv_cond_txt);//天气状态描述
        TextView tv_wind_deg = view.findViewById(R.id.tv_wind_deg);//风向360角度
        TextView tv_wind_dir = view.findViewById(R.id.tv_wind_dir);//风向
        TextView tv_wind_sc = view.findViewById(R.id.tv_wind_sc);//风力
        TextView tv_wind_spd = view.findViewById(R.id.tv_wind_spd);//风速
        TextView tv_hum = view.findViewById(R.id.tv_hum);//相对湿度
        TextView tv_pres = view.findViewById(R.id.tv_pres);//大气压强
        TextView tv_pop = view.findViewById(R.id.tv_pop);//降水概率
        TextView tv_dew = view.findViewById(R.id.tv_dew);//露点温度
        TextView tv_cloud = view.findViewById(R.id.tv_cloud);//云量

        String time = DateUtils.updateTime(data.getFxTime());

        tv_time.setText(WeatherUtil.showTimeInfo(time) + time);
        tv_tem.setText(data.getTemp() + "℃");
        tv_cond_txt.setText(data.getText());
        tv_wind_deg.setText(data.getWind360() + "°");
        tv_wind_dir.setText(data.getWindDir());
        tv_wind_sc.setText(data.getWindScale() + "级");
        tv_wind_spd.setText(data.getWindSpeed() + "公里/小时");
        tv_hum.setText(data.getHumidity() + "%");
        tv_pres.setText(data.getPressure() + "hPa");
        tv_pop.setText(data.getPop() + "%");
        tv_dew.setText(data.getDew() + "℃");
        tv_cloud.setText(data.getCloud() + "%");
        liWindow.showCenterPopupWindow(view, SizeUtils.dp2px(context, 300), SizeUtils.dp2px(context, 400), true);
    }

    private void showForecastWindow(DailyResponse.DailyBean data) {
        liWindow = new LiWindow(context);
    }

    //数据初始化 主线程，onCreate方法可以删除了，把里面的代码移动到这个initDate下面
    @Override
    public void initDate(Bundle savedInstanceState) {
        //因为这个框架里面已经放入了绑定，所以这行代码可以注释掉了。
        //ButterKnife.bind(this);
        //setAgreePrivacy接口需要在LocationClient实例化之前调用
        //如果setAgreePrivacy接口参数设置为了false，则定位功能不会实现
        //true，表示用户同意隐私合规政策
        LocationClient.setAgreePrivacy(true);
        StatusBarUtil.transparencyBar(context); //透明状态栏
        initList();//天气预报列表初始化
        //permissionVersion();//权限判断 放到欢迎页
        if (isOpenLocationServiceEnable()) {
            startLocation();
        } else {
            ToastUtils.showShortToast(context, "(((φ(◎ロ◎;)φ))),你好像忘记打开定位功能了");
            tvCity.setText("打开定位");
        }
        //由于这个刷新框架默认是有下拉和上拉，但是上拉没有用到，为了不造成误会，我这里禁用上拉
        refresh.setEnableLoadMore(false);
        //初始化弹窗
        mPopupWindow = new PopupWindow(this);
        animUtil = new AnimationUtil();
        EventBus.getDefault().register(this); //注册消息广播
        scrollView.setOnScrollChangeListener(this);//指定当前页面，不写则滑动监听无效
    }

    /**
     * 手机是否开启位置服务，如果没有开启那么APP将不能使用定位功能
     *
     * @return
     */
    private boolean isOpenLocationServiceEnable() {
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        boolean gps = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        boolean network = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        if (gps || network) {
            return true;
        }
        return false;
    }


    //百度定位新版
    private void startLocation() {
        //声明LocationCLient类
        //实例化LocationClient时，需要捕获异常信息，
        try {
            mLocationClient = new LocationClient(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //在使用mLocationClient时，请注意需要加判空处理
        if (mLocationClient != null) {
            //注册监听函数
            mLocationClient.registerLocationListener(myListener);
            LocationClientOption option = new LocationClientOption();
            //如果开发者需要获得当前点的地址信息，此处必须为true
            option.setIsNeedAddress(true);
            //可选，设置是否需要最新版本的地址信息。默认不需要，即参数为false
            option.setNeedNewVersionRgc(true);
            //mLocationClient为第二步初始化过的LocationClient对象
            //徐将配置好的LocationClientOption对象，通过setLocation方法传递给LacationClient对象使用
            mLocationClient.setLocOption(option);
            //启动定位
            mLocationClient.start();
        } else {
            ToastUtils.showShortToast(this, "获取定位失败");
        }

    }

    /**
     *接收搜索城市事件
     * @param event
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(SearchCityEvent event) { //接收
        //重新加载数据
        loadingCommonlyUsedCity();

        flag = false;//切换城市得到的城市不属于定位，因此这里隐藏定位图标
        //V7版本中需要先获取到城市ID ,在结果返回值中再进行下一步的数据查询
        mPresent.newSearchCity(event.mLocation);//相应事件时
    }
    /**
     * 城市弹窗
     */
    private void showCityWindow() {
        provinceList = new ArrayList<>();
        citylist = new ArrayList<>();
        arealist = new ArrayList<>();
        list = new ArrayList<>();
        liWindow = new LiWindow(context);
        final View view = LayoutInflater.from(context).inflate(R.layout.window_city_list, null);
        ImageView areaBack = (ImageView) view.findViewById(R.id.iv_back_area);
        ImageView cityBack = (ImageView) view.findViewById(R.id.iv_back_city);
        TextView windowTitle = (TextView) view.findViewById(R.id.tv_title);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv);
        liWindow.showRightPopupWindow(view);//显示弹窗
        initCityData(recyclerView, areaBack, cityBack, windowTitle);//加载城市列表数据
    }

    //绑定Presenter,这里不绑定会报错
    @Override
    protected WeatherContract.WeatherPresenter createPresent() {
        return new WeatherContract.WeatherPresenter();
    }

    @Override
    public void getWeatherDataFailed() {

        dismissLoadingDialog(); //关闭弹窗
        ToastUtils.showShortToast(context, "天气数据获取异常");
    }

    /**
     * 数据请求失败返回
     */
    @Override
    public void getDataFailed() {
        refresh.finishRefresh();//关闭刷新
        dismissLoadingDialog();//关闭弹窗
    }

    //绑定布局文件
    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    /**
     * 添加点击事件
     *
     * @param view 控件
     */
    @OnClick(R.id.iv_add)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_add:  //更多功能弹窗
                showAddWindow();
                toggleBright();//计算动画时间
        }
    }

    /**
     * 空气质量返回  V7
     *
     * @param response
     */
    @Override
    public void getAirNowResult(AirNowResponse response) {
        if (response.getCode().equals(Constant.SUCCESS_CODE)) {
            AirNowResponse.NowBean data = response.getNow();
            if (response.getNow() != null) {
                rpbAqi.setMaxProgress(300);//最大进度，用于计算
                rpbAqi.setMinText("0");//设置显示最小值
                rpbAqi.setMinTextSize(32f);
                rpbAqi.setMaxText("300");//设置显示最大值
                rpbAqi.setMaxTextSize(32f);
                rpbAqi.setProgress(Float.valueOf(data.getAqi()));//当前进度
                rpbAqi.setArcBgColor(getColor(R.color.arc_bg_color));//圆弧的颜色
                rpbAqi.setProgressColor(getColor(R.color.arc_progress_color));//进度圆弧的颜色
                rpbAqi.setFirstText(data.getCategory());//空气质量描述 取值范围：优，良，轻度污染，中度污染，重度污染，严重污染
                rpbAqi.setFirstTextSize(44f);//第一行文本的字体大小
                rpbAqi.setSecondText(data.getAqi());//空气质量值
                rpbAqi.setSecondTextSize(64f);//第二行文本的字体大小
                rpbAqi.setMinText("0");
                rpbAqi.setMinTextColor(getColor(R.color.arc_progress_color));

                tvAirInfo.setText("空气" + data.getCategory());

                tvPm10.setText(data.getPm10());//PM10
                tvPm25.setText(data.getPm2p5());//PM2.5
                tvNo2.setText(data.getNo2());//二氧化氮
                tvSo2.setText(data.getSo2());//二氧化硫
                tvO3.setText(data.getO3());//臭氧
                tvCo.setText(data.getCo());//一氧化碳
            } else {
                ToastUtils.showShortToast(context, "空气质量数据为空");
            }
        } else {
            ToastUtils.showShortToast(context, CodeToStringUtils.WeatherCode(response.getCode()));
        }
    }

    /**
     * 更多功能弹窗，区别于原先的弹窗
     */
    private void showAddWindow() {
        //设置布局文件
        mPopupWindow.setContentView(LayoutInflater.from(this).inflate(R.layout.window_add, null));// 为了避免部分机型不显示，我们需要重新设置一下宽高
        mPopupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        mPopupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        mPopupWindow.setBackgroundDrawable(new ColorDrawable(0x0000)); //设置pop透明效果
        mPopupWindow.setAnimationStyle(R.style.pop_add); //设置pop出入动画
        mPopupWindow.setFocusable(true);//设置pop获取焦点，如果为false点击返回按钮会退出当前Acitivity,如果pop中有Editor的话，focusable必须要为true
        mPopupWindow.setTouchable(true);//设置pop可点击,为false点击事件无效，默认为true
        mPopupWindow.setOutsideTouchable(true);//设置点击pop外侧消失，默认为false,在focusable为true时点击外侧始终消失
        mPopupWindow.showAsDropDown(ivAdd, -100, 0);//相对于+号正下面，同时可以设置偏移量
        //设置pop关闭监听，用于改变背景透明度
        mPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {//关闭弹窗
            @Override
            public void onDismiss() {
                toggleBright();
            }
        });
        //绑定布局中的控件
        TextView changeCity = mPopupWindow.getContentView().findViewById(R.id.tv_change_city);//切换城市
        TextView wallpaper = mPopupWindow.getContentView().findViewById(R.id.tv_wallpaper);//壁纸管理  我才是这条Gai最靓的仔
        TextView searchCity = mPopupWindow.getContentView().findViewById(R.id.tv_search_city);//城市搜索
        TextView worldCity = mPopupWindow.getContentView().findViewById(R.id.tv_world_city);//世界城市  V7
        TextView residentCity = mPopupWindow.getContentView().findViewById(R.id.tv_resident_city);//常用城市
        TextView aboutUs = mPopupWindow.getContentView().findViewById(R.id.tv_about_us);//关于我们
        TextView setting = mPopupWindow.getContentView().findViewById(R.id.tv_setting);//应用设置
        changeCity.setOnClickListener(view -> {//切换城市
            showCityWindow();
            mPopupWindow.dismiss();
        });
        wallpaper.setOnClickListener(view -> {//壁纸管理
            startActivity(new Intent(context, WallPaperActivity.class));
            mPopupWindow.dismiss();
        });
        searchCity.setOnClickListener(view -> {//城市搜索
            SPUtils.putBoolean(Constant.FLAG_OTHER_RETURN, false, context);//缓存标识
            startActivity(new Intent(context, SearchCityActivity.class));
            mPopupWindow.dismiss();
        });
        worldCity.setOnClickListener(view -> {//世界城市
            startActivity(new Intent(context, WorldCityActivity.class));
            mPopupWindow.dismiss();
        });
        residentCity.setOnClickListener(view -> {//常用城市
            SPUtils.putBoolean(Constant.FLAG_OTHER_RETURN, false, context);//缓存标识
            startActivity(new Intent(context, CommonlyUsedCityActivity.class));
            mPopupWindow.dismiss();
        });
        aboutUs.setOnClickListener(view -> {//关于我们
            startActivity(new Intent(context, AboutUsActivity.class));
            mPopupWindow.dismiss();
        });
        setting.setOnClickListener(view -> {//应用设置
            startActivity(new Intent(context, SettingActivity.class));
            mPopupWindow.dismiss();
        });
    }

    /**
     * 省市县数据渲染
     *
     * @param recyclerView 列表
     * @param areaBack     区县返回
     * @param cityBack     市返回
     * @param windowTitle  窗口标题
     */
    private void initCityData(RecyclerView recyclerView, ImageView areaBack, ImageView cityBack, TextView windowTitle) {
        //初始化省数据 读取省数据并显示到列表中
        try {
            //读取城市数据
            InputStream inputStream = getResources().getAssets().open("City.txt");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuffer stringBuffer = new StringBuffer();
            String lines = bufferedReader.readLine();
            while (lines != null) {
                stringBuffer.append(lines);
                lines = bufferedReader.readLine();
            }

            final JSONArray Data = new JSONArray(stringBuffer.toString());
            //循环这个文件数组、获取数组中每个省对象的名字
            for (int i = 0; i < Data.length(); i++) {
                JSONObject provinceJsonObject = Data.getJSONObject(i);
                String provinceName = provinceJsonObject.getString("name");
                CityResponse response = new CityResponse();
                response.setName(provinceName);
                provinceList.add(response);
            }

            //定义省份显示适配器
            provinceAdapter = new ProvinceAdapter(R.layout.item_city_list, provinceList);
            LinearLayoutManager manager = new LinearLayoutManager(context);
            recyclerView.setLayoutManager(manager);
            recyclerView.setAdapter(provinceAdapter);
            provinceAdapter.notifyDataSetChanged();
            //runLayoutAnimationRight(recyclerView);//动画展示
            provinceAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
                @Override
                public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                    try {
                        //返回上一级数据
                        cityBack.setVisibility(View.VISIBLE);
                        cityBack.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                recyclerView.setAdapter(provinceAdapter);
                                provinceAdapter.notifyDataSetChanged();
                                cityBack.setVisibility(View.GONE);
                                windowTitle.setText("中国");
                            }
                        });

                        //根据当前位置的省份所在的数组位置、获取城市的数组
                        JSONObject provinceObject = Data.getJSONObject(position);
                        windowTitle.setText(provinceList.get(position).getName());
                        provinceTitle = provinceList.get(position).getName();
                        final JSONArray cityArray = provinceObject.getJSONArray("city");

                        //更新列表数据
                        if (citylist != null) {
                            citylist.clear();
                        }

                        for (int i = 0; i < cityArray.length(); i++) {
                            JSONObject cityObj = cityArray.getJSONObject(i);
                            String cityName = cityObj.getString("name");
                            CityResponse.CityBean response = new CityResponse.CityBean();
                            response.setName(cityName);
                            citylist.add(response);
                        }

                        cityAdapter = new CityAdapter(R.layout.item_city_list, citylist);
                        LinearLayoutManager manager1 = new LinearLayoutManager(context);
                        recyclerView.setLayoutManager(manager1);
                        recyclerView.setAdapter(cityAdapter);
                        cityAdapter.notifyDataSetChanged();
                        //runLayoutAnimationRight(recyclerView);

                        cityAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
                            @Override
                            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                                try {
                                    //返回上一级数据
                                    areaBack.setVisibility(View.VISIBLE);
                                    areaBack.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            recyclerView.setAdapter(cityAdapter);
                                            cityAdapter.notifyDataSetChanged();
                                            areaBack.setVisibility(View.GONE);
                                            windowTitle.setText(provinceTitle);
                                            arealist.clear();
                                        }
                                    });
                                    //获取区/县的上级 市，用于请求空气质量数据API接口
                                    city = citylist.get(position).getName();
                                    //根据当前城市数组位置 获取地区数据
                                    windowTitle.setText(citylist.get(position).getName());
                                    JSONObject cityJsonObj = cityArray.getJSONObject(position);
                                    JSONArray areaJsonArray = cityJsonObj.getJSONArray("area");
                                    if (arealist != null) {
                                        arealist.clear();
                                    }
                                    if (list != null) {
                                        list.clear();
                                    }
                                    for (int i = 0; i < areaJsonArray.length(); i++) {
                                        list.add(areaJsonArray.getString(i));
                                    }
                                    Log.i("list", list.toString());
                                    for (int j = 0; j < list.size(); j++) {
                                        CityResponse.CityBean.AreaBean response = new CityResponse.CityBean.AreaBean();
                                        response.setName(list.get(j).toString());
                                        arealist.add(response);
                                    }
                                    areaAdapter = new AreaAdapter(R.layout.item_city_list, arealist);
                                    LinearLayoutManager manager2 = new LinearLayoutManager(context);

                                    recyclerView.setLayoutManager(manager2);
                                    recyclerView.setAdapter(areaAdapter);
                                    areaAdapter.notifyDataSetChanged();
                                    runLayoutAnimationRight(recyclerView);

                                    areaAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
                                        @Override
                                        public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                                            showLoadingDialog();
                                            district = arealist.get(position).getName();//选中的区/县赋值给这个全局变量

                                            //V7版本中需要先获取到城市ID ,在结果返回值中再进行下一步的数据查询
                                            mPresent.newSearchCity(district);//切换城市时

                                            flag = false;//切换城市得到的城市不属于定位，因此这里隐藏定位图标
                                            liWindow.closePopupWindow();//关闭弹窗
                                        }
                                    });
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    /**
     * 计算动画时间
     */
    private void toggleBright() {
        // 三个参数分别为：起始值 结束值 时长，那么整个动画回调过来的值就是从0.5f--1f的
        animUtil.setValueAnimator(START_ALPHA, END_ALPHA, DURATION);
        animUtil.addUpdateListener(progress -> {
            // 此处系统会根据上述三个值，计算每次回调的值是多少，我们根据这个值来改变透明度
            bgAlpha = bright ? progress : (START_ALPHA + END_ALPHA - progress);
            backgroundAlpha(bgAlpha);
        });
        animUtil.addEndListner(animator -> {
            // 在一次动画结束的时候，翻转状态
            bright = !bright;
        });
        animUtil.startAnimator();
    }

    /**
     * 此方法用于改变背景的透明度，从而达到“变暗”的效果
     */
    private void backgroundAlpha(float bgAlpha) {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        // 0.0-1.0
        lp.alpha = bgAlpha;
        getWindow().setAttributes(lp);
        // everything behind this window will be dimmed.
        // 此方法用来设置浮动层，防止部分手机变暗无效
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
    }

    /*
     * 定位结果返回
     * */
    private class MyLocationListener extends BDAbstractLocationListener {
        @Override
        public void onReceiveLocation(BDLocation location) {
//            double latitude = location.getLatitude();  //获取维度信息
//            double longitude = location.getLongitude(); //获取经度信息
//            float radius = location.getRadius(); // 获取定位精度，默认值为0.0f
//            String coorType = location.getCoorType();//获取定位类型、定位错误返回码，具体信息科参照参考BDLocation类中的说明
//            int errorCode = location.getLocType(); //161 表示网络定位结果
//            //获取定位类型、定位错误返回码，具体信息可参照类参考中BDLocation类中的说明
//            String addr = location.getAddrStr(); //获取详细地址信息
//            String country = location.getCountry(); //获取国家
//            String province = location.getProvince(); // 获取省份
//            String street = location.getStreet(); // 获取街道信息
            district = location.getDistrict(); // 获取区县
            city = location.getCity(); //获取城市
            if (district == null) { //未能获取到定位信息，请重新定位
                ToastUtils.showShortToast(context, "未能获取到定位信息，请重新定位");
                tvCity.setText("重新定位");
            } else {
                //在数据请求之前放在加载弹窗，返回结果后关闭弹窗
                showLoadingDialog();
                //下拉刷新
                refresh.setOnRefreshListener(refreshLayout -> {

                    //V7版本中需要先获取到城市ID，在结果返回值中再进行下一步的数据查询
                    mPresent.newSearchCity(district);
                });
            }
            //获取今天的天气数据
            /* String locationDescribe = location.getLocationDescribe();  //获取位置描述信息*/
        }
    }

    /**
     * 和风天气 v7 API
     * 通过定位到的地址 / 城市切换得到的地址 都需要查询出对应的城市id 才行，所以在v7版本中，这是第一步接口
     *
     * @param response
     */
    @Override
    public void getNewSearchCityResult(NewSearchCityResponse response) {
        refresh.finishRefresh();//关闭刷新
        if (mLocationClient != null) {
            mLocationClient.stop();//数据返回后关闭定位
        }
        if (response != null) {
            if (response.getCode().equals(Constant.SUCCESS_CODE)) {
                if (response.getLocation() != null && response.getLocation().size() > 0) {
                    NewSearchCityResponse.LocationBean locationBean = response.getLocation().get(0);
                    //如果是定位到当前地方则添加到常用城市
                    addCommonlyUsedCity(locationBean);
                    //日期所在地

                    tvCity.setText(locationBean.getName());//城市
                    locationId = locationBean.getId();//城市Id
                    stationName = locationBean.getAdm2();//上级城市 也是空气质量站点
                    lon = locationBean.getLon();//经度
                    lat = locationBean.getLat();//纬度
                    //mPresent.nowWarn(locationId);//灾害预警
                    mPresent.nowWeather(locationId);//查询实况天气
                    //mPresent.getMinutePrec(lon + "," + lat);//分钟级降水
                    mPresent.hourlyWeather(locationId);//查询逐小时天气预报
                    mPresent.dailyWeather(locationId);//查询天气预报
                    mPresent.airNowWeather(locationId);//空气质量
                    mPresent.lifestyle(locationId);//生活指数

                } else {
                    ToastUtils.showShortToast(context, "数据为空");
                }
            } else {
                dismissLoadingDialog();
                tvCity.setText("查询城市失败");
                ToastUtils.showShortToast(context, CodeToStringUtils.WeatherCode(response.getCode()));
            }
        } else {
            ToastUtils.showShortToast(context, "搜索城市数据为空");
        }
    }

    /**
     * 添加到常用城市列表
     * @param locationBean
     */
    private void addCommonlyUsedCity(NewSearchCityResponse.LocationBean locationBean) {
        if (flag) {//定位到的城市
            List<ResidentCity> residentCityList = LitePal.findAll(ResidentCity.class);
            if (residentCityList != null && residentCityList.size() > 0) {
                //查询要添加的城市是否已经存在
                List<ResidentCity> residentCities = LitePal
                        .where("location = ? and parent_city = ?", locationBean.getName(),locationBean.getAdm2())
                        .find(ResidentCity.class);
                if (residentCities.size() == 0) {
                    ResidentCity residentCity = new ResidentCity();
                    residentCity.setLocation(locationBean.getName());  //地区/城市名称
                    residentCity.setParent_city(locationBean.getAdm2()); //该地区/城市的上级城市
                    residentCity.setAdmin_area(locationBean.getCountry());//该地区/城市所属国家名称
                    residentCity.setCnty(locationBean.getCountry()); //该地区/城市所属国家名称
                    residentCity.save();//保存数据到数据库
                }
            }else {
                ResidentCity residentCity = new ResidentCity();
                residentCity.setLocation(locationBean.getName()); //地区/城市名称
                residentCity.setParent_city(locationBean.getAdm2()); //该地区/城市的上级城市
                residentCity.setAdmin_area(locationBean.getAdm1()); //该地区/城市所属行政区域
                residentCity.setCnty(locationBean.getCountry());//该地区/该城市所属国家名称
                residentCity.save();//保存数据到数据库
            }

        }
        //加载常用城市数据
        loadingCommonlyUsedCity();
    }

    /**
     * 加载常用城市数据
     */
    private void loadingCommonlyUsedCity(){
        residentCityList = LitePal.findAll(ResidentCity.class);
        //先判断是否有常用城市
        if (residentCityList != null && residentCityList.size() > 0) {
            isChangeCity = true;
        } else {
            isChangeCity = false;
        }
        //配置适配器
        changeCityAdapter = new MainChangeCommonlyCityAdapter(R.layout.item_main_city_change,residentCityList);
        LinearLayoutManager manager =  new LinearLayoutManager(context);
        manager.setOrientation(RecyclerView.HORIZONTAL);
        rvChangeCity.setLayoutManager(manager);
        rvChangeCity.setAdapter(changeCityAdapter);
        //常用城市点击
        changeCityAdapter.setOnItemChildClickListener(((adapter, view, position) -> {
            showLoadingDialog();
            district = residentCityList.get(position).getLocation();
            mPresent.newSearchCity(district);
            flag = false;
            //隐藏列表
            rvChangeCity.setVisibility(View.GONE);
            changeCityState = false;
        }));
    }

    /**
     * 实况天气数据返回  V7
     *
     * @param response
     */
    @Override
    public void getNowResult(NowResponse response) {
        if (response.getCode().equals(Constant.SUCCESS_CODE)) { //200则成功返回数据
            //根据V7版本的原则，只要是200就一定有数据，我们可以不用做判空处理，但是，为了使程序不ANR,还是要做的，信自己得永生
            Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Light.ttf");
            tvTemperature.setText(response.getNow().getTemp()); //温度
            tvTemperature.setTypeface(typeface);//使用字体

            if (flag) {
                ivLocation.setVisibility(View.VISIBLE); //显示定位图标
            } else {
                ivLocation.setVisibility(View.GONE); //不显示定位图标
            }
            tvWeek.setText(DateUtils.getWeekOfDate(new Date()));//星期
            tvInfo.setText(response.getNow().getText());//天气状况
            String time = DateUtils.updateTime(response.getUpdateTime()); //截去前面的字符，保留后面所有的字符，就剩下22:00
            tvOldTime.setText("最近更新时间：" + WeatherUtil.showTimeInfo(time) + time);
            tvWindDirection.setText("风向     " + response.getNow().getWindDir());//风向
            tvWindPower.setText("风力     " + response.getNow().getWindScale() + "级");//风力
            wwBig.startRotate();//大风车开始转动
            wwSmall.startRotate();//小风车开始转动
        } else {//其他状态返回提示文字
            ToastUtils.showShortToast(context, CodeToStringUtils.WeatherCode(response.getCode()));

        }
    }

    /**
     * 生活数据返回 V7
     *
     * @param response
     */
    @Override
    public void getLifestyleResult(LifestyleResponse response) {
        if (response.getCode().equals(Constant.SUCCESS_CODE)) {
            List<LifestyleResponse.DailyBean> data = response.getDaily();

            for (int i = 0; i < data.size(); i++) {
                switch (data.get(i).getType()) {
                    case "5":
                        tvUv.setText("紫外线：" + data.get(i).getText());
                        break;
                    case "8":
                        tvComf.setText("舒适度：" + data.get(i).getText());
                        break;
                    case "3":
                        tvDrsg.setText("穿衣指数：" + data.get(i).getText());
                        break;
                    case "9":
                        tvFlu.setText("感冒指数：" + data.get(i).getText());
                        break;
                    case "1":
                        tvSport.setText("运动指数：" + data.get(i).getText());
                        break;
                    case "6":
                        tvTrav.setText("旅游指数：" + data.get(i).getText());
                        break;
                    case "2":
                        tvCw.setText("洗车指数：" + data.get(i).getText());
                        break;
                    case "10":
                        tvAir.setText("空气指数：" + data.get(i).getText());
                        break;
                    default:
                        break;
                }
            }

        } else {
            ToastUtils.showShortToast(context, CodeToStringUtils.WeatherCode(response.getCode()));
        }
    }

    /**
     * 逐小时天气数据返回 v7
     *
     * @param response
     */
    @Override
    public void getHourlyResult(HourlyResponse response) {
        if (response.getCode().equals(Constant.SUCCESS_CODE)) {
            List<HourlyResponse.HourlyBean> data = response.getHourly();
            if (data != null && data.size() > 0) {
                hourlyListV7.clear();
                hourlyListV7.addAll(data);
                mAdapterDailyV7.notifyDataSetChanged();
                runLayoutAnimationRight(rvHourly);
            }
        }
    }

    /**
     * 天气预报数据返回 V7
     *
     * @param response
     */
    @Override
    public void getDailyResult(DailyResponse response) {
        if (response.getCode().equals(Constant.SUCCESS_CODE)) {
            List<DailyResponse.DailyBean> data = response.getDaily();
            //判空处理
            if (data != null && data.size() > 0) {
                tvTempHeight.setText(data.get(0).getTempMax() + "℃");
                tvTempLow.setText(" / " + data.get(0).getTempMin() + "℃");

                //添加数据之前先清除
                dailyListV7.clear();
                //添加数据
                dailyListV7.addAll(data);
                //刷新列表
                mAdapterDailyV7.notifyDataSetChanged();
                //底部动画展示
                runLayoutAnimation(rv);
            } else {
                ToastUtils.showShortToast(context, CodeToStringUtils.WeatherCode(response.getCode()));
            }
        }
    }

    /**
     * 页面销毁时
     */
    @Override
    public void onDestroy() {

        if (mLocationClient != null) {
            mLocationClient.stop(); //数据返回后关闭定位
        }
        wwBig.stop();//停止大风车
        wwSmall.stop();//停止小风车
        EventBus.getDefault().unregister(this); //解除注册
        super.onDestroy();
    }
}
