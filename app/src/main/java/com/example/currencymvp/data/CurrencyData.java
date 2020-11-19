package com.example.currencymvp.data;

import com.google.gson.annotations.SerializedName;

public class CurrencyData {

    @SerializedName("code")
    String code;
    @SerializedName("alphaCode")
    String alphaCode;
    @SerializedName("numericCode")
    String numericCode;
    @SerializedName("name")
    String name;
    @SerializedName("rate")
    String rate;
    @SerializedName("date")
    String date;
    @SerializedName("inverseRate")
    String inverseRate;


}
