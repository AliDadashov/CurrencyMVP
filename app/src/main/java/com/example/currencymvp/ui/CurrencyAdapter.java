package com.example.currencymvp.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.currencymvp.R;
import com.example.currencymvp.data.CurrencyData;

import java.util.ArrayList;
import java.util.List;

public class CurrencyAdapter extends RecyclerView.Adapter<CurrencyAdapter.VievHolder> {

    private List<CurrencyData> currencyData;
    Context context;

    public CurrencyAdapter(Context context) {
        this.context = context;
        currencyData = new ArrayList<>();

    }

    public void addDataNotified(List<CurrencyData> currencyData) {
        this.currencyData.clear();
        this.currencyData.addAll(currencyData);
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public CurrencyAdapter.VievHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_currency_list, parent, false);
        return new VievHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VievHolder holder, int position) {
        holder.textName.setText(currencyData.get(position).getName());
        holder.textCurrency.setText(currencyData.get(position).getCode());
        holder.textRate.setText(currencyData.get(position).getRate());
    }

    @Override
    public int getItemCount() {
            return currencyData.size();
    }

    public class VievHolder extends RecyclerView.ViewHolder {

        TextView textName;
        TextView textCurrency;
        TextView textRate;


        public VievHolder(@NonNull View itemView) {
            super(itemView);

            textName = itemView.findViewById(R.id.textView_name);
            textCurrency = itemView.findViewById(R.id.textView_currency);
            textRate = itemView.findViewById(R.id.textView_rate);
        }
    }
}
