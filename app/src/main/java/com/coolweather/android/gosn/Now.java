package com.coolweather.android.gosn;

import com.google.gson.annotations.SerializedName;

public class Now {
    @SerializedName("tmp")
    public String temperature;

    @SerializedName("cond")
    public More more;

    public class More {

        @SerializedName("txt")
        public String info;

    }
}
