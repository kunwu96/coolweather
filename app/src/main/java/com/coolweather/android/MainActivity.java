package com.coolweather.android;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        //先做个缓存判断，进入app的时候如果已经选择了地区，数据不为空，就直接进入天气页面，不需要
        //用户再次选择地区了  直接跳转
        //Log.d("kunwu",prefs.getString("weather",null));
        if (prefs.getString("weather",null) != null){
            Intent intent = new Intent(this,WeatherActivity.class);

            startActivity(intent);

            finish();
        }
    }
}
