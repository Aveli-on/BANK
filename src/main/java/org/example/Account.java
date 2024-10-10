package org.example;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Account {
    private int id;
    private String name;
    private double balance;
    private double annualInterestRate;
    private static List<Account> accounts = new ArrayList<Account>();
    private static List<Transaction> transactions = new ArrayList<Transaction>();
    private Date dateCreated;
    Account(){
    }
    Account(int id, double balance){
        this.id=id;
        this.balance=balance;
        accounts.add(this);
        this.dateCreated = Date.from(Instant.now());
        //transactions.add(new Transaction(Date.from(Instant.now()),'!',balance,balance,"Создание счета"));

    }
    Account(int id, double balance, String name){
        this.id=id;
        this.name=name;
        this.balance=balance;
        accounts.add(this);
        this.dateCreated = Date.from(Instant.now());
        //transactions.add(new Transaction(Date.from(Instant.now()),'!',balance,balance,"Создание счета"));

    }
    public String getname(){
        return name;
    }
    public void showTransactions(){
        System.out.println("\nТранзакции пользователя с id-"+id+"\n");
        for(Transaction t : transactions){
            System.out.println("Дата транзакции: "+t.dateCreated.toString());
            System.out.println("Тип транзакции: "+t.type);
            System.out.println("Сумма транзакции: "+ t.amount );
            System.out.println("Баланс после проведения транзакции: "+t.balance);
            System.out.println("Краткое описание транзакции: "+t.description+"\n");
        }
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public double getMonthlyInterest(){
        double MonthlyInterest;
        MonthlyInterest = annualInterestRate / 100 / 12;
        return MonthlyInterest;
    }
    public void withdraw(double amount){
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Сумма снята со счета!");
            transactions.add(new Transaction(Date.from(Instant.now()),'-',amount,balance,"Снятие со счета"));
        } else {
            System.out.println("Недостаточно средств на счёте.");
        }

    }
    public void deposit(double amount){
        balance+=amount;
        System.out.println("Депозит успешно введен!");
        transactions.add(new Transaction(Date.from(Instant.now()),'+',amount,balance,"Пополнение счета"));
    }
    public static Account findAccountById(List<Account> accounts, int id) throws IllegalArgumentException {
        for (Account account : accounts) {
            if (account.getId() == id) {
                return account;
            }
        }
        throw new IllegalArgumentException(("Счета с таким id не найден!"));
    }
    public static List<Account> getAccounts() {
        return accounts;
    }
}