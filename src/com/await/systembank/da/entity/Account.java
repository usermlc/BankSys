package com.await.systembank.da.entity;

import java.util.ArrayList;
import java.util.List;

public class Account {
    public List < Card > cardList = new ArrayList < > ();
    private String owner;

    public Account(List < Card > cardList, String owner) {
        this.cardList = cardList;
        this.owner = owner;
    }

    public List < Card > getCardList() {
        return cardList;
    }

    public void setCardList(List < Card > cardList) {
        this.cardList = cardList;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    private List < Card > addCard(Card card) {
        this.cardList.add(card);
        return this.cardList;
    }
    public static class Card {
        public double amount;
        private String number;

        public Card(String number, double amount) {
            this.amount = amount;
            this.number = number;
        }

        public Card(String number) {
            this.amount = 0;
            this.number = number;
        }

        public double getAmount() {
            return amount;
        }

        public String getNumber() {
            return number;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public void setNumber(String number) {
            this.number = number;
        }
    }
}