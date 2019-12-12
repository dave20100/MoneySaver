package com.example.moneysaver;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface SalaryDao {
    @Query("SELECT * FROM salaryhistory")
    List<SalaryHistory> getAll();

    @Query("SELECT * FROM salaryhistory WHERE id IN (:salaryids)")
    List<SalaryHistory> loadAllByIds(int[] salaryids);
//
//        @Query("SELECT * FROM paymenthistory WHERE first_name LIKE :first AND " +
//                "last_name LIKE :last LIMIT 1")
//        PaymentHistory findByName(String first, String last);

    @Insert
    void insertAll(SalaryHistory... salaryHistories);

    @Delete
    void delete(SalaryHistory salaryHistory);

    @Query("DELETE FROM salaryhistory")
    public void clearTable();
}
