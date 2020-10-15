package com.sergeykarpen.json.repository.io;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sergeykarpen.json.model.Developer;
import com.sergeykarpen.json.model.Skill;
import com.sergeykarpen.json.repository.DeveloperRepository;
import com.sergeykarpen.json.repository.SkillRepository;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static com.sergeykarpen.json.model.AccountStatus.valueOf;
import static com.sergeykarpen.json.util.IOUtil.*;

public class JsonDeveloperRepositoryImpl implements DeveloperRepository {

    private SkillRepository skillRepository = new JsonSkillRepositoryImpl() {
    };
    private com.sergeykarpen.json.repository.AccountRepository accountRepository = new JsonAccountRepositoryImpl() {
    };
    private final static String relativePathToFile = "src\\main\\resources\\developers.json";

    @Override
    public List<Developer> getAll() {
        return getListObjectsFromJson(relativePathToFile);
    }

    @Override
    public Developer getById(Long id) {
        List<Developer> developers = getListObjectsFromJson(relativePathToFile);
        return developers.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

    public Developer create(Developer developer) throws IOException {
        Developer newDeveloper = new Developer();
        newDeveloper.setName(developer.getName());
        newDeveloper.setId(maxIdInList(getListObjectsFromJson(relativePathToFile)) + 1);
        newDeveloper.setAccount(developer.getAccount());
        Set<Skill> skills = new HashSet<>();
        for (Long skillId : developer.getSkillIds()) {
            skills.add(skillRepository.getById(skillId));
        }
        newDeveloper.setSkills(skills);
        List<Developer> developers = getListObjectsFromJson(relativePathToFile);
        developers.add(newDeveloper);
        writeListObjectsInJson(developers, relativePathToFile);
        return newDeveloper;
    }

    @Override
    public void deleteById(Long id) {
        List<Developer> developers = getListObjectsFromJson(relativePathToFile)
                .stream()
                .filter(p -> !p.getId().equals(id)).collect(Collectors.toList());
        writeListObjectsInJson(developers, getPathToFile(relativePathToFile));
    }

    @Override
    public List<Developer> getListObjectsFromJson(String pathFile) {
        Gson gson = new Gson();
        List<Developer> list;
        try (FileReader reader = new FileReader(pathFile)) {
            list = gson.fromJson(reader, new TypeToken<ArrayList<Developer>>() {
            }.getType());
            return list;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    @Override
    public void writeListObjectsInJson(List<Developer> developers, String fileName) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(getPathToFile(fileName), false);
        } catch (IOException e) {
            e.printStackTrace();
        }
        new Gson().toJson(developers, writer);
        try {
            assert writer != null;
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Long maxIdInList(List<Developer> developers) {
        Long along;
        if (developers.isEmpty()) {
            return 0L;
        } else return along = developers.stream().max(Comparator.comparing(Developer::getId))
                .get()
                .getId();
    }

    @Override
    public Developer update(Developer developer) throws IOException {
        List<Developer> developers = getListObjectsFromJson(relativePathToFile);
        Developer newDeveloper = new Developer();
        for (Developer newDevelopers : developers) {
            if (newDevelopers.getId().equals(developer.getId())) {
                newDevelopers.setId(developer.getId());
                newDevelopers.setName(developer.getName());
                newDevelopers.setAccount(developer.getAccount());
                newDeveloper.setAccountStatus(developer.getAccountStatus());
                Set<Skill> skills = new HashSet<>();
                for (Long skillId : developer.getSkillIds()) {
                    skills.add(skillRepository.getById(skillId));
                }
                newDevelopers.setSkills(skills);
            }
            writeListObjectsInJson(developers, relativePathToFile);
        }
        return newDeveloper;
    }
}