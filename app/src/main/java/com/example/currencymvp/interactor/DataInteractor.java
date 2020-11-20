package com.example.currencymvp.interactor;

import android.content.Context;

import com.example.currencymvp.data.CurrencyData;
import com.example.currencymvp.network.CurrencyApiInit;

import java.util.List;

import retrofit2.Callback;

public class DataInteractor {

    private Context context;
    private CurrencyApiInit apiInitHelper;

    public DataInteractor(Context context) {
        apiInitHelper = new CurrencyApiInit(context).initDefaultApi();
        this.context = context;
    }

    public void onRequest(String base, Callback<List<CurrencyData>> responceCallback) {

        apiInitHelper
                .createService()
                .getService()
                .getCurrency(base)
                .enqueue(responceCallback);

    }


}
