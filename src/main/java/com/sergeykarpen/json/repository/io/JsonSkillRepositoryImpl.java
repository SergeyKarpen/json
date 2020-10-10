package com.sergeykarpen.json.repository.io;

import com.sergeykarpen.json.model.Skill;
import com.sergeykarpen.json.repository.SkillRepository;

import java.io.IOException;
import java.util.*;

import static com.sergeykarpen.json.util.IOUtil.*;

public class JsonSkillRepositoryImpl implements SkillRepository {

    private final static String relativePathToFile = "src\\main\\resources\\skills.json";

    @Override
    public Map<Long, Skill> getAll() throws IOException {
        return readFile(relativePathToFile);
    }

    @Override
    public Skill getById(Long id) throws IOException {
        Skill skill = new Skill();
        System.out.println(readFile(relativePathToFile));
        return skill;
    }


    @Override
    public void deleteById(Long aLong) throws IOException {
Map<Long, Skill> map = readFile(relativePathToFile);
map.remove(aLong);

        System.out.println(map);
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
    public String convertObjectToString(Skill skill) {
        return skill.toString();
    }


    @Override
    public Skill save(Skill skill) throws IOException {
        return null;
    }

    @Override
    public Skill update(Skill skill) {
        return null;
    }
}

