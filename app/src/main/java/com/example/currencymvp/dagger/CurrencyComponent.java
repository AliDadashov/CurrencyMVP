package com.example.currencymvp.dagger;

import com.example.currencymvp.ui.CurrencyActivity;

import dagger.Component;
import retrofit2.Retrofit;

@Component(modules = {CurrencyApiModule.class})
public interface CurrencyComponent {

    Retrofit getRetrofit();

    void inject(CurrencyActivity activity);

}
