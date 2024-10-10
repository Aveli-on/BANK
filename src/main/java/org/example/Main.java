package org.example;
import org.apache.commons.lang3.StringUtils;
import org.example.Account.*;
import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       System.out.println(StringUtils.upperCase("Hello and welcome!"));
        Scanner in = new Scanner(System.in);
        Account account = new Account(1233,1100,"Семен");
        account.setAnnualInterestRate(7.5);
        account.deposit(500);
        account.deposit(600);
        account.deposit(700);
        account.withdraw(700);
        account.withdraw(600);
        account.withdraw(100);
        System.out.println("===================================================");
        System.out.println("Номер счета : " + account.getId());
        System.out.println("Имя владельца : " + account.getname());
        System.out.println("Balance : " + account.getBalance());
        System.out.println("Месячная ставка : " + account.getMonthlyInterest());
        System.out.println("Дата создания : " + account.getDateCreated());
        account.showTransactions();
        System.out.println("===================================================");
        //Menu men=new Menu();
       //men.show();

    }
}


