package org.example.Entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {

    final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/mm/yyyy");

    private int id;
    private int amount;
    private TransactionType transactionType;
    private String date;
    private int balanceAfter;

    public Transaction(int id, int amount, TransactionType transactionType, int balanceAfter) {
        this.id = id;
        this.amount = amount;
        this.transactionType = transactionType;
        this.date =  this.date = LocalDateTime.now().format(formatter);;
        this.balanceAfter = balanceAfter;
    }

    public DateTimeFormatter getFormatter() {
        return formatter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getBalanceAfter() {
        return balanceAfter;
    }

    public void setBalanceAfter(int balanceAfter) {
        this.balanceAfter = balanceAfter;
    }

    @Override
    public String toString() {
        String format = String.format("%s || %d || %d", date, amount, balanceAfter);
        return format;
    }
}
