package com.example.currencymvp.api;

import com.example.currencymvp.data.CurrencyResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CurrencyApiInterface {

    interface CurrencyService {
        @GET("rates.php")
        Call<List<CurrencyResponse>>  getCurrency(@Query("base") String base);

    }
}
