package com.sergeykarpen.crudconsole.repository.io;

import com.sergeykarpen.crudconsole.model.Developer;
import com.sergeykarpen.crudconsole.model.Skill;
import com.sergeykarpen.crudconsole.repository.AccountRepository;
import com.sergeykarpen.crudconsole.repository.DeveloperRepository;
import com.sergeykarpen.crudconsole.repository.SkillRepository;

import java.io.IOException;
import java.util.ArrayList;
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

    @Override
    public Developer save(Developer developer) {
        List<Developer> newDevelopers = null;
        try {
            newDevelopers = new ArrayList<>(convertStringsToObjects(readFile(getPathToFile(relativePathToFile))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Developer saveDeveloper = new Developer();
        saveDeveloper.setName(developer.getName());
        saveDeveloper.setId((long) (newDevelopers.size() + 1));
        newDevelopers.add(saveDeveloper);
        writeInFileString("", relativePathToFile);
        return developer;
    }

    @Override
    public void deleteById(Long id) {
        List<Developer> newDevelopers = null;
        try {
            newDevelopers = new ArrayList<>(convertStringsToObjects(readFile(getPathToFile(relativePathToFile))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Developer d : newDevelopers) {
            if (d.getId().equals(id)) {
                d.setName(null);
            }
        }
        writeInFileString("", relativePathToFile);
    }

    @Override
    public List<Developer> convertStringsToObjects(List<String> input) {
        List<Developer> resultList = new ArrayList<>();
        for (String str : input) {
            String[] splitedString = str.split(",");
            Developer myDeveloper = new Developer();
            myDeveloper.setId((long) Integer.parseInt(splitedString[0]));
            myDeveloper.setName(splitedString[1]);
            resultList.add(myDeveloper);
        }
        return resultList;
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