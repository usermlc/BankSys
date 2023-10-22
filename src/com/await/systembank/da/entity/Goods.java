package com.await.systembank.da.entity;

public class Goods {
    public String name;
    public Double price;

    public Goods(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }
}