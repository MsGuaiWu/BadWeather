package com.cl.badweather.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

import com.cl.badweather.MainActivity;
import com.cl.badweather.R;
import com.cl.badweather.utils.StatusBarUtil;
import com.cl.badweather.utils.ToastUtils;
import com.cl.mvplibrary.base.BaseActivity;
import com.cl.mvplibrary.bean.Country;
import com.tbruyelle.rxpermissions2.RxPermissions;

import org.litepal.LitePal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class SplashActivity extends BaseActivity {
    /**
     * 权限请求框架
     */
    private RxPermissions rxPermissions;
    protected Activity context;  //
    private List<Country> list; //数据列表

    @Override
    public void initDate(Bundle savedInstanceState) {
        StatusBarUtil.transparencyBar(context); //透明状态栏
        rxPermissions = new RxPermissions(this);//实例化这个权限请求框架，否则会报错
        permissionVersion(); //权限判断
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }
    //权限判断
    private void permissionVersion(){
        if (Build.VERSION.SDK_INT >= 23)  {  //6.0或以上
            //动态权限申请
            permissionsRequest();
        }else { //6.0以下
            //发现只要是权限在AnddroidMainifest.xml中注册过,均会认为该权限granted 提示一下即可
            ToastUtils.showShortToast(this,"你的手机系统版本在Android6.0以下，不需要动态申请权限。");
        }
    }
    private void permissionsRequest() {
        //使用这个框架需要定制jdk版本，建议用1.8
        rxPermissions.request(Manifest.permission.ACCESS_FINE_LOCATION)
                .subscribe(granted -> {
                    if (granted) {  //申请成功
                        //得到权限可以进入APP
                        //加载世界国家数据到本地数据库，已有则不加载
                        initCountryData();
                    }else { //申请失败
                         finish();
                         ToastUtils.showShortToast(this,"权限未开启");
                    }
                });
    }
    private void initCountryData() {
        list = LitePal.findAll(Country.class);
        if (list.size() > 0){//有数据了
            goToMain();
        }else { //第一次加载
            InputStreamReader is = null;
            try {
                is = new InputStreamReader(getAssets().open("world_country.csv"),"UTF-8");
                BufferedReader reader = new BufferedReader(is);
                reader.readLine();
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] result = line.split(",");
                    Country country = new Country();
                    country.setName(result[0]);
                    country.setCode(result[1]);
                    country.save();
                }
                goToMain();
            }catch (IOException e){
                e.printStackTrace();
            }

        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        goToMain();
    }
    /**
    *  延时跳转进入主页面
     **/
    private void goToMain() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
                Intent intent = new Intent(context, MainActivity.class);
                startActivity(intent);
            }
        },1000);
    }
}
