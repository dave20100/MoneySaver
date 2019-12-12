package com.example.moneysaver;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class PaymentHistory {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "Name")
    public String name;

    @ColumnInfo(name = "Price")
    public int price;

    @ColumnInfo(name = "Type")
    public String type;

    @ColumnInfo(name = "Category")
    public String category;

    public PaymentHistory(String Name, int Price, String Type, String category) {
        this.name = Name;
        this.price = Price;
        this.type = Type;
        this.category = category;
    }

    public PaymentHistory() {
    }
}

