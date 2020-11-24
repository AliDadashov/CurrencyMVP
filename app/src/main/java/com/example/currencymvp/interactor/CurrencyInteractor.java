package com.example.currencymvp.interactor;

import android.content.Context;

import com.example.currencymvp.data.CurrencyResponse;
import com.example.currencymvp.api.CurrencyApiInit;

import java.util.List;

import retrofit2.Callback;

public class CurrencyInteractor {

    private CurrencyApiInit apiInitHelper;

    public CurrencyInteractor() {
        apiInitHelper = new CurrencyApiInit().initApi();
    }

    public void getCurrency(String base, Callback<List<CurrencyResponse>> responceCallback) {

        apiInitHelper
                .createService()
                .getService()
                .getCurrency(base)
                .enqueue(responceCallback);

    }


}
