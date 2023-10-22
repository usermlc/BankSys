package com.await.systembank.bl;

import com.await.systembank.da.entity.Account;
import com.await.systembank.da.entity.TransactionHistory;
import com.await.systembank.ui.Menu;

import java.util.Scanner;

public class Withdraw {
    public static void withdraw(Account userName) {
        try {
            System.out.println("Виберіть карту для роботи з нею: ");
            System.out.println("[1] " + "Номер карти: " + userName.cardList.get(0).getNumber() + "\n" +
                "Баланс: " + userName.cardList.get(0).getAmount() + "₴" + "\n" +
                "[2] " + "Номер карти: " + userName.cardList.get(1).getNumber() + "\n" +
                "Баланс: " + Math.round((userName.cardList.get(1).getAmount() * 100.0) / 100.0) + "$" + "\n");

            Scanner choiceCard = new Scanner(System.in);
            int cardChoice = choiceCard.nextInt();

            System.out.println("Введіть суму яку хочете зняти: ");
            Scanner inputDeposit = new Scanner(System.in);
            Double withdraw = inputDeposit.nextDouble();

            if (cardChoice == 1) {

                if (userName.cardList.get(0).getAmount() < withdraw) {
                    System.out.println("На карті не достатньо коштів");
                } else {
                    userName.cardList.get(0).setAmount(userName.cardList.get(0).getAmount() - withdraw);

                    String transaction = "Користувач: " + userName.getOwner() + " Зняв з карти: (" + userName.cardList.get(0).getNumber() + "): " + withdraw + "₴";

                    TransactionHistory.getInstance().setTransaction(transaction);

                    System.out.println("Кошти успішно знято");

                    Menu.startMenu(userName);
                }

                Menu.startMenu(userName);

            } else if (cardChoice == 2) {

                if (userName.cardList.get(1).getAmount() < withdraw) {
                    System.out.println("На карті не достатньо коштів");
                } else {

                    userName.cardList.get(1).setAmount(userName.cardList.get(1).getAmount() - withdraw);

                    String transaction = "Користувач: " + userName.getOwner() + " Зняв з карти: (" + userName.cardList.get(1).getNumber() + "): " + withdraw + "$";

                    TransactionHistory.getInstance().setTransaction(transaction);

                    System.out.println("Кошти успішно знято");

                    Menu.startMenu(userName);
                }

                Menu.startMenu(userName);

            } else if (cardChoice > 2) {
                System.out.println("Карти під даним номером, не існує");
                Menu.startMenu(userName);
            }
        } catch (Exception e) {
            System.out.println("Виникла помилка");
        }
    }
}