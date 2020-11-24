package com.example.currencymvp.ui;


import android.content.Context;

import com.example.currencymvp.data.CurrencyResponse;

import java.util.List;

public interface CurrencyView {


    void setData(List<CurrencyResponse> dataList);

    void showProgressBar();

    void hideProgressBar();

    void showError(String msg);

    Context getContext();

}
