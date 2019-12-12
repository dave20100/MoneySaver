package com.example.moneysaver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;
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
                db.paymentDao().clearTable();
                db.paymentDao().insertAll(new PaymentHistory("asda", 12, "SDA", "1231"));
                for(PaymentHistory p: db.paymentDao().getAll()) {
                    Log.i("ASd", "run: " + p.id);
                }
                Log.i("The tah", "run: " + db.paymentDao().getAll().get(0).name);

                SalaryDatabase salarydb = Room.databaseBuilder(getApplicationContext(),
                        SalaryDatabase.class, "salary-database").build();
                salarydb.salaryDao().clearTable();
                salarydb.salaryDao().insertAll(new SalaryHistory( 12));
                Log.i("The tah", "run: " + salarydb.salaryDao().getAll().get(0).amount);
            }
        }).start();
        }
}
