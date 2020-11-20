package com.example.currencymvp.ui;



import com.example.currencymvp.data.CurrencyData;

import java.util.List;

public interface CurrencyView {

    void setData(String date);

    void setBaseCurrency(String baseCurrency);

    void setData(List<CurrencyData> dataList);

    void showProgressBar();
    void hideProgressBar();
}
