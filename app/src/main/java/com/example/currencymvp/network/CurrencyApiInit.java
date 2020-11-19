package com.example.currencymvp.network;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class CurrencyApiInit {

    public static String BASE_URL="https://tayqatech.com/";

    public static CurrencyApiInterface.CurrencyService buildRetrofit() {

        return new Retrofit.Builder()
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
                .create(CurrencyApiInterface.CurrencyService.class);
    }
}
