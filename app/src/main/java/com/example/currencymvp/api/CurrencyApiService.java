package com.example.currencymvp.api;

import javax.inject.Inject;

import retrofit2.Retrofit;

public class CurrencyApiService {

    private CurrencyApiInterface.CurrencyService currencyService;

    @Inject
    Retrofit retrofit;

    @Inject
    public CurrencyApiService() {

    }

    public CurrencyApiInterface.CurrencyService createService() {
        currencyService = retrofit.create(CurrencyApiInterface.CurrencyService.class);
        return currencyService;
    }


}
