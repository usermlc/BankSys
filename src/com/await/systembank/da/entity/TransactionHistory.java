package com.await.systembank.da.entity;

import java.util.ArrayList;
import java.util.List;

public class TransactionHistory {

    private static TransactionHistory instance;

    private List < String > transaction = new ArrayList < > ();

    public List < String > getTransaction() {
        return transaction;
    }

    public void setTransaction(String transaction) {
        this.transaction.add(transaction);
    }

    public void clearTransaction() {
        this.transaction.clear();
    }

    public static TransactionHistory getInstance() {
        if (instance == null) {
            instance = new TransactionHistory();
        }
        return instance;
    }

    private TransactionHistory() {

    }
}