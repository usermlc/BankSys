package com.await.systembank.bl;

import com.await.systembank.da.entity.Account;
import com.await.systembank.ui.Menu;

public class ViewCard {
    public static void view(Account userName) {
        System.out.println("Виберіть карту для роботи з нею: ");
        System.out.println("[1] " + "Номер карти: " + userName.cardList.get(0).getNumber() + "\n" +
            "Баланс: " + userName.cardList.get(0).getAmount() + "₴" + "\n" +
            "[2] " + "Номер карти: " + userName.cardList.get(1).getNumber() + "\n" +
            "Баланс: " + userName.cardList.get(1).getAmount() + "$" + "\n");
        Menu.startMenu(userName);
    }

    public static void viewInMenu(Account userName) {
        System.out.println("[1] " + "Номер карти: " + userName.cardList.get(0).getNumber() + "\n" +
            "Баланс: " + userName.cardList.get(0).getAmount() + "₴" + "\n" +
            "[2] " + "Номер карти: " + userName.cardList.get(1).getNumber() + "\n" +
            "Баланс: " + userName.cardList.get(1).getAmount() + "$" + "\n");
        Menu.startMenu(userName);
    }

}