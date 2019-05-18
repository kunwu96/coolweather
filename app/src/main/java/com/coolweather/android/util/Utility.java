package com.coolweather.android.util;

import android.text.TextUtils;

import com.coolweather.android.db.City;
import com.coolweather.android.db.County;
import com.coolweather.android.db.Province;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Utility {
    //解析和处理服务器返回的省级数据
    public  static boolean handleProvinceResponse(String response){
        if(!TextUtils.isEmpty(response)){
            try {
                JSONArray allProvinces = new JSONArray(response);//转换成json格式并且抛出异常
                for (int i=0;i<allProvinces.length();i++){
                    JSONObject provinceObject = allProvinces.getJSONObject(i);
                    Province province =new Province();//new 一个省
                    province.setProvinceName(provinceObject.getString("name"));//存省的信息
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.save();//调用方法存储数据库
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    //解析和处理服务器返回的市级数据，比省级数据多个省id
    public  static boolean handleCityResponse(String response ,int provinceId){
        if(!TextUtils.isEmpty(response)){
            try {
                JSONArray allCities = new JSONArray(response);//转换成json格式并且抛出异常
                for (int i=0;i<allCities.length();i++){
                    JSONObject cityObject = allCities.getJSONObject(i);
                    City city = new City();//new 一个市
                    city.setCityName(cityObject.getString("name"));//存市的信息
                    city.setCityCode(cityObject.getInt("id"));
                    city.setProvinceId(provinceId);
                    city.save();//调用方法存储数据库
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return false;
    }


    //解析和处理服务器返回的县级数据
    public  static boolean handleCountyResponse(String response ,int cityId){
        if(!TextUtils.isEmpty(response)){
            try {
                JSONArray allCounties = new JSONArray(response);//转换成json格式并且抛出异常
                for (int i=0;i<allCounties.length();i++){
                    JSONObject countyObject = allCounties.getJSONObject(i);
                    County county = new County();//new 一个县
                    county.setCountyName(countyObject.getString("name"));//存县的信息
                    county.setWeatherId(countyObject.getString("weather_id"));
                    county.setCityId(cityId);
                    county.save();//调用方法存储数据库
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return false;
    }
    /*
    * 我们提供了handleProvincesResponse() 、handleCitiesResponse() 、handleCountiesResponse()
    *  这3个方法，分别用于解析和处理服务器返回的省级、市级和县级数据。处理的方式都是类似的，
    * 先使用JSONArray和JSONObject将数据解析出来，然后组装成实体类对象，再调用save() 方法
    * 将数据存储到数据库当中。由于这里的JSON数据结构比较简单，我们就不使用GSON来进行解析了
    * */
}