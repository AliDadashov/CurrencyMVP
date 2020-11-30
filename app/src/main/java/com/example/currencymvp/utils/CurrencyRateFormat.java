package com.example.currencymvp.utils;

import android.util.Log;

import org.jetbrains.annotations.NotNull;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class CurrencyRateFormat {

    public static String onRateFormat(@NotNull double currencyRate) {
        Log.e("test",currencyRate+"");

        NumberFormat formatter = new DecimalFormat("#0.000");

        return formatter.format(currencyRate);

    }
}
