package com.example.currencymvp.data;

import com.google.gson.annotations.SerializedName;

public class CurrencyResponse {
    double calculatedAmount=1d;

    public double getCalculatedAmount() {
        return calculatedAmount;
    }

    public void setCalculatedAmount(double calculatedAmount) {
        this.calculatedAmount = calculatedAmount;
    }

    @SerializedName("code")
    String code;
    @SerializedName("alphaCode")
    String alphaCode;
    @SerializedName("numericCode")
    String numericCode;
    @SerializedName("name")
    String name;
    @SerializedName("rate")
    Double rate;
    @SerializedName("date")
    String date;
    @SerializedName("inverseRate")
    String inverseRate;



    public CurrencyResponse(String code, String alphaCode, String numericCode, String name, Double rate, String date, String inverseRate) {
        this.code = code;
        this.alphaCode = alphaCode;
        this.numericCode = numericCode;
        this.name = name;
        this.rate = rate;
        this.date = date;
        this.inverseRate = inverseRate;
    }

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

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
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
