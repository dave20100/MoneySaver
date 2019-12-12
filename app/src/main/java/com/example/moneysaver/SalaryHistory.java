package com.example.moneysaver;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class SalaryHistory {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "Amount")
    public int amount;

    public SalaryHistory(int amount) {
        this.amount = amount;
    }
}
