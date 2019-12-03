package com.example.moneysaver;

public class Wallet {
    public Owner owner;
    public int moneyAmount;
    public PaymentHistory paymentHistory;

    public Wallet(int moneyAmount, Owner owner) {
        this.owner = owner;
        this.moneyAmount = moneyAmount;
        this.paymentHistory = new PaymentHistory();
    }

    public Wallet(Owner owner) {
        this.owner = owner;
        this.moneyAmount = 0;
        this.paymentHistory = new PaymentHistory();
    }

}
