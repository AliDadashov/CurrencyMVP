package com.example.currencymvp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.currencymvp.R;

public class MainActivity extends AppCompatActivity implements CurrencyView {

    ProgressBar progressBar;
    Button btnStatus;


    private CurrencyPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar2);
        btnStatus = findViewById(R.id.button);


        presenter = new CurrencyPresenter();
        presenter.setView(this, getApplicationContext());


        btnStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showProgressBar();
                String msg="";

                if (presenter.isConnected()) {
                   msg="internet connected";


                } else {
                    msg="No internet connected";
                }
                hideProgressBar();
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
            }
        });
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