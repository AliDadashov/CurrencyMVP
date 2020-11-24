package com.example.currencymvp.interactor;

import android.content.Context;

import com.example.currencymvp.data.CurrencyResponse;
import com.example.currencymvp.api.CurrencyApiInit;

import java.util.List;

import retrofit2.Callback;

public class CurrencyInteractor {

    private Context context;
    private CurrencyApiInit apiInitHelper;

    public CurrencyInteractor(Context context) {
        apiInitHelper = new CurrencyApiInit(context).initApi();
        this.context = context;
    }

    public void getCurrency(String base, Callback<List<CurrencyResponse>> responceCallback) {

        apiInitHelper
                .createService()
                .getService()
                .getCurrency(base)
                .enqueue(responceCallback);

    }


}
