package com.sergeykarpen.crudconsole.controller;

import com.sergeykarpen.crudconsole.model.Developer;
import com.sergeykarpen.crudconsole.model.Skill;
import com.sergeykarpen.crudconsole.repository.DeveloperRepository;
import com.sergeykarpen.crudconsole.repository.io.JavaIODeveloperRepositoryImpl;

import java.io.IOException;
import java.util.List;

public class DeveloperController {

    DeveloperRepository repoDeveloper = new JavaIODeveloperRepositoryImpl();

    public DeveloperController() {
        this.repoDeveloper = repoDeveloper;
    }

    public void save(String name) {
        Developer d = new Developer();
        d.setName(name);
        repoDeveloper.save(d);
    }

    public void update(Long id, String name) throws IOException {
        Developer d = new Developer();
        d.setName(name);
        d.setId(id);
        repoDeveloper.update(d);
    }

    public Developer getById(Long id) throws IOException {
        return repoDeveloper.getById(id);
    }

    public void delete(Long id) throws IOException {
        repoDeveloper.deleteById(id);
    }

    public List<Developer> getAll() throws IOException {
        return repoDeveloper.getAll();
    }

}
