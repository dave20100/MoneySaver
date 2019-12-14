package com.example.moneysaver;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class PaymentHistoryRecyclerViewAdapter extends RecyclerView.Adapter<PaymentHistoryViewHolder> {
    public List<PaymentHistory> paymentHistories;
    public PaymentHistoryRecyclerViewAdapter(ArrayList<PaymentHistory> paymentHistories) {
        this.paymentHistories = paymentHistories;
    }

    @NonNull
    @Override
    public PaymentHistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.payment_history_row, parent, false);

        return new PaymentHistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PaymentHistoryViewHolder holder, int position) {
        holder.Bind(paymentHistories.get(position));
    }

    @Override
    public int getItemCount() {
        return this.paymentHistories.size();
    }
}

class PaymentHistoryViewHolder extends RecyclerView.ViewHolder {
    public View itemView;

    public PaymentHistoryViewHolder(View itemView) {
        super(itemView);
        this.itemView = itemView;
    }

    public void Bind(PaymentHistory pH) {
        TextView price = itemView.findViewById(R.id.priceTextView);
        TextView name = itemView.findViewById(R.id.nameTextView);
        TextView type = itemView.findViewById(R.id.typeTextView);
        TextView category = itemView.findViewById(R.id.categoryTextView);

        price.setText(pH.price + " PLN");
        name.setText(pH.name);
        type.setText(pH.type);
        category.setText(pH.category);

    }
}