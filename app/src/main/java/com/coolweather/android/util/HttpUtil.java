package com.coolweather.android.util;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class HttpUtil {
    //与服务器交互 只需要调用sendOkHttpRequset（）方法，传入请求地址，
    //并注册一个回调来处理服务器响应即可
    public static void sendOkHttpRequset(String address, Callback callback){
        OkHttpClient client=new OkHttpClient();
        Request request=new Request.Builder().url(address).build();
        client.newCall(request).enqueue(callback);
    }




}
