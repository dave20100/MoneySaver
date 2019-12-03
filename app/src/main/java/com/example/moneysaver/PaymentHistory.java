package com.example.moneysaver;

import java.util.ArrayList;

public class PaymentHistory {
    Wallet Wallet;
    ArrayList<Payment> Payments;

    public PaymentHistory() {
        Wallet = new Wallet();
        Payments = new ArrayList<>();
    }
}
