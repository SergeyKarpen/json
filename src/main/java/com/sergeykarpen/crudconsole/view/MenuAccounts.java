package com.sergeykarpen.crudconsole.view;

import com.sergeykarpen.crudconsole.model.Account;

import java.io.IOException;
import java.util.List;

public class MenuAccounts {
    //TODO написать вью для Accounts
    public void showMenuAccounts () throws IOException {};

    public static void printAll(List<Account> list) {
        for (Account a : list) {
            System.out.print( a.toString() );
        }
    }
}
