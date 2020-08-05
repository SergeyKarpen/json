package com.sergeykarpen.crudconsole.repository.io;

import com.sergeykarpen.crudconsole.model.Skill;
import com.sergeykarpen.crudconsole.repository.SkillRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.sergeykarpen.crudconsole.util.IOUtil.*;
import static com.sergeykarpen.crudconsole.util.IOUtil.getPathToFile;

public class JavaIOSkillRepositoryImpl implements SkillRepository {

    private final static String relativePathToFile = "src\\main\\resources\\skills.txt";

    @Override
    public List<Skill> getAll() throws IOException {
        return convertStringsToObjects(readFile((getPathToFile(relativePathToFile))));
    }

    @Override
    public Skill getById(Long id) {
        Skill needSkillById = new Skill();
        try {
            for (Skill needSkill : convertStringsToObjects(readFile((getPathToFile(relativePathToFile))))) {
                if (needSkill.getId().equals(id)) {
                    needSkillById = needSkill;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return needSkillById;
    }

    @Override
    public Skill save(Skill skill) {
        List<Skill> newSkills = null;
        try {
            newSkills = new ArrayList<>(convertStringsToObjects(readFile(getPathToFile(relativePathToFile))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Skill saveSkill = new Skill();
        saveSkill.setName(skill.getName());
        saveSkill.setId((long) (newSkills.size() + 1));
        newSkills.add(saveSkill);
        writeInFileString(convertObjectToString(saveSkill), relativePathToFile);
        return saveSkill;
    }

    @Override
    public void deleteById(Long id) {
        List<Skill> newSkills = null;

        try {
            newSkills = new ArrayList<>(convertStringsToObjects(readFile(getPathToFile(relativePathToFile))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Skill s : newSkills) {
            if (s.getId().equals(id)) {
                s.setName(null);
            }
        }
        writeInFileList(convertObjectsToStrings(newSkills), relativePathToFile);
    }

    @Override
    public List<Skill> convertStringsToObjects(List<String> input) {
        List<Skill> resultList = new ArrayList<>();
        for (String str : input) {
            String[] splitedString = str.split(",");
            Skill mySkill = new Skill();
            mySkill.setId((long) Integer.parseInt(splitedString[0]));
            mySkill.setName(splitedString[1]);
            resultList.add(mySkill);
        }
        return resultList;
    }

    @Override
    public List<String> convertObjectsToStrings(List<Skill> input) {
        List<String> listStrings = new ArrayList<>();
        for (Skill s : input) {
            listStrings.add(convertObjectToString(s));
        }
        return listStrings;
    }

    @Override
    public String convertObjectToString (Skill skill) {
        return skill.toString();
    }


    @Override
    public Skill update(Skill skill) {
        List<Skill> newSkills = null;
        try {
            newSkills = new ArrayList<>(convertStringsToObjects(readFile(getPathToFile(relativePathToFile))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Skill s : newSkills) {
            if (s.getId().equals(skill.getId())) {
                s.setName(skill.getName());
            }
        }
        writeInFileList(convertObjectsToStrings(newSkills), relativePathToFile);
        return skill;
    }
}

