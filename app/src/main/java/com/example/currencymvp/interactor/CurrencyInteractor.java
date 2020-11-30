package com.example.currencymvp.interactor;


import com.example.currencymvp.api.CurrencyApiInterface;
import com.example.currencymvp.api.CurrencyApiService;
import com.example.currencymvp.dagger.CurrencyApiModule;
import com.example.currencymvp.data.CurrencyResponse;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Callback;
import retrofit2.Retrofit;

public class CurrencyInteractor {

    @Inject
    CurrencyApiService currencyApiService;

    @Inject
    public CurrencyInteractor() {
        currencyApiService = new CurrencyApiService();
    }


    public void getCurrency(String base, Callback<List<CurrencyResponse>> responceCallback) {
        currencyApiService
                .createService()
                .getCurrencyApi(base)
                .enqueue(responceCallback);

    }

}
