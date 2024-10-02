package org.example;

import java.util.Scanner;

public class Menu {


    void show() {

        Scanner in=new Scanner(System.in);
        while (true) {

            while (true) {
                try {
                    System.out.println("Введите ID клиента: ");
                    int id;
                    id = in.nextInt();
                    Account currentAccount = Account.findAccountById(Account.getAccounts(), id);

                    // Show the main menu
                    boolean exitMenu = false;
                    while (!exitMenu) {
                        System.out.println("меню\n1: Проверить баланс счета\n2: Снять со счета\n3: Положить на счет\n4: Выйти");
                        int choice = in.nextInt();

                        switch (choice) {
                            case 1: // Проверка баланса
                                System.out.printf("Баланс счета %d: %.2f\n", id, currentAccount.getBalance());
                                break;
                            case 2: // Снятие со счета
                                System.out.println("Введите сумму для снятия:");
                                double amountWithdraw = in.nextDouble();
                                currentAccount.withdraw(amountWithdraw);
                                break;
                            case 3: // Пополнение счета
                                System.out.println("Введите сумму для пополнения:");
                                double amountDeposit = in.nextDouble();
                                currentAccount.deposit(amountDeposit);
                                break;
                            case 4: // Выход из меню
                                exitMenu = true;
                                break;
                            default:
                                System.out.println("Неверная команда! Пожалуйста, выберите 1, 2, 3 или 4.");
                        }
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage() + " Попробуйте еще раз.");
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Введите корректный ID!");
                    in.next();
                }
            }
        }
    }
}











