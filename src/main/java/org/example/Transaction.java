package org.example;

import java.util.Date;

public class Transaction {
    private Date dateCreated;
    private char type;
    private double amount;
    private double balance;
    private String description;
    Transaction(Date dateCreated, char type, double amount, double balance, String description) {
        this.dateCreated = dateCreated;
        this.type = type;
        this.amount = amount;
        this.balance = balance;
        this.description = description;
    }
}
