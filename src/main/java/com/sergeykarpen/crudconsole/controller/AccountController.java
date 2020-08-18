package com.sergeykarpen.crudconsole.controller;

import com.sergeykarpen.crudconsole.model.Account;
import com.sergeykarpen.crudconsole.repository.AccountRepository;
import com.sergeykarpen.crudconsole.repository.io.JavaIOAccountRepositoryImpl;

import java.io.IOException;
import java.util.List;

public class AccountController {
    AccountRepository accountRepository = new JavaIOAccountRepositoryImpl();

    public AccountController() {
        this.accountRepository = accountRepository;
    }

    public List<Account> getAll() throws IOException {
        return accountRepository.getAll();
    }

    public  Account getById(Long id) throws IOException {
        return accountRepository.getById(id);
    }

}

