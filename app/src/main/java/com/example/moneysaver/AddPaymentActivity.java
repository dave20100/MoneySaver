package com.example.moneysaver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AddPaymentActivity extends AppCompatActivity {

    EditText name;
    EditText price;
    Spinner typeSpinner;
    Spinner categorySpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_payment);

        categorySpinner= findViewById(R.id.categorySpinner);
        typeSpinner = findViewById(R.id.typeSpinner);
        ArrayList<String> categoryList = new ArrayList<>();
        categoryList.add("Food");
        categoryList.add("Cinema");
        categoryList.add("Entertainment");
        categoryList.add("Bills");
        categoryList.add("Transport");
        categoryList.add("Hobby");
        categoryList.add("Other");

        ArrayList<String> typeList = new ArrayList<>();
        typeList.add("Card");
        typeList.add("Mobile");
        typeList.add("Bank Transfer");
        typeList.add("Cash");

        ArrayAdapter<String> categoryArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categoryList);
        ArrayAdapter<String> typeArrayAdapter= new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, typeList);

        categoryArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        categorySpinner.setAdapter(categoryArrayAdapter);
        typeSpinner.setAdapter(typeArrayAdapter);
    }

    public void AddPayment(View view) throws InterruptedException {
        name = findViewById(R.id.nameText);
        price = findViewById(R.id.priceText);

        Thread t;
        t = new Thread(new Runnable() {
            @Override
            public void run() {
                PaymentDatabase db = Room.databaseBuilder(getApplicationContext(),
                        PaymentDatabase.class, "payment-database").build();
                db.paymentDao().insertAll(new PaymentHistory(name.getText().toString(), Integer.parseInt(price.getText().toString()), typeSpinner.getSelectedItem().toString(), categorySpinner.getSelectedItem().toString()));
            }
        });
        t.start();
        t.join();

        this.finish();
    }
}
