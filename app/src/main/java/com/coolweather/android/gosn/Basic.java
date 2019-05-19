package com.coolweather.android.gosn;

import android.util.Log;

import com.google.gson.annotations.SerializedName;

public class Basic {
    @SerializedName("city")
    public String cityName;

    @SerializedName("id")
    public String weatherId;

    public Update update;


    public class Update {

        @SerializedName("loc")
        public String updateTime;

    }
}
//由于JSON中的一些字段可能不太适合直接作为Java字段来命名，
// 因此这里使用了@SerializedName注解的方式来让JSON字段
// 和Java字段之间建立映射关系。