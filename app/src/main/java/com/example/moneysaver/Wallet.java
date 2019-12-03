package com.example.moneysaver;

public class Wallet {
    public int MoneyAmount;

    public Wallet(int moneyAmount) {
        MoneyAmount = moneyAmount;
    }

    public Wallet() {
        MoneyAmount = 0;
    }

    public int getMoneyAmount() {
        return MoneyAmount;
    }

    public void setMoneyAmount(int moneyAmount) {
        MoneyAmount = moneyAmount;
    }
}
