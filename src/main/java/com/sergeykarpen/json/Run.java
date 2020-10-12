package com.sergeykarpen.json;


import com.sergeykarpen.json.controller.DeveloperController;
import com.sergeykarpen.json.controller.SkillController;
import com.sergeykarpen.json.model.AccountStatus;
import com.sergeykarpen.json.repository.io.JsonSkillRepositoryImpl;
import com.sergeykarpen.json.util.IOUtil;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Run {
    // private final static String relativePathToFile = "src\\main\\resources\\";
    public static void main(String[] args) throws Exception {
        //     MainMenu runner = new MainMenu();
        //   runner.showMainMenu();

        IOUtil ioUtil = new IOUtil();
        Run run = new Run();
        DeveloperController developerController = new DeveloperController();
        Set<Long> set =  new HashSet<>();
        set.add(1L);
        set.add(2L);
        developerController.create("First", String.valueOf(AccountStatus.ACTIVE), 1L, set);
        developerController.create("Second", String.valueOf(AccountStatus.BANNED), 1L, set);
    }
}