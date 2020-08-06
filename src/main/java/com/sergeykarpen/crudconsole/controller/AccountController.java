package com.sergeykarpen.crudconsole.controller;

import com.sergeykarpen.crudconsole.model.Account;
import com.sergeykarpen.crudconsole.model.AccountStatus;
import com.sergeykarpen.crudconsole.repository.AccountRepository;
import com.sergeykarpen.crudconsole.repository.io.JavaIOAccountRepositoryImpl;

import java.util.List;

public class AccountController {
    AccountRepository accountRepository = new JavaIOAccountRepositoryImpl();

    public AccountController() {
        this.accountRepository = accountRepository;
    }


    public void save (String name, AccountStatus accountStatus, List<Long> skillIds) {

    }
}
