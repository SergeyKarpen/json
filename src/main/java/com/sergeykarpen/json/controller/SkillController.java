package com.sergeykarpen.json.controller;

import com.sergeykarpen.json.model.Skill;
import com.sergeykarpen.json.repository.SkillRepository;
import com.sergeykarpen.json.repository.io.JsonSkillRepositoryImpl;

import java.io.IOException;
import java.util.List;

public class SkillController {

    private SkillRepository skillRepository = new JsonSkillRepositoryImpl();
    private final static String relativePathToFile = "src\\main\\resources\\skills.json";

    public void create(String name) throws IOException {
        Skill s = new Skill();
        s.setName(name);
        s.setId(skillRepository.maxIdInList(skillRepository.getListObjectsFromJson(relativePathToFile))+1);
        skillRepository.create(s);
    }

    public void update(Long id, String name) throws IOException {
        Skill s = new Skill();
        s.setName(name);
        s.setId(id);
        skillRepository.update(s);
    }

    public Skill getById(Long id) throws IOException {
        return skillRepository.getById(id);
    }

    public void deleteById(Long id) throws IOException {
        skillRepository.deleteById(id);
    }

    public List<Skill> getAll() throws IOException {
      return skillRepository.getAll();
    }
}
