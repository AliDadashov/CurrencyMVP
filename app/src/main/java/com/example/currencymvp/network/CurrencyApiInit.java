package com.example.currencymvp.network;

import android.content.Context;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class CurrencyApiInit {
    private CurrencyApiInterface.CurrencyService currencyService;
    private Retrofit retrofit;

    private Context context;

    public CurrencyApiInit(Context context) {
        this.context = context;
    }

    public static String BASE_URL = "https://tayqatech.com/";

//    public static CurrencyApiInterface.CurrencyService buildRetrofit() {
//
//        return new Retrofit.Builder()
//                .addConverterFactory(ScalarsConverterFactory.create())
//                .addConverterFactory(GsonConverterFactory.create())
//                .baseUrl(BASE_URL)
//                .build()
//                .create(CurrencyApiInterface.CurrencyService.class);
//    }

    public CurrencyApiInit initDefaultApi() {
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
