package com.example.currencymvp.ui;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.currencymvp.R;
import com.example.currencymvp.data.CurrencyResponse;
import com.example.currencymvp.utils.CurrencyRateFormat;

import org.jetbrains.annotations.NotNull;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class CurrencyAdapter extends RecyclerView.Adapter<CurrencyAdapter.CurrencyViewHolder> {

    private List<CurrencyResponse> currencyResponseList;
    Context context;

    public CurrencyAdapter(Context context) {
        this.context = context;
        currencyResponseList = new ArrayList<>();

    }

    public void addDataNotified(List<CurrencyResponse> currencyResponseList) {
        this.currencyResponseList.clear();
        this.currencyResponseList.addAll(currencyResponseList);
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public CurrencyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_currency_list, parent, false);
        CurrencyViewHolder currencyViewHolder = new CurrencyViewHolder(view);
        return currencyViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CurrencyViewHolder holder, int position) {
        holder.textName.setText(currencyResponseList.get(position).getName());
        holder.textCurrency.setText(currencyResponseList.get(position).getCode());
        holder.textRate.setText(CurrencyRateFormat.onRateFormat(currencyResponseList.get(position).getCalculatedAmount()));
    }

    @Override
    public int getItemCount() {
        return currencyResponseList.size();
    }




    public class CurrencyViewHolder extends RecyclerView.ViewHolder {

        TextView textName;
        TextView textCurrency;
        TextView textRate;


        public CurrencyViewHolder(@NonNull View itemView) {
            super(itemView);

            textName = itemView.findViewById(R.id.textView_name);
            textCurrency = itemView.findViewById(R.id.textView_currency);
            textRate = itemView.findViewById(R.id.textView_rate);
        }

    }




}
