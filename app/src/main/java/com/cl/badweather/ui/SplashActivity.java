package com.cl.badweather.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.cl.badweather.MainActivity;
import com.cl.badweather.R;
import com.cl.mvplibrary.bean.Country;
import com.tbruyelle.rxpermissions2.RxPermissions;

import org.litepal.LitePal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class SplashActivity extends AppCompatActivity {
    /**
     * 权限请求框架
     */
    private RxPermissions rxPermissions;
    protected Activity context;  //
    private List<Country> list; //数据列表
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
            }
        },1000);
    }
}
