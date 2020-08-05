package com.sergeykarpen.crudconsole.controller;

import com.sergeykarpen.crudconsole.model.Skill;
import com.sergeykarpen.crudconsole.repository.SkillRepository;
import com.sergeykarpen.crudconsole.repository.io.JavaIOSkillRepositoryImpl;

import java.io.IOException;
import java.util.List;

public class SkillController {

    private SkillRepository repoSkill = new JavaIOSkillRepositoryImpl();

    public SkillController() {
        this.repoSkill = repoSkill;
    }

    public void save(String name) {
        Skill s = new Skill();
        s.setName(name);
        repoSkill.save(s);
    }

    public void update(Long id, String name) throws IOException {
        Skill s = new Skill();
        s.setName(name);
        s.setId(id);
        repoSkill.update(s);
    }

    public Skill getById(Long id) throws IOException {
        return repoSkill.getById(id);
    }

    public void delete(Long id) throws IOException {
        repoSkill.deleteById(id);
    }

    public List<Skill> getAll() throws IOException {
        return repoSkill.getAll();
    }
}
