package com.sergeykarpen.json.repository.io;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sergeykarpen.json.model.Skill;
import com.sergeykarpen.json.repository.SkillRepository;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

import static com.sergeykarpen.json.util.IOUtil.*;

public class JsonSkillRepositoryImpl implements SkillRepository {

    private final static String relativePathToFile = "src\\main\\resources\\skills.json";

    @Override
    public void writeListObjectsInJson(List<Skill> skills, String fileName) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(getPathToFile(fileName), false);
        } catch (IOException e) {
            e.printStackTrace();
        }
        new Gson().toJson(skills, writer);
        try {
            assert writer != null;
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Long maxIdInList(List<Skill> skills) {
        Long along = skills.stream().max(Comparator.comparing(Skill::getId))
                .get()
                .getId();
        return along;
    }

    @Override
    public List<Skill> getListObjectsFromJson(String pathFile) {
        Gson gson = new Gson();
        Reader reader = null;
        try {
            reader = Files.newBufferedReader(Paths.get(pathFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert reader != null;
        List skills = gson.fromJson(reader, new TypeToken<List<Skill>>() {
        }.getType());
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return skills;
    }

    @Override
    public List<Skill> getAll() throws IOException {
        return getListObjectsFromJson(relativePathToFile);
    }

    @Override
    public Skill getById(Long id) throws IOException {
        List<Skill> skills = getListObjectsFromJson(relativePathToFile);
        return skills.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public void deleteById(Long id) throws IOException {
        List<Skill> skills = getListObjectsFromJson(relativePathToFile)
                .stream()
                .filter(p -> !p.getId().equals(id)).collect(Collectors.toList());
        writeListObjectsInJson(skills, getPathToFile(relativePathToFile));
    }

    @Override
    public Skill create(Skill skill) throws IOException {
        Skill newSkill = new Skill();
        newSkill.setName(String.valueOf(skill));
        newSkill.setId(maxIdInList(getListObjectsFromJson(relativePathToFile)) + 1);
        List<Skill> skills = getListObjectsFromJson(relativePathToFile);
        skills.add(newSkill);
        writeListObjectsInJson(skills, relativePathToFile);
        return newSkill;
    }

    @Override
    public Skill update(Skill skill) throws IOException {
        List<Skill> skills = getListObjectsFromJson(relativePathToFile);
        for (Skill s : skills) {
            if (skill.getId().equals(s.getId())) {
                s.setName(String.valueOf(skill));
            }
        }
        writeListObjectsInJson(skills, relativePathToFile);
        return skill;
    }
}

