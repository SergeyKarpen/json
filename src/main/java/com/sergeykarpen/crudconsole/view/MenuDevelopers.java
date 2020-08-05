package com.sergeykarpen.crudconsole.view;

import com.sergeykarpen.crudconsole.controller.DeveloperController;
import com.sergeykarpen.crudconsole.model.Developer;
import com.sergeykarpen.crudconsole.model.Skill;
import com.sergeykarpen.crudconsole.repository.io.JavaIOSkillRepositoryImpl;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class MenuDevelopers {

    private final String menuSelectionMessage = "Выберите необходимое действие:\n" +
            "1.Просмотреть список developers\n" +
            "2.Добавить developer\n" +
            "3.Удалить developer\n" +
            "4.Изменить существующего developer\n" +
            "5.Выход";

    private final String getAllMessage = "Весь список Developers:";

    private final String getByIdMessage = "Введите id для выбора Developers ";

    private final String saveMessage = "Введите Developers для добавления его в существующий список";

    private final String deleteMessage = "Выберите Developers для его удаления из списка";

    private final String editMessage = "Введите необходимые изменения";

    private final String incorrectInputMessage = "Неверный ввод, повторите";

    private final String endMessage = "Выход из меню Developers";


    public void showMenuDevelopers() throws IOException {
        DeveloperController developerController = new DeveloperController();

        boolean isExit = false;
        do {
            System.out.println(menuSelectionMessage);
            Scanner scanner = new Scanner(System.in);
            String inputNumber = scanner.nextLine();
            switch (inputNumber) {
                case ("1"):
                    System.out.println(getAllMessage);
                    printAll(developerController.getAll());
                    break;
                case ("2"):
                    System.out.print(saveMessage);
                    String inputNewStringDeveloper = scanner.nextLine();
                    developerController.save(inputNewStringDeveloper);
                    break;
                case ("3"):
                    System.out.print(deleteMessage);
                    int inputDelDeveloper = scanner.nextInt();
                    developerController.delete((long) inputDelDeveloper);
                    break;
                case ("4"):
                    System.out.print(getByIdMessage);
                    int inputUpdateSkillId = Integer.parseInt(scanner.nextLine());
                    System.out.println(editMessage);
                    String inputUpdateSkillName = scanner.nextLine();
                    developerController.update((long) inputUpdateSkillId, inputUpdateSkillName);
                    break;
                case ("5"):
                    isExit = true;
                    break;
                case ("6"):
                default:
                    System.out.println(incorrectInputMessage);
                    break;
            }
        } while (!isExit);
        System.out.println(endMessage);
    }


    public void printAll(List<Developer> list) {
        for (Developer d : list) {
            System.out.print(d.toString());
        }
    }
}
