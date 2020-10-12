package com.sergeykarpen.json.addition;

import com.sergeykarpen.json.model.Developer;
import com.sergeykarpen.json.repository.io.JsonDeveloperRepositoryImpl;

import java.util.*;

public class AdditionDeveloper {

    private final static String relativePathToFile = "src\\main\\resources\\developers.json";

    JsonDeveloperRepositoryImpl javaIODeveloperRepository = new JsonDeveloperRepositoryImpl();


     public void updateAll(Long id,String name, String accountStatus, Long accountId, Set<Long> skillIds) throws Exception {
        Developer developer = new Developer();
        developer.setId(id);
        developer.setName(name);
        developer.setAccountStatus(accountStatus);
        developer.setAccountId(accountId);
        developer.setSkillIds(skillIds);
        javaIODeveloperRepository.create(developer);
    }
}
