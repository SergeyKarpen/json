package com.sergeykarpen.crudconsole.repository.io;

import com.sergeykarpen.crudconsole.model.Account;
import com.sergeykarpen.crudconsole.model.AccountStatus;
import com.sergeykarpen.crudconsole.model.Developer;
import com.sergeykarpen.crudconsole.model.Skill;
import com.sergeykarpen.crudconsole.repository.AccountRepository;
import com.sergeykarpen.crudconsole.repository.DeveloperRepository;
import com.sergeykarpen.crudconsole.repository.SkillRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static com.sergeykarpen.crudconsole.util.IOUtil.*;

public class JavaIODeveloperRepositoryImpl implements DeveloperRepository {

    private SkillRepository skillRepository;
    private AccountRepository accountRepository;
    private final static String relativePathToFile = "src\\main\\resources\\developers.txt";

    @Override
    public List<Developer> getAll() throws IOException {
        return convertStringsToObjects(readFile((getPathToFile(relativePathToFile))));
    }

    @Override
    public Developer getById(Long id) {
        Developer needDeveloperById = new Developer();
        try {
            for (Developer needDeveloper : convertStringsToObjects(readFile((getPathToFile(relativePathToFile))))) {
                if (needDeveloper.getId().equals(id)) {
                    needDeveloperById = needDeveloper;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return needDeveloperById;
    }

    public Developer save (Developer developer)  throws IOException {
        writeInFileString(convertObjectToString( developer ), relativePathToFile);
        return developer;
    }

    // TODO: 11.08.2020
    @Override
    public void deleteById(Long id) {
        List<Developer> newDevelopers = null;
        try {
            newDevelopers = new ArrayList<>(convertStringsToObjects(readFile(getPathToFile(relativePathToFile))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert newDevelopers != null;
        for (Developer d : newDevelopers) {
            if (d.getId().equals(id)) {
                d.setName(null);
            }
        }
        writeInFileString("", relativePathToFile);
    }

    @Override
    public List<Developer> convertStringsToObjects(List<String> input) throws IOException {
        List<Developer> developers = new ArrayList<>();
        for (String str : input) {
            String[] splitedString = str.split(",");
            Developer developer = new Developer();

            developer.setId((long) Integer.parseInt(splitedString[0]));
            developer.setName(splitedString[1]);
            developer.setAccountStatus(AccountStatus.valueOf(splitedString[2]));

            Long accountId = Long.parseLong(splitedString[3]);
            developer.setAccountId(accountId);
            developer.setAccount(accountRepository.getById(accountId));

            String[] sIds = splitedString[4].split("/");
            HashSet<Skill> skills = new HashSet<>();
            HashSet<Long> skillIds = new HashSet<>();
            for (String id : sIds
            ) {
                Long skillId = Long.parseLong(id);
                skillIds.add(skillId);
                skills.add(skillRepository.getById(skillId));
            }

            developer.setSkillIds(skillIds);
            developer.setSkills(skills);

            developers.add(developer);
        }
        return developers;
    }

    @Override
    public List<String> convertObjectsToStrings(List<Developer> input) throws IOException {
        List<String> listStrings = new ArrayList<>();
        for (Developer s : input) {
            listStrings.add(convertObjectToString(s));
        }
        return listStrings;
    }

    @Override
    public String convertObjectToString(Developer developer) throws IOException {
        return developer.toString();
    }

    @Override
    public Developer update(Developer developer) {
        List<Developer> newDevelopers = null;
        try {
            newDevelopers = new ArrayList<>(convertStringsToObjects(readFile(getPathToFile(relativePathToFile))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Developer d : newDevelopers) {
            if (d.getId().equals(developer.getId())) {
                d.setName(developer.getName());
            }
        }
        writeInFileString("", relativePathToFile);
        return developer;
    }
}