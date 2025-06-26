package org.example;


import org.example.Service.AccountService;
import org.example.Service.AccountServiceImpl;

public class Main {
    public static void main(String[] args) {
        AccountService service = new AccountServiceImpl();

        service.deposit(1000);
        service.deposit(2000);
        service.withdraw(500);

        service.printStatement();
    }
}