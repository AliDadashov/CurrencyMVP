package com.example.currencymvp.api;

import android.content.Context;


import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
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


    public static OkHttpClient getUnsafeOkHttpClient() {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();

        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient = okHttpClient.newBuilder()
                .addInterceptor(logging)
                .build();

        return okHttpClient;
    }


    public CurrencyApiInit initApi() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(getUnsafeOkHttpClient())
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
