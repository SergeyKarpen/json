package com.sergeykarpen.json.addition;

import com.sergeykarpen.json.model.Developer;
import com.sergeykarpen.json.repository.io.JsonDeveloperRepositoryImpl;

import java.io.IOException;
import java.util.*;

import static com.sergeykarpen.json.util.IOUtil.getPathToFile;
import static com.sergeykarpen.json.util.IOUtil.readFile;

public class AdditionDeveloper {

    private final static String relativePathToFile = "src\\main\\resources\\developers.json";

    JsonDeveloperRepositoryImpl javaIODeveloperRepository = new JsonDeveloperRepositoryImpl();
/*
    public void create(String name, String accountStatus, Long accountId, Set<Long> skillIds) throws Exception {
        Developer developer = new Developer();
        developer.setId(getLastId() + 1);
        developer.setName(name);
        developer.setAccountStatus(accountStatus);
        developer.setAccountId(accountId);
        developer.setSkillIds(skillIds);
        javaIODeveloperRepository.save(developer);
    }

 */
/*
    public Long getLastId() throws IOException {
        List<Developer> developers = new ArrayList<>(javaIODeveloperRepository.convertStringsToObjects(readFile(getPathToFile(relativePathToFile))));
        return (long) (developers.size());
    }


 */
    public void updateAll(Long id,String name, String accountStatus, Long accountId, Set<Long> skillIds) throws Exception {
        Developer developer = new Developer();
        developer.setId(id);
        developer.setName(name);
        developer.setAccountStatus(accountStatus);
        developer.setAccountId(accountId);
        developer.setSkillIds(skillIds);
        javaIODeveloperRepository.save(developer);
    }
}
