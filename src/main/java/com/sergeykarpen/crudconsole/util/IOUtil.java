package com.sergeykarpen.crudconsole.util;

import com.sergeykarpen.crudconsole.model.Skill;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class IOUtil {

    private final static String pathToFile = "\\src\\main\\resources\\";

    public static List<String> readFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(getPathToTheFile(fileName)));
        String line;
        List<String> listOfStrings = new ArrayList<>();
        while ((line = reader.readLine()) != null) {
            listOfStrings.addAll(Arrays.asList(line.split("\\s+")));
        }
        return listOfStrings;
    }

    public static List<Skill> convertStringToSkillArray(List<String> input) {
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

    public static void printSkill(Skill skill) {
        System.out.print(skill.toString());
    }


    public static void printAllSkill(List<Skill> listSkill) {
        for (Skill printSkill : listSkill) {
            System.out.print(printSkill.toString());
        }
    }

    public static void writeInFile(String value, String fileName) {
        try (FileWriter writer = new FileWriter(getPathToTheFile(fileName), true)) {
            try {
                writer.write(value);
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

    public static String getPathToTheFile(String fileName) {
       Path AbsolutePath = Paths.get("").toAbsolutePath();
       String path = AbsolutePath + pathToFile + fileName;
        return path;
    }
}
