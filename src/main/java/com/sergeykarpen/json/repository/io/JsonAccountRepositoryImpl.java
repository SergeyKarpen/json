package com.sergeykarpen.json.repository.io;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sergeykarpen.json.model.Account;
import com.sergeykarpen.json.model.Developer;
import com.sergeykarpen.json.model.Skill;
import com.sergeykarpen.json.repository.AccountRepository;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.sergeykarpen.json.util.IOUtil.getPathToFile;

public class JsonAccountRepositoryImpl implements com.sergeykarpen.json.repository.AccountRepository {

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
        return getListObjectsFromJson(relativePathToFile);
    }

    @Override
    public Account getById(Long id) throws IOException {
        List<Account> accounts = getListObjectsFromJson(relativePathToFile);
        return accounts.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public void deleteById(Long id) throws IOException {
        List<Account> accounts = getListObjectsFromJson(relativePathToFile)
                .stream()
                .filter(p -> !p.getId().equals(id)).collect(Collectors.toList());
        writeListObjectsInJson(accounts, getPathToFile(relativePathToFile));
    }

    @Override
    public List<Account> getListObjectsFromJson(String pathFile) throws IOException {
        Gson gson = new Gson();
        List<Account> list;
        try (FileReader reader = new FileReader(pathFile)) {
            list = gson.fromJson(reader, new TypeToken<ArrayList<Account>>() {
            }.getType());
            return list;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    @Override
    public void writeListObjectsInJson(List<Account> accounts, String fileName) throws IOException {
        FileWriter writer = null;
        try {
            writer = new FileWriter(getPathToFile(fileName), false);
        } catch (IOException e) {
            e.printStackTrace();
        }
        new Gson().toJson(accounts, writer);
        try {
            assert writer != null;
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Long maxIdInList(List<Account> t) throws IOException {
        return null;
    }
}
