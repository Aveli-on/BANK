package org.example;
import org.apache.commons.lang3.StringUtils;
import org.example.Account.*;
import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(StringUtils.upperCase("Hello and welcome!"));
        Scanner in = new Scanner(System.in);
        Account[] bank=new Account[10];
        for (int i = 0; i < 10; i++) {
            bank[i]=new Account(i,21311+i*213);
        }


        Account account = new Account(1155, 300000);
        account.setAnnualInterestRate(650);
        account.withdraw(16500);
        account.deposit(50000);
        System.out.println("===================================================");
        System.out.println("Номер счета : " + account.getId());
        System.out.println("Баланс : " + account.getBalance());
        System.out.println("Месячная ставка : " + account.getMonthlyInterest());
        System.out.println("Дата создания : " + account.getDateCreated());

        System.out.println("===================================================");

        Menu men=new Menu();
        men.show();

    }
}


