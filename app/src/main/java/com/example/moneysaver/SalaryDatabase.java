package com.example.moneysaver;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {SalaryHistory.class}, version = 1)
public abstract class SalaryDatabase extends RoomDatabase {
    public abstract SalaryDao salaryDao();
}