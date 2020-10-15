package com.sergeykarpen.json.controller;

import com.sergeykarpen.json.model.Account;
import com.sergeykarpen.json.model.AccountStatus;
import com.sergeykarpen.json.model.Developer;
import com.sergeykarpen.json.repository.DeveloperRepository;
import com.sergeykarpen.json.repository.io.JsonAccountRepositoryImpl;
import com.sergeykarpen.json.repository.io.JsonDeveloperRepositoryImpl;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public class DeveloperController {

    private DeveloperRepository developerRepository = new JsonDeveloperRepositoryImpl();
    private JsonAccountRepositoryImpl accountRepository = new JsonAccountRepositoryImpl();

    private final static String relativePathToFile = "src\\main\\resources\\developers.json";

    public void update(Long id, String name, Long accountId, String upStatus, Set<Long> skillIds) throws Exception {
        Developer developer = new Developer();
        Account account = new Account();
        account.setId(accountId);
        account.setName(accountRepository.getById(id).getName());
        account.setAccountStatus(AccountStatus.valueOf(upStatus));
        developer.setAccount(account);
        developer.setId(id);
        developer.setName(name);
        developer.setSkillIds(skillIds);
        developerRepository.update(developer);
    }

    public void deleteById(Long id) throws IOException {
        developerRepository.deleteById(id);
    }

    public void create(String nameDeveloper, Long accountId, String status, Set<Long> skillIds) throws Exception {
        Developer developer = new Developer();
        Account account = new Account();
        account.setId(accountId);
        account.setName(accountRepository.getById(accountId).getName());
        account.setAccountStatus(AccountStatus.valueOf(status));
        developer.setAccount(account);
        developer.setName(nameDeveloper);
        developer.setId(developerRepository.maxIdInList(developerRepository.getListObjectsFromJson(relativePathToFile)));
        developer.setSkillIds(skillIds);
        developerRepository.create(developer);
    }

    public List<Developer> getAll() throws IOException {
        return developerRepository.getAll();
    }
}
