package com.example.currencymvp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.currencymvp.R;
import com.example.currencymvp.data.CurrencyData;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements CurrencyView {

    private CurrencyPresenter presenter;
    private CurrencyAdapter adapter;
    RecyclerView recyclerView;
    Context context;


    @BindView(R.id.amount_editText)
    EditText enteredAmount;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

//    @BindView(R.id.confirm_button)
//    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        presenter = new CurrencyPresenter();
        presenter.setView(this);

        recyclerView = findViewById(R.id.currency_recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new CurrencyAdapter(this);
        recyclerView.setAdapter(adapter);

        presenter.onSendRequest("GBP");
        showProgressBar();

    }


    @Override
    public void setRate(String rate) {

    }

    @Override
    public void setData(List<CurrencyData> dataList) {

        adapter.addDataNotified(dataList);
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.INVISIBLE);
    }


    @Override
    public void showError(String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();

    }

    @Override
    public MainActivity getContext() {
        return this;
    }
}