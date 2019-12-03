package com.example.moneysaver;

public class Wallet {
    public int MoneyAmount;
    public PaymentHistory PaymentHistory;

    public Wallet(int moneyAmount) {
        MoneyAmount = moneyAmount;
        PaymentHistory = new PaymentHistory();
    }

    public com.example.moneysaver.PaymentHistory getPaymentHistory() {
        return PaymentHistory;
    }

    public Wallet() {
        MoneyAmount = 0;
        PaymentHistory = new PaymentHistory();
    }

    public int getMoneyAmount() {
        return MoneyAmount;
    }

    public void setMoneyAmount(int moneyAmount) {
        MoneyAmount = moneyAmount;
    }
}
