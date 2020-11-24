package com.example.currencymvp.api;

import android.content.Context;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import static com.example.currencymvp.utils.Constants.BASE_URL;

public class CurrencyApiInit {
    private CurrencyApiInterface.CurrencyService currencyService;
    private Retrofit retrofit;
    private Context context;

    public CurrencyApiInit(Context context) {
        this.context = context;
    }



    public CurrencyApiInit initApi() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return this;
    }


    public CurrencyApiInit createService() {
        currencyService = retrofit.create(CurrencyApiInterface.CurrencyService.class);
        return this;
    }

    public CurrencyApiInterface.CurrencyService getService() {
        return currencyService;
    }


}
