package com.await.systembank.da;

import com.await.systembank.da.entity.Goods;

import java.util.ArrayList;
import java.util.List;

public class GoodsList {

    private List < Goods > goods = new ArrayList < > ();

    public GoodsList() {
        goods.add(new Goods("Макарони", 30.0));
        goods.add(new Goods("Лужанська", 17.0));
        goods.add(new Goods("Кіндер", 35.0));
        goods.add(new Goods("Мілка", 42.0));
        goods.add(new Goods("Хліб", 20.0));
    }

    public List < Goods > getGoods() {
        return goods;
    }
}