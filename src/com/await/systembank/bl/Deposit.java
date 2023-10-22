package com.await.systembank.bl;

import com.await.systembank.da.entity.Account;
import com.await.systembank.da.entity.TransactionHistory;
import com.await.systembank.ui.Menu;

import java.util.Scanner;

public class Deposit {
    public static void deposit(Account userName) {
        System.out.println("Виберіть карту для роботи з нею: ");
        System.out.println("[1] " + "Номер карти: " + userName.cardList.get(0).getNumber() + "\n" +
            "Баланс: " + userName.cardList.get(0).getAmount() + "₴" + "\n" +
            "[2] " + "Номер карти: " + userName.cardList.get(1).getNumber() + "\n" +
            "Баланс: " + Math.round((userName.cardList.get(1).getAmount() * 100.0) / 100.0) + "$" + "\n");

        Scanner choiceCard = new Scanner(System.in);
        int cardChoice = choiceCard.nextInt();

        System.out.println("Введіть суму депозиту: ");
        Scanner inputDeposit = new Scanner(System.in);
        Double deposit = inputDeposit.nextDouble();

        if (cardChoice == 1) {

            userName.cardList.get(0).setAmount(userName.cardList.get(0).getAmount() + deposit);

            String transaction = "Користувач: " + userName.getOwner() + " Поповнив карту (" + userName.cardList.get(0).getNumber() + ") на: " + deposit + "₴";


            TransactionHistory.getInstance().setTransaction(transaction);

            System.out.println("Баланс поповнено, на: " + deposit + "₴");

            Menu.startMenu(userName);

        } else if (cardChoice == 2) {

            userName.cardList.get(1).setAmount(userName.cardList.get(1).getAmount() + deposit);

            String transaction = "Користувач: " + userName.getOwner() + " Поповнив карту (" + userName.cardList.get(1).getNumber() + ") на: " + deposit + "$";

            TransactionHistory.getInstance().setTransaction(transaction);

            System.out.println("Баланс поповнено, на: " + deposit + "$");

            Menu.startMenu(userName);
        } else if (cardChoice > 2) {
            System.out.println("Карти під даним номером, не існує");
            Menu.startMenu(userName);
        }

    }
}