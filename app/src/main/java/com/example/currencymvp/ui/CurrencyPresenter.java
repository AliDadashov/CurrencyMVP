package com.example.currencymvp.ui;

import android.content.Context;

import com.example.currencymvp.data.CurrencyData;
import com.example.currencymvp.interactor.CurrencyInteractor;
import com.example.currencymvp.utils.InternetConnection;

import java.net.ConnectException;
import java.util.List;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CurrencyPresenter {

    private CurrencyView view;
    private CurrencyInteractor currencyInteractor;
    Context context;

    public void setView(CurrencyView view) {
        this.view = view;

    }

    public void onSendRequest(String base) {
        if (view == null) return;
        if (InternetConnection.isConnected(view.getContext())) {
            currencyInteractor.getCurrency(base, new CurrencyCallback());
        }else {
            view.showError("No internet");
        }
    }

    public class CurrencyCallback implements Callback<List<CurrencyData>> {


        @Override
        public void onResponse(Call<List<CurrencyData>> call, Response<List<CurrencyData>> response) {
            view.hideProgressBar();

            if (response.code() == 200) {

                if (response.body() != null && response.body().size() > 0) {
                    view.setData(response.body());

                }
            } else {
                view.showError("Empty view");
            }

        }

        @Override
        public void onFailure(Call<List<CurrencyData>> call, Throwable t) {
            view.hideProgressBar();

            if (t instanceof ConnectException) {
                view.showError("Error no internet");
            }

        }
    }
}


