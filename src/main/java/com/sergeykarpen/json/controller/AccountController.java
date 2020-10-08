package com.sergeykarpen.json.controller;

import com.sergeykarpen.json.model.Account;
import com.sergeykarpen.json.repository.AccountRepository;
import com.sergeykarpen.json.repository.io.JsonAccountRepositoryImpl;

import java.io.IOException;
import java.util.List;

public class AccountController {
    AccountRepository accountRepository = new JsonAccountRepositoryImpl();

    public AccountController() {
        this.accountRepository = accountRepository;
    }

    public  Account getById(Long id) throws IOException {
        return accountRepository.getById(id);
    }

}

