package org.example.Entities;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private static int counter = 1;
    private int id;
    private int balance;

    private List<Transaction> transactions = new ArrayList<>();

    public Account(int balance) {
        this.id = counter++;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public int getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
