package com.example.moneysaver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class AddPaymentActivity extends AppCompatActivity {

    EditText name;
    EditText price;
    EditText type;
    EditText category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_payment);
    }

    public void AddPayment(View view)
    {
        name = findViewById(R.id.nameText);
        price = findViewById(R.id.priceText);
        type = findViewById(R.id.typeText);
        category = findViewById(R.id.categoryText);

        new Thread(new Runnable() {
            @Override
            public void run() {
                PaymentDatabase db = Room.databaseBuilder(getApplicationContext(),
                        PaymentDatabase.class, "payment-database").build();
                db.paymentDao().insertAll(new PaymentHistory(name.getText().toString(), Integer.parseInt(price.getText().toString()), type.getText().toString(), category.getText().toString()));
            }
        }).start();
    }
}
