package com.example.currencymvp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.currencymvp.R;
import com.example.currencymvp.data.CurrencyData;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements CurrencyView {

    private CurrencyPresenter presenter;
    private CurrencyAdapter adapter;
    ProgressBar progressBar;
    RecyclerView recyclerView;


    @BindView(R.id.enter_amount)
    EditText enteredAmount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        presenter = new CurrencyPresenter();
        presenter.setView(this);

        presenter.onSendRequest("USD");
    }

    @Override
    public void setData(String date) {

    }

    @Override
    public void setBaseCurrency(String baseCurrency) {

    }

    @Override
    public void setData(List<CurrencyData> dataList) {
        recyclerView = findViewById(R.id.currency_recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new CurrencyAdapter(this, dataList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.INVISIBLE);
    }
}