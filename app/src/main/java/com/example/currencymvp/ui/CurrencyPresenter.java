package com.example.currencymvp.ui;

import com.example.currencymvp.data.CurrencyData;
import com.example.currencymvp.interactor.DataInteractor;

import java.util.List;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CurrencyPresenter {

    private CurrencyView view;
    private DataInteractor dataInteractor;

    public void setView(CurrencyView View) {
        this.view = View;

    }

    public void onSendRequest(String base) {
        dataInteractor.onRequest(base, new LoginCallback());

    }

    public class LoginCallback implements Callback<List<CurrencyData>> {


        @Override
        public void onResponse(Call<List<CurrencyData>> call, Response<List<CurrencyData>> response) {
            if (response.code() == 200) {

                if (response.body() != null) {
                    view.setData(response.body());

                }
            }
            view.hideProgressBar();

        }

        @Override
        public void onFailure(Call<List<CurrencyData>> call, Throwable t) {

            view.showProgressBar();
        }
    }


}