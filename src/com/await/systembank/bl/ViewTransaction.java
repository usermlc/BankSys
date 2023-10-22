package com.await.systembank.bl;

import com.await.systembank.da.entity.Account;
import com.await.systembank.da.entity.TransactionHistory;
import com.await.systembank.ui.Menu;

public class ViewTransaction {
    public static void viewTransaction(Account userName) {
        int i = 0;
        for (String s: TransactionHistory.getInstance().getTransaction()) {
            i++;
            System.out.println(i + " " + s);
            System.out.println("___________________________________________________");
        }
        Menu.startMenu(userName);
    }
}