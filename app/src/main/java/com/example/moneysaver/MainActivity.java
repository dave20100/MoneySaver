package com.example.moneysaver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        new Thread(new Runnable() {
            @Override
            public void run() {
                PaymentDatabase db = Room.databaseBuilder(getApplicationContext(),
                        PaymentDatabase.class, "payment-database").build();
//                db.paymentDao().clearTable();
                for(PaymentHistory p: db.paymentDao().getAll()) {
                    Log.i("ASd", "run: " + p.id);
                }
                Log.i("The tah", "run: " + db.paymentDao().getAll().get(0).name);

                SalaryDatabase salarydb = Room.databaseBuilder(getApplicationContext(),
                        SalaryDatabase.class, "salary-database").build();
//                salarydb.salaryDao().clearTable();
                salarydb.salaryDao().insertAll(new SalaryHistory( 12));
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
