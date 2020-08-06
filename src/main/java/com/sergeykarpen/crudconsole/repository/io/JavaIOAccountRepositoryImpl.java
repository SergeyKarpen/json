package com.sergeykarpen.crudconsole.repository.io;

import com.sergeykarpen.crudconsole.model.Account;
import com.sergeykarpen.crudconsole.repository.AccountRepository;

import java.io.IOException;
import java.util.List;

public class JavaIOAccountRepositoryImpl implements AccountRepository {
    @Override
    public Account save(Account account) {
        return null;
    }

    @Override
    public Account update(Account account) throws IOException {
        return null;
    }

    @Override
    public List<Account> getAll() throws IOException {
        return null;
    }

    @Override
    public Account getById(Long aLong) throws IOException {
        return null;
    }

    @Override
    public void deleteById(Long aLong) throws IOException {

    }

    @Override
    public List<Account> convertStringsToObjects(List<String> input) throws IOException {
        return null;
    }

    @Override
    public List<String> convertObjectsToStrings(List<Account> input) throws IOException {
        return null;
    }

    @Override
    public String convertObjectToString(Account account) throws IOException {
        return null;
    }
}
