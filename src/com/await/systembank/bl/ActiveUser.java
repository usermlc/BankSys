package com.await.systembank.bl;

import com.await.systembank.da.AccountList;
import com.await.systembank.da.entity.Account;
import com.await.systembank.ui.Menu;

import java.util.Scanner;

public class ActiveUser {

    public static void user() {
        AccountList accountList = new AccountList();

        Account userName = null;

        System.out.println("Виберіть карту для роботи з нею: \n");

        System.out.println("[1] Власник карти: " + accountList.mishaAccount.getOwner() + "\n" +
            "Номер карти: " + accountList.mishaAccount.cardList.get(0).getNumber() +
            " Сума на карті: " + accountList.mishaAccount.cardList.get(0).getAmount() + "₴" + "\n" +
            "Номер карти: " + accountList.mishaAccount.cardList.get(1).getNumber() +
            " Сума на карті: " + accountList.mishaAccount.cardList.get(1).getAmount() + "$");

        System.out.println();

        System.out.println("[2] Власник карти: " + accountList.vasyaAccount.getOwner() + "\n" +
            "Номер карти: " + accountList.vasyaAccount.cardList.get(0).getNumber() +
            " Сума на карті: " + accountList.vasyaAccount.cardList.get(0).getAmount() + "₴" + "\n" +
            "Номер карти: " + accountList.vasyaAccount.cardList.get(1).getNumber() +
            " Сума на карті: " + accountList.vasyaAccount.cardList.get(1).getAmount() + "$");

        Scanner userChoice = new Scanner(System.in);
        int userActive = userChoice.nextInt();

        if (userActive == 1) {
            userName = accountList.getMishaAccount();

        } else if (userActive == 2) {
            userName = accountList.getVasyaAccount();
        }
        Menu.startMenu(userName);
    }
}