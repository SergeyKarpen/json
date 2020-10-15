package com.sergeykarpen.json;


import com.sergeykarpen.json.controller.DeveloperController;
import com.sergeykarpen.json.controller.SkillController;
import com.sergeykarpen.json.model.AccountStatus;
import com.sergeykarpen.json.model.Developer;
import com.sergeykarpen.json.model.Skill;
import com.sergeykarpen.json.repository.io.JsonDeveloperRepositoryImpl;
import com.sergeykarpen.json.repository.io.JsonSkillRepositoryImpl;
import com.sergeykarpen.json.util.IOUtil;
import com.sergeykarpen.json.view.MainMenu;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Run {
    public static void main(String[] args) throws Exception {
        MainMenu runner = new MainMenu();
        runner.showMainMenu();



    }
}