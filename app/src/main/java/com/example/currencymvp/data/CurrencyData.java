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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAlphaCode() {
        return alphaCode;
    }

    public void setAlphaCode(String alphaCode) {
        this.alphaCode = alphaCode;
    }

    public String getNumericCode() {
        return numericCode;
    }

    public void setNumericCode(String numericCode) {
        this.numericCode = numericCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getInverseRate() {
        return inverseRate;
    }

    public void setInverseRate(String inverseRate) {
        this.inverseRate = inverseRate;
    }
}
