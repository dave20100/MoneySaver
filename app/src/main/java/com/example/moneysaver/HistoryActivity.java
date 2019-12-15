package com.example.moneysaver;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {

    Thread t;
    ArrayList<PaymentHistory> paymentHistories;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        paymentHistories = new ArrayList<>();
        t = new Thread(new Runnable() {
            @Override
            public void run() {
                PaymentDatabase db = Room.databaseBuilder(getApplicationContext(),
                        PaymentDatabase.class, "payment-database").build();
                paymentHistories = new ArrayList(db.paymentDao().getAll());
            }
        });
        t.start();
        try {
            t.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView rw = findViewById(R.id.payment_history_recycler_view);
        rw.setLayoutManager(layoutManager);

        rw.setAdapter(new PaymentHistoryRecyclerViewAdapter(paymentHistories));
    }
}
