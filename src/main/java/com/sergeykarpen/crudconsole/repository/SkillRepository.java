package main.java.com.sergeykarpen.crudconsole.repository;

import main.java.com.sergeykarpen.crudconsole.model.Skill;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static main.java.com.sergeykarpen.crudconsole.model.Skill.pathToSkillFile;

public class SkillRepository {

    // считываем содержимое файла в String с помощью BufferedReader
    private List<String> readFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(pathToSkillFile));
        String line;
        List<String> listOfStrings = new ArrayList<>();
        while ((line = reader.readLine()) != null) {
            listOfStrings.addAll(Arrays.asList(line.split("\\s+")));
        }
        return listOfStrings;
    }

    private List<Skill> convertStringToSkillArray(List<String> input) {
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

    //1 Показать все скилы
    private List<Skill> getAll() throws IOException {
        return convertStringToSkillArray(readFile());
    }

    //2 Выбрать скил по id
    private Skill getById(Long id) throws IOException {
        Skill needSkillById = new Skill();
        for (Skill needSkill : convertStringToSkillArray(readFile())) {
            if (needSkill.getId().equals(id)) {
                needSkillById = needSkill;
            }
        }
        return needSkillById;
    }

    //3 Добавить новыйц скил в существующий список

    private Skill save(Skill skill) throws IOException {
        List<Skill> newSkills = new ArrayList<>(convertStringToSkillArray(readFile()));
        Skill saveSkill = new Skill();
        saveSkill.setName(skill.getName());
        saveSkill.setId((long) (newSkills.size() + 1));
        newSkills.add(saveSkill);
        writeInFile(newSkills);
        return saveSkill;
    }

    //4 Удалить скил без изменения Id
    private void delete(Long id) throws IOException {
        List<Skill> newSkills = new ArrayList<>(convertStringToSkillArray(readFile()));
        for (Skill s : newSkills) {
            if (s.getId().equals(id)) {
                s.setName(null);
            }
        }
        writeInFile(newSkills);
    }

    //5 Обновить скил без изменения Id
    public Skill update(Skill skill) throws IOException {
        List<Skill> newSkills = new ArrayList<>(convertStringToSkillArray(readFile()));
        for (Skill s : newSkills) {
            if (s.getName().equals(skill.getName())) {
                skill = s;
            }
        }
        writeInFile(newSkills);
        return skill;
    }

    private void writeInFile(List<Skill> newSkills) {
        try (FileWriter writer = new FileWriter(pathToSkillFile, false)) {
            try {
                for (Skill s : newSkills) {
                    writer.write(s.toString());
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            try {
                writer.flush();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setList() throws IOException {
        System.out.println("Список скилов " + "\n" + getAll());
    }

}

