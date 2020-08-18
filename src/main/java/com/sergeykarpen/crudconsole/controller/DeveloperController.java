package com.sergeykarpen.crudconsole.controller;

import com.sergeykarpen.crudconsole.addition.AdditionDeveloper;
import com.sergeykarpen.crudconsole.model.Developer;
import com.sergeykarpen.crudconsole.repository.DeveloperRepository;
import com.sergeykarpen.crudconsole.repository.io.JavaIODeveloperRepositoryImpl;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public class DeveloperController {

    private DeveloperRepository developerRepository = new JavaIODeveloperRepositoryImpl();
    public AdditionDeveloper additionDeveloper = new AdditionDeveloper();


    public void create(String name, String accountStatus, Long accountId, Set<Long> skillIds) throws Exception {
        additionDeveloper.create(name, accountStatus, accountId, skillIds);
    }

    public void updateAll (Long id, String name, String accountStatus, Long accountId, Set<Long> skillIds) throws Exception {
        additionDeveloper.updateAll (id, name, accountStatus, accountId, skillIds);
    }

    public void deleteById(Long id) throws IOException {
        developerRepository.deleteById(id);
    }

    public List<Developer> getAll() throws IOException {
        return developerRepository.getAll();
    }

}
