package com.example.currencymvp.ui;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

public class CurrencyPresenter {

    private CurrencyView view;

    public void setView(CurrencyView view) {
        this.view = view;

    }
}