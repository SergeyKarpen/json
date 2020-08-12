package com.sergeykarpen.crudconsole.addition;

import com.sergeykarpen.crudconsole.model.AccountStatus;
import com.sergeykarpen.crudconsole.model.Developer;
import com.sergeykarpen.crudconsole.model.Skill;
import com.sergeykarpen.crudconsole.repository.io.JavaIODeveloperRepositoryImpl;
import com.sergeykarpen.crudconsole.repository.io.JavaIOSkillRepositoryImpl;

import java.io.IOException;
import java.util.*;

import static com.sergeykarpen.crudconsole.util.IOUtil.getPathToFile;
import static com.sergeykarpen.crudconsole.util.IOUtil.readFile;

public class AdditionDeveloper {

    private final static String relativePathToFile = "src\\main\\resources\\skills.txt";

    JavaIODeveloperRepositoryImpl javaIODeveloperRepository = new JavaIODeveloperRepositoryImpl();
    JavaIOSkillRepositoryImpl javaIOSkillRepository = new JavaIOSkillRepositoryImpl();

    public void create(String name, AccountStatus accountStatus, Long accountId, Set<Long> skillIds) throws Exception {
        Developer developer = new Developer();
        developer.setId(getLastId() + 1);
        developer.setName(name);
        developer.setAccountStatus(accountStatus);
        developer.setAccountId(accountId);
        developer.setSkillIds(skillIds);
        javaIODeveloperRepository.save(developer);
    }

    public Long getLastId() throws IOException {
        List<Skill> skills = new ArrayList<>(javaIOSkillRepository.convertStringsToObjects(readFile(getPathToFile(relativePathToFile))));
        if (skills.size() != 0) {
            return skills.get(skills.size() - 1).getId();
        }
        return null;
    }
}
