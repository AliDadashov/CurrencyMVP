package com.example.currencymvp;

import android.app.Application;
import android.content.Context;


import com.example.currencymvp.dagger.CurrencyApiModule;
import com.example.currencymvp.dagger.CurrencyComponent;
import com.example.currencymvp.dagger.DaggerCurrencyComponent;

public class CurrencyApplication extends Application {

    private CurrencyComponent component;

    public static CurrencyApplication get(Context context) {
        return (CurrencyApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerCurrencyComponent.builder()
                .currencyApiModule(new CurrencyApiModule())
                .build();
    }

    public CurrencyComponent getComponent() {
        return component;
    }

}
