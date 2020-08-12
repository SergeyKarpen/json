package com.sergeykarpen.crudconsole.controller;

import com.sergeykarpen.crudconsole.addition.AdditionDeveloper;
import com.sergeykarpen.crudconsole.model.AccountStatus;
import com.sergeykarpen.crudconsole.model.Developer;
import com.sergeykarpen.crudconsole.repository.DeveloperRepository;
import com.sergeykarpen.crudconsole.repository.io.JavaIODeveloperRepositoryImpl;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public class DeveloperController {

    private DeveloperRepository developerRepository = new JavaIODeveloperRepositoryImpl();
    public AdditionDeveloper additionDeveloper = new AdditionDeveloper();


    // TODO: 11.08.2020
    public void create(String name, AccountStatus accountStatus, Long accountId, Set<Long> skillIds) throws Exception {
        additionDeveloper.create(name, accountStatus, accountId, skillIds);
    }

    public void update(Long id, String name) throws IOException {
        Developer d = new Developer();
        d.setName( name );
        d.setId( id );
        developerRepository.update( d );
    }

    public Developer getById(Long id) throws IOException {
        return developerRepository.getById( id );
    }

    public void delete(Long id) throws IOException {
        developerRepository.deleteById( id );
    }

    public List<Developer> getAll() throws IOException {
        return developerRepository.getAll();
    }

}
