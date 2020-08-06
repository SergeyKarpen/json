package com.sergeykarpen.crudconsole.controller;

import com.sergeykarpen.crudconsole.model.Developer;
import com.sergeykarpen.crudconsole.repository.DeveloperRepository;
import com.sergeykarpen.crudconsole.repository.io.JavaIODeveloperRepositoryImpl;

import java.io.IOException;
import java.util.List;

public class DeveloperController {

    private DeveloperRepository developerRepository = new JavaIODeveloperRepositoryImpl();

    public DeveloperController() {
        this.developerRepository = developerRepository;
    }

    public void save(String name) {
        Developer d = new Developer();
        d.setName(name);
        developerRepository.save(d);
    }

    public void update(Long id, String name) throws IOException {
        Developer d = new Developer();
        d.setName(name);
        d.setId(id);
        developerRepository.update(d);
    }

    public Developer getById(Long id) throws IOException {
        return developerRepository.getById(id);
    }

    public void delete(Long id) throws IOException {
        developerRepository.deleteById(id);
    }

    public List<Developer> getAll() throws IOException {
        return developerRepository.getAll();
    }

}
