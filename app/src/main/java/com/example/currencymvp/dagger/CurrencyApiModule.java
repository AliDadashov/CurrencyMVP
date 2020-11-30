package com.example.currencymvp.dagger;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import static com.example.currencymvp.utils.Constants.BASE_URL;

@Module
public class CurrencyApiModule {

    @Provides
    public HttpLoggingInterceptor provideHttpLogging() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        return logging;

    }

    @Provides
    public OkHttpClient provideOkkHttpClient() {

        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient = okHttpClient.newBuilder()
                .addInterceptor(provideHttpLogging())
                .build();

        return okHttpClient;
    }

    @Provides
    public Retrofit initApi() {
      return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(provideOkkHttpClient())
                .build();

    }

}
