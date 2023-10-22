package com.await.systembank.bl;

import com.await.systembank.da.GoodsList;
import com.await.systembank.da.entity.Account;
import com.await.systembank.da.entity.Goods;
import com.await.systembank.da.entity.TransactionHistory;
import com.await.systembank.ui.Menu;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class BuyGoods {
    public static void buyGoods(Account userName) {
        GoodsList goodsList = new GoodsList();

        System.out.println("Виберіть карту для роботи з нею: ");
        System.out.println("[1] " + "Номер карти: " + userName.cardList.get(0).getNumber() + "\n" +
            "Баланс: " + userName.cardList.get(0).getAmount() + "₴" + "\n" +
            "[2] " + "Номер карти: " + userName.cardList.get(1).getNumber() + "\n" +
            "Баланс: " + userName.cardList.get(1).getAmount() + "$" + "\n");

        Scanner choiceCard = new Scanner(System.in);
        int cardChoice = choiceCard.nextInt();

        Double courseDollar = 36.74;

        int id = -1;
        System.out.println("Виберіть товар який хочете придбати: ");
        for (Goods goods: goodsList.getGoods()) {
            id++;
            System.out.println("[" + id + "] Назва товару: " + goods.name + "\n" + "Ціна товару: " + goods.price + "₴");
        }
        Scanner userChoice = new Scanner(System.in);
        int choice = userChoice.nextInt();

        String nameGoods = goodsList.getGoods().get(choice).getName();

        Double priceGoods = goodsList.getGoods().get(choice).getPrice();

        System.out.println("Введіть кількість: ");
        Scanner countBuy = new Scanner(System.in);
        int count = countBuy.nextInt();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");


        if (cardChoice == 1) {

            if (userName.cardList.get(0).getAmount() > priceGoods * count) {

                userName.cardList.get(0).setAmount(userName.cardList.get(0).getAmount() -
                    priceGoods * count);

                String transaction = "Корисутвач: " + userName.getOwner() + "\n Номер карти: " +
                    userName.cardList.get(0).getNumber() +
                    "\n Купив/ла: " + nameGoods + "\n Кількість: " + count + "\n Ціна: " + priceGoods * count + "₴" +
                    " Ціна одиниці: " + priceGoods + "₴" +
                    "\n Дата: " + dtf.format(LocalDateTime.now()) +
                    "\n Залишилось на балансі: " + userName.cardList.get(0).getAmount() + "₴";

                TransactionHistory.getInstance().setTransaction(transaction);

                System.out.println("Ви успішно придбали товар");
                System.out.println(transaction);
                System.out.println();

            } else if (userName.cardList.get(0).getAmount() < goodsList.getGoods().get(choice).getPrice() * count) {
                System.out.println("На карті не вистачає коштів");
            }

            Menu.startMenu(userName);

        } else if (cardChoice == 2) {

            if (userName.cardList.get(1).getAmount() > (priceGoods * count) % courseDollar) {

                userName.cardList.get(1).setAmount(userName.cardList.get(1).getAmount() -
                    (priceGoods * count) / courseDollar);

                String transaction = "Корисутвач: " + userName.getOwner() + "\n Номер карти: " + userName.cardList.get(1).getNumber() +
                    "\n Купив/ла: " + nameGoods + "\n Кількість: " + count + "\n Ціна: " +
                    Math.round(((priceGoods * count) / courseDollar) * 100.0) / 100.0 + "$" +
                    " Ціна одиниці: " + Math.round(((double) priceGoods / courseDollar) * 100.0) / 100.0 + "$ " +
                    "\n Дата: " + dtf.format(LocalDateTime.now()) +
                    "\n Залишилось на балансі: " + Math.round((userName.cardList.get(1).getAmount() * 100.0) / 100.0) + "$";

                TransactionHistory.getInstance().setTransaction(transaction);


                System.out.println("Ви успішно придбали товар");
                System.out.println(transaction);
                System.out.println();

            } else if (userName.cardList.get(1).getAmount() < priceGoods * count) {
                System.out.println("На карті не вистачає коштів");
            }

            Menu.startMenu(userName);
        } else if (cardChoice > 2) {
            System.out.println("Карти під даним номером, не існує");
            Menu.startMenu(userName);
        }
    }
}