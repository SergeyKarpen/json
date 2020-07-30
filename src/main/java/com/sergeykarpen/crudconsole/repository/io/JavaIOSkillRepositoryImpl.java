package com.sergeykarpen.crudconsole.repository.io;


import com.sergeykarpen.crudconsole.model.Skill;
import com.sergeykarpen.crudconsole.repository.SkillRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.sergeykarpen.crudconsole.util.IOUtil.*;

public class JavaIOSkillRepositoryImpl implements SkillRepository {

    public static final String pathToSkillFile = "src\\main\\resources\\skills.txt";

    public List<Skill> getAll(){
        try {
            return convertStringToSkillArray(readFile(pathToSkillFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Skill getById(Long id) {
        Skill needSkillById = new Skill();
        try {
            for (Skill needSkill : convertStringToSkillArray(readFile(pathToSkillFile))) {
                if (needSkill.getId().equals(id)) {
                    needSkillById = needSkill;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return needSkillById;
    }

    public Skill save(Skill skill) {
        List<Skill> newSkills = null;
        try {
            newSkills = new ArrayList<>(convertStringToSkillArray(readFile(pathToSkillFile)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Skill saveSkill = new Skill();
        saveSkill.setName(skill.getName());
        saveSkill.setId((long) (newSkills.size() + 1));
        newSkills.add(saveSkill);
        writeInFile("", "");
        return null;
    }

    public void deleteById(Long id) {
        List<Skill> newSkills = null;
        try {
            newSkills = new ArrayList<>(convertStringToSkillArray(readFile(pathToSkillFile)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Skill s : newSkills) {
            if (s.getId().equals(id)) {
                s.setName(null);
            }
        }
        writeInFile("", "");
    }

    public Skill update(Skill skill) {
        List<Skill> newSkills = null;
        try {
            newSkills = new ArrayList<>(convertStringToSkillArray(readFile(pathToSkillFile)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Skill s : newSkills) {
            if (s.getId().equals(skill.getId())) {
                s.setName(skill.getName());
            }
        }
        writeInFile("", "");
        return null;
    }
}
