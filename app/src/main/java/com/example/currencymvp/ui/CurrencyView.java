package com.example.currencymvp.ui;


import android.content.Context;

import com.example.currencymvp.data.CurrencyData;

import java.util.List;

public interface CurrencyView {

    void setRate(String rate);

    void setData(List<CurrencyData> dataList);

    void showProgressBar();

    void hideProgressBar();

    void showError(String msg);

    Context getContext();
}
