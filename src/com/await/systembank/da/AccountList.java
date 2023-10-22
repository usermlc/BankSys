package com.await.systembank.da;

import com.await.systembank.da.entity.Account;

import java.util.ArrayList;
import java.util.Arrays;

public class AccountList {

    public Account vasyaAccount = new Account(
        new ArrayList < > (Arrays.asList(
            new Account.Card("5168 7529 7478 4236", 250),
            new Account.Card("4149 4923 5478 2346", 1250))), "Vasya");

    public Account mishaAccount = new Account(
        new ArrayList < > (Arrays.asList(
            new Account.Card("5168 7529 3457 7458", 2600),
            new Account.Card("4149 2364 3468 5348", 200))), "Misha");

    public Account getVasyaAccount() {
        return vasyaAccount;
    }

    public Account getMishaAccount() {
        return mishaAccount;
    }
}