package com.sergeykarpen.crudconsole.view;

import java.io.IOException;
import java.util.Scanner;

public class MainMenu {

    private final String menuSelectionMessage = "Выберите необходимое действие:\n" +
            "1.Работа с developers\n" +
            "2.Работа сo skills\n" +
            "3.Просмротреть полный список developers/status/skills/\n" +
            "4.Выход";

    private final String incorrectInputMessage = "Неверный ввод, повторите";

    private final String endMessage = "Конец работы приложения";

    public void showMainMenu() throws Exception {

        boolean isExit = false;
        do {
            System.out.println( menuSelectionMessage );
            Scanner scanner = new Scanner( System.in );
            String inputNumber = scanner.nextLine();
            switch (inputNumber) {
                case ("1"):
                    MenuDevelopers consoleDevelopers = new MenuDevelopers();
                    consoleDevelopers.showMenuDevelopers();
                    break;
                case ("2"):
                    MenuSkills consoleSkills = new MenuSkills();
                    consoleSkills.showMenuSkills();
                    break;
                case ("3"):
                    MenuAccounts menuAccounts = new MenuAccounts();
                    menuAccounts.showMenuAccounts();
                    break;
                case ("4"):
                    isExit = true;
                    break;
                default:
                    System.out.println( incorrectInputMessage );
                    break;
            }
        } while (!isExit);
        System.out.println( endMessage );
    }
}

