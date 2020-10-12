package com.sergeykarpen.json.repository.io;

import com.sergeykarpen.json.model.Account;
import com.sergeykarpen.json.repository.AccountRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonAccountRepositoryImpl implements AccountRepository {

    private final static String relativePathToFile = "src\\main\\resources\\accounts.json";

    @Override
    public Account create(Account account) {
        return null;
    }

    @Override
    public Account update(Account account) {
        return null;
    }

    @Override
    public List<Account> getAll() throws IOException {
        return null;
    }

    @Override
    public Account getById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
    }

    @Override
    public List<Account> getListObjectsFromJson(String s) throws IOException {
        return null;
    }

    @Override
    public void writeListObjectsInJson(List<Account> list, String s) throws IOException {

    }

    @Override
    public Long maxIdInList(List<Account> t) throws IOException {
        return null;
    }
}
