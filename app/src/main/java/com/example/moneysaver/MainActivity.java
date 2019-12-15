package com.example.moneysaver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    PaymentDatabase db;

    SalaryDatabase salarydb;

    int result;

    TextView moneyAmountText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = Room.databaseBuilder(getApplicationContext(),
                PaymentDatabase.class, "payment-database").build();
        salarydb = Room.databaseBuilder(getApplicationContext(),
                SalaryDatabase.class, "salary-database").build();

        moneyAmountText = findViewById(R.id.moneyAmountText);
    }

    @Override
    protected void onResume() {
        super.onResume();
        result = 0;
        new Thread(new Runnable() {
            @Override
            public void run() {

                for(PaymentHistory ph: db.paymentDao().getAll()) {
                    result -= ph.price;
                }
                for(SalaryHistory sh: salarydb.salaryDao().getAll()) {
                    result += sh.amount;
                }

                moneyAmountText.setText(result+" PLN");
            }
        }).start();

    }

    public void openAddPayment(View view)
    {
        Intent intent = new Intent(this, AddPaymentActivity.class);
        startActivity(intent);
    }
    public void openShowHistory(View view)
    {
        Intent intent = new Intent(this, HistoryActivity.class);
        startActivity(intent);
    }
    public void openAddSalary(View view)
    {
        Intent intent = new Intent(this, AddSalaryActivity.class);
        startActivity(intent);
    }
    public void openShowGraphs(View view)
    {
        Intent intent = new Intent(this, GraphActivity.class);
        startActivity(intent);
    }
}
