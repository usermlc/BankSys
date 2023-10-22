package com.await.systembank.ui;

import com.await.systembank.bl.*;
import com.await.systembank.da.entity.Account;

import java.util.Scanner;

public class Menu {

    public static void startMenu(Account userName) {

        int mainMenu;
        Scanner mainInput = new Scanner(System.in);
        do {
            System.out.println("Вітаємо в банківській системі Monobank");
            System.out.println("[1] Переглянути дані карти");
            System.out.println("[2] Депозит на карту");
            System.out.println("[3] Зняти кошти");
            System.out.println("[4] Придбати товар");
            System.out.println("[5] Історія транзакцій");
            System.out.println("[6] Змінити акаунт");
            System.out.println("[7] Вийти з програми");

            mainMenu = mainInput.nextInt();
            switch (mainMenu) {
                case 1:
                    ViewCard.viewInMenu(userName);
                    break;
                case 2:
                    Deposit.deposit(userName);
                    break;
                case 3:
                    Withdraw.withdraw(userName);
                    break;
                case 4:
                    BuyGoods.buyGoods(userName);
                    break;
                case 5:
                    ViewTransaction.viewTransaction(userName);
                    break;
                case 6:
                    Logout.logout(userName);
                    break;
                case 7:
                    System.out.println("Дякуємо що скористалися нашими послугами");
                    System.exit(7);
                    break;
            }

            System.out.println(userName.cardList.get(0).getAmount());
        } while (mainMenu != 7);
    }
}