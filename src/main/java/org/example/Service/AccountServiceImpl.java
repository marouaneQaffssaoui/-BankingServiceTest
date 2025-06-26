package org.example.Service;

import org.example.Entities.Account;
import org.example.Entities.Transaction;
import org.example.Entities.TransactionType;

import java.util.ArrayList;
import java.util.List;

public class AccountServiceImpl implements AccountService{

    public Account account = new Account(0);
    int currentBalance = 0;

    @Override
    public void deposit(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("amount should be positive !!");
        }
        currentBalance += amount;
        account.setBalance(currentBalance);
        account.getTransactions().add(new Transaction(account.getId(), amount, TransactionType.DEPOSIT, currentBalance));
    }

    @Override
    public void withdraw(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("amount should be positive !!");
        }
        if (amount > account.getBalance()) {
            throw new IllegalArgumentException("insufficient balance !!");
        }
        currentBalance = account.getBalance() - amount;
        account.setBalance(currentBalance);
        account.getTransactions().add(new Transaction(account.getId(), amount, TransactionType.WITHDRAW, currentBalance));
    }

    @Override
    public void printStatement() {
        System.out.println("Date  || Amount || Balance");
        List<Transaction> transactions = account.getTransactions();
        for(int i = transactions.size() - 1; i >= 0; i--){
            System.out.println(transactions.get(i));
        }


    }
}
