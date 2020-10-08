package com.sergeykarpen.json;


import com.sergeykarpen.json.model.Skill;
import com.sergeykarpen.json.repository.io.JsonSkillRepositoryImpl;
import com.sergeykarpen.json.util.IOUtil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Run {
   // private final static String relativePathToFile = "src\\main\\resources\\";
    public static void main(String[] args) throws Exception {
        //     MainMenu runner = new MainMenu();
        //   runner.showMainMenu();

        IOUtil ioUtil = new IOUtil();
        Run run = new Run();
        JsonSkillRepositoryImpl jsonSkillRepository = new JsonSkillRepositoryImpl();
        for (Map.Entry<Long, Skill> entry: jsonSkillRepository.getAll().entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println(jsonSkillRepository.getById((long) 1));
    }
}