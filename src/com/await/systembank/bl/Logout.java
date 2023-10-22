package com.await.systembank.bl;

import com.await.systembank.da.entity.Account;
import com.await.systembank.da.entity.TransactionHistory;
import com.await.systembank.ui.Menu;

import java.util.Scanner;

public class Logout {
    public static void logout(Account userName) {
        System.out.println("Ви хочете вийти з акаунту? \n [1] Так \n [2] Ні");

        Scanner userChoice = new Scanner(System.in);
        int choice = userChoice.nextInt();

        if (choice == 1) {
            TransactionHistory.getInstance().clearTransaction();
            System.out.println("Ви успішно вийшли");
            ActiveUser.user();
        } else if (choice == 2) {
            Menu.startMenu(userName);
        }
    }
}