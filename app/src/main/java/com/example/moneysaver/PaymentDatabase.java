package com.example.moneysaver;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {PaymentHistory.class}, version = 1, exportSchema = false)
public abstract class PaymentDatabase extends RoomDatabase {
    public abstract PaymentDao paymentDao();
}