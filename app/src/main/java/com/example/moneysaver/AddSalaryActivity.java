package com.example.moneysaver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddSalaryActivity extends AppCompatActivity {

    EditText amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_salary);


    }
    public void AddSalary(View view)
    {
        amount = findViewById(R.id.amount);

        new Thread(new Runnable() {
            @Override
            public void run() {
                SalaryDatabase db = Room.databaseBuilder(getApplicationContext(),
                        SalaryDatabase.class, "salary-database").build();
                db.salaryDao().insertAll(new SalaryHistory(Integer.parseInt(amount.getText().toString())));
            }
        }).start();
        this.finish();
    }
}
