package com.example.moneysaver;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PaymentDao {
        @Query("SELECT * FROM paymenthistory")
        List<PaymentHistory> getAll();

        @Query("SELECT * FROM paymenthistory WHERE id IN (:paymentids)")
        List<PaymentHistory> loadAllByIds(int[] paymentids);
//
//        @Query("SELECT * FROM paymenthistory WHERE first_name LIKE :first AND " +
//                "last_name LIKE :last LIMIT 1")
//        PaymentHistory findByName(String first, String last);

        @Insert
        void insertAll(PaymentHistory... paymentHistories);

        @Delete
        void delete(PaymentHistory paymentHistory);

        @Query("DELETE FROM paymenthistory")
        public void clearTable();
}
