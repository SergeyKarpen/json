package com.sergeykarpen.json.controller;

import com.sergeykarpen.json.addition.AdditionDeveloper;
import com.sergeykarpen.json.model.Developer;
import com.sergeykarpen.json.repository.DeveloperRepository;
import com.sergeykarpen.json.repository.io.JsonDeveloperRepositoryImpl;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public class DeveloperController {

    private DeveloperRepository developerRepository = new JsonDeveloperRepositoryImpl();
    public AdditionDeveloper additionDeveloper = new AdditionDeveloper();

    public void updateAll(Long id, String name, String accountStatus, Long accountId, Set<Long> skillIds) throws Exception {
        additionDeveloper.updateAll(id, name, accountStatus, accountId, skillIds);
    }

    public void deleteById(Long id) throws IOException {
        developerRepository.deleteById(id);
    }

    public void create(String name, String accountStatus, Long accountId, Set<Long> skillIds) throws Exception {
        Developer developer = new Developer();
        developer.setName(name);
        developer.setAccountStatus(accountStatus);
        developer.setAccountId(accountId);
        developer.setSkillIds(skillIds);
        developerRepository.create(developer);
    }


}
