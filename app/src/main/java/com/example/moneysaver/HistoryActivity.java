package com.example.moneysaver;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class HistoryActivity extends AppCompatActivity {

    Thread t;
    ArrayList<PaymentHistory> paymentHistories;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        paymentHistories = new ArrayList<PaymentHistory>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                PaymentDatabase db = Room.databaseBuilder(getApplicationContext(),
                        PaymentDatabase.class, "payment-database").build();
                paymentHistories = new ArrayList(db.paymentDao().getAll());
            }
        }).start();
        //paymentHistories.add(new PaymentHistory("asd", 231, "ASD", "asdfa"));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView rw = (RecyclerView) findViewById(R.id.payment_history_recycler_view);
        rw.setLayoutManager(layoutManager);

        rw.setAdapter(new PaymentHistoryRecyclerViewAdapter(paymentHistories));
    }

}
