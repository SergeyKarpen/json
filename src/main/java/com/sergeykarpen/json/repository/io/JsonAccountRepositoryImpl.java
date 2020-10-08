package com.sergeykarpen.json.repository.io;

import com.sergeykarpen.json.model.Account;
import com.sergeykarpen.json.repository.AccountRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.sergeykarpen.json.util.IOUtil.getPathToFile;
import static com.sergeykarpen.json.util.IOUtil.readFile;

public class JsonAccountRepositoryImpl implements AccountRepository {

    private final static String relativePathToFile = "src\\main\\resources\\accounts.json";

    @Override
    public Account save(Account account) {
        return null;
    }

    @Override
    public Account update(Account account) {
        return null;
    }

    @Override
    public Map<Long, Account> getAll() throws IOException {
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
    public List<Account> convertStringsToObjects(List<String> input) {
        List<Account> resultList = new ArrayList<>();
        for (String acc : input) {
            String[] splitedString = acc.split(",");
            Account myAcc = new Account();
            myAcc.setId((long) Integer.parseInt(splitedString[0]));
            myAcc.setName(splitedString[1]);
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
