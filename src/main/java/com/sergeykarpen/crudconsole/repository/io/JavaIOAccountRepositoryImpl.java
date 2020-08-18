package com.sergeykarpen.crudconsole.repository.io;

import com.sergeykarpen.crudconsole.model.Account;
import com.sergeykarpen.crudconsole.repository.AccountRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.sergeykarpen.crudconsole.util.IOUtil.getPathToFile;
import static com.sergeykarpen.crudconsole.util.IOUtil.readFile;

public class JavaIOAccountRepositoryImpl implements AccountRepository {

    private final static String relativePathToFile = "src\\main\\resources\\accounts.txt";

    @Override
    public Account save(Account account) {
        return null;
    }

    @Override
    public Account update(Account account) {
        return null;
    }

    @Override
    public List<Account> getAll() throws IOException {
        return convertStringsToObjects(readFile((getPathToFile(relativePathToFile))));
    }

    @Override
    public Account getById(Long id) {
        Account needAccountById = new Account();
        try {
            for (Account needAccount : convertStringsToObjects(readFile((getPathToFile(relativePathToFile))))) {
                if (needAccount.getId().equals(id)) {
                    needAccountById = needAccount;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return needAccountById;
    }

    @Override
    public void deleteById(Long id) {
    }

    @Override
    public List<Account> convertStringsToObjects(List<String> input) {
        List<Account> resultList = new ArrayList<>();
        for (String acc : input) {
            String[] splitedString = acc.split(",");
            Account myAcc = new Account();
            myAcc.setId((long) Integer.parseInt(splitedString[0]));
            myAcc.setData(splitedString[1]);
            resultList.add(myAcc);
        }
        return resultList;
    }

    @Override
    public List<String> convertObjectsToStrings(List<Account> input) {
        List<String> listStrings = new ArrayList<>();
        for (Account a : input) {
            listStrings.add(convertObjectToString(a));
        }
        return listStrings;
    }

    @Override
    public String convertObjectToString(Account account) {
        return account.toString();
    }
}
