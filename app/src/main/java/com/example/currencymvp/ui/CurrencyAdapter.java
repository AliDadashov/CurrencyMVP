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

public class CurrencyAdapter extends RecyclerView.Adapter<CurrencyAdapter.CurrencyVievHolder> {

    private List<CurrencyData> currencyDataList;
    Context context;

    public CurrencyAdapter(Context context) {
        this.context = context;
        currencyDataList = new ArrayList<>();

    }

    public void addDataNotified(List<CurrencyData> currencyData) {
        this.currencyDataList.clear();
        this.currencyDataList.addAll(currencyData);
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public CurrencyAdapter.CurrencyVievHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_currency_list, parent, false);
        CurrencyVievHolder currencyVievHolder = new CurrencyVievHolder(view);
        return currencyVievHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CurrencyVievHolder holder, int position) {
        holder.textName.setText(currencyDataList.get(position).getName());
        holder.textCurrency.setText(currencyDataList.get(position).getCode());
        holder.textRate.setText(currencyDataList.get(position).getRate());
    }

    @Override
    public int getItemCount() {
        return currencyDataList.size();
    }

    public class CurrencyVievHolder extends RecyclerView.ViewHolder {

        TextView textName;
        TextView textCurrency;
        TextView textRate;


        public CurrencyVievHolder(@NonNull View itemView) {
            super(itemView);

            textName = itemView.findViewById(R.id.textView_name);
            textCurrency = itemView.findViewById(R.id.textView_currency);
            textRate = itemView.findViewById(R.id.textView_rate);
        }
    }
}
