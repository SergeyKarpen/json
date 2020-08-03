package com.sergeykarpen.crudconsole.controller;

import com.sergeykarpen.crudconsole.model.Skill;
import com.sergeykarpen.crudconsole.repository.SkillRepository;
import com.sergeykarpen.crudconsole.repository.io.JavaIOSkillRepositoryImpl;

import java.io.IOException;
import java.util.List;

public class SkillController {

    private SkillRepository repo = new JavaIOSkillRepositoryImpl();

    public SkillController() {
        this.repo = repo;
    }

    public void save(String name) {
        Skill s = new Skill();
        s.setName(name);
        repo.save(s);
    }

    public void update(Long id, String name) throws IOException {
        Skill s = new Skill();
        s.setName(name);
        s.setId(id);
        repo.update(s);
    }

    public Skill getById(Long id) throws IOException {
        return repo.getById(id);
    }

    public void delete(Long id) throws IOException {
        repo.deleteById(id);
    }

    public List<Skill> getAll() {
        return repo.getAll();
    }
}
