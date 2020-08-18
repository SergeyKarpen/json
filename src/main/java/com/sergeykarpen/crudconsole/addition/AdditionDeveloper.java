package com.sergeykarpen.crudconsole.addition;

import com.sergeykarpen.crudconsole.model.Developer;
import com.sergeykarpen.crudconsole.repository.io.JavaIODeveloperRepositoryImpl;
import com.sergeykarpen.crudconsole.repository.io.JavaIOSkillRepositoryImpl;

import java.io.IOException;
import java.util.*;

import static com.sergeykarpen.crudconsole.util.IOUtil.getPathToFile;
import static com.sergeykarpen.crudconsole.util.IOUtil.readFile;

public class AdditionDeveloper {

    private final static String relativePathToFile = "src\\main\\resources\\developers.txt";

    JavaIODeveloperRepositoryImpl javaIODeveloperRepository = new JavaIODeveloperRepositoryImpl();

    public void create(String name, String accountStatus, Long accountId, Set<Long> skillIds) throws Exception {
        Developer developer = new Developer();
        developer.setId(getLastId() + 1);
        developer.setName(name);
        developer.setAccountStatus(accountStatus);
        developer.setAccountId(accountId);
        developer.setSkillIds(skillIds);
        javaIODeveloperRepository.save(developer);
    }

    public Long getLastId() throws IOException {
        List<Developer> developers = new ArrayList<>(javaIODeveloperRepository.convertStringsToObjects(readFile(getPathToFile(relativePathToFile))));
        return (long) (developers.size());
    }

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
