package com.example.currencymvp.ui;

import com.example.currencymvp.data.CurrencyResponse;
import com.example.currencymvp.interactor.CurrencyInteractor;
import com.example.currencymvp.utils.InternetConnection;

import java.net.ConnectException;
import java.util.ArrayList;
import java.util.List;


import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CurrencyPresenter {

    private CurrencyView view;
    @Inject
    CurrencyInteractor currencyInteractor;
    private List<CurrencyResponse> globalCurrencyResponseList = new ArrayList<>();

    @Inject
    public CurrencyPresenter() {
    }

    public void setView(CurrencyView view) {
        this.view = view;

    }

    public void updateCurrency(double amount) {
        if (globalCurrencyResponseList.size() > 0) {
            for (CurrencyResponse response : globalCurrencyResponseList) {
                response.setCalculatedAmount(amount * response.getRate());
            }
            view.setData(globalCurrencyResponseList);
        }
    }


    public void onSendRequest(String base) {
        if (view == null) return;
        if (InternetConnection.isConnected(view.getContext())) {
            currencyInteractor.getCurrency(base, new CurrencyCallback());
        } else {
            view.showError("No internet");
        }
    }

    public class CurrencyCallback implements Callback<List<CurrencyResponse>> {


        @Override
        public void onResponse(Call<List<CurrencyResponse>> call, Response<List<CurrencyResponse>> response) {
            view.hideProgressBar();

            if (response.code() == 200) {

                if (response.body() != null && response.body().size() > 0) {

                    globalCurrencyResponseList.addAll(response.body());
                    updateCurrency(1.0);

                }
            } else {
                view.showError("Empty view");
            }

        }

        @Override
        public void onFailure(Call<List<CurrencyResponse>> call, Throwable t) {
            view.hideProgressBar();

            if (t instanceof ConnectException) {
                view.showError("Error no internet");
            }

        }
    }
}


