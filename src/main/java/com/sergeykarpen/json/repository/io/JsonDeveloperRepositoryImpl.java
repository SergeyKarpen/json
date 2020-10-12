package com.sergeykarpen.json.repository.io;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sergeykarpen.json.model.Account;
import com.sergeykarpen.json.model.AccountStatus;
import com.sergeykarpen.json.model.Developer;
import com.sergeykarpen.json.model.Skill;
import com.sergeykarpen.json.repository.DeveloperRepository;
import com.sergeykarpen.json.repository.SkillRepository;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static com.sergeykarpen.json.model.AccountStatus.ACTIVE;
import static com.sergeykarpen.json.model.AccountStatus.valueOf;
import static com.sergeykarpen.json.util.IOUtil.*;

public class JsonDeveloperRepositoryImpl implements DeveloperRepository {

    private SkillRepository skillRepository = new JsonSkillRepositoryImpl() {
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

    public Developer create(Developer developer) {
        Developer newDeveloper = new Developer();
        newDeveloper.setName(String.valueOf(developer));
        newDeveloper.setId(maxIdInList(getListObjectsFromJson(relativePathToFile)) + 1);
        newDeveloper.setAccountStatus(String.valueOf(ACTIVE));
        newDeveloper.setAccountId(developer.getAccountId());
        newDeveloper.setSkillIds(developer.getSkillIds());
        List<Developer> developers = getListObjectsFromJson(relativePathToFile);
        developers.add(newDeveloper);
        writeListObjectsInJson(developers, relativePathToFile);
        return newDeveloper;
    }

    @Override
    public void deleteById(Long id) {
        /*
        List<Developer> developers = null;
        try {
            developers = new ArrayList<>(convertStringsToObjects(readFile(getPathToFile(relativePathToFile))));
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert developers != null;
        for (Developer d : developers) {
            if (d.getId().equals(id)) {
                String s = String.valueOf((AccountStatus.DELETED));
                d.setAccountStatus(s);
            }
        }
        writeInFileList(convertObjectsToStrings(developers), relativePathToFile);
*/
    }

    @Override
    public List<Developer> getListObjectsFromJson(String pathFile) {
        Gson gson = new Gson();
        Reader reader = null;
        try {
            reader = Files.newBufferedReader(Paths.get(pathFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert reader != null;
        List<Developer> developers = gson.fromJson(reader, new TypeToken<List<Developer>>() {
        }.getType());
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return developers;
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
    public Long maxIdInList(List<Developer> developers) {/*
         Long along = developers.stream().max(Comparator.comparing(Developer::getId))
                .get()
                .getId();
         if (along == null) {
             return 1L;
         } else return along;
         */
        return 0L;
    }


    @Override
    public Developer update(Developer developer) {
        return null;
    }
}