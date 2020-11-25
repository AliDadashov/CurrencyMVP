package com.example.currencymvp.data;

import com.google.gson.annotations.SerializedName;

public class CurrencyResponse {
    double calculatedAmount = 1.00;

    public double getCalculatedAmount() {
        return calculatedAmount;
    }

    public void setCalculatedAmount(double calculatedAmount) {
        this.calculatedAmount = calculatedAmount;
    }

    @SerializedName("code")
    private String code;
    @SerializedName("alphaCode")
    private String alphaCode;
    @SerializedName("numericCode")
    private String numericCode;
    @SerializedName("name")
    private String name;
    @SerializedName("rate")
    private Double rate;
    @SerializedName("date")
    private String date;
    @SerializedName("inverseRate")
    private String inverseRate;


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
