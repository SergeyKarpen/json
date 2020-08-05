package com.sergeykarpen.crudconsole.view;

import com.sergeykarpen.crudconsole.controller.SkillController;
import com.sergeykarpen.crudconsole.model.Skill;
import com.sergeykarpen.crudconsole.repository.SkillRepository;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class MenuSkills {

    private final String menuSelectionMessage = "Выберите необходимое действие:\n" +
            "1.Просмотреть список навыков\n" +
            "2.Выбрать навык по id\n" +
            "3.Добавить навык\n" +
            "4.Удалить навык\n" +
            "5.Изменить существующий навык\n" +
            "6.Выход";

    private final String getAllMessage = "Список навыков:";

    private final String getByIdMessage = "Введите id для выбора навыка ";

    private final String saveMessage = "Введите навык для добавления его в существующий список";

    private final String deleteMessage = "Выберите навык для его удаления из списка";

    private final String editMessage = "Введите необходимые изменения";

    private final String incorrectInputMessage = "Неверный ввод, повторите";

    private final String endMessage = "Выход из меню Skills";


    public void showMenuSkills() throws IOException {
        SkillController skillController = new SkillController();

        boolean isExit = false;
        do {
            System.out.println(menuSelectionMessage);
            Scanner scanner = new Scanner(System.in);
            String inputNumber = scanner.nextLine();
            switch (inputNumber) {
                case ("1"):
                    System.out.println(getAllMessage);
                    printAll(skillController.getAll());
                    break;
                case ("2"):
                    System.out.print(getByIdMessage);
                    int inputId = scanner.nextInt();
                    skillController.getById((long) inputId).toString();
                    break;
                case ("3"):
                    System.out.print(saveMessage);
                    String inputNewStringSkill = scanner.nextLine();
                    skillController.save(inputNewStringSkill);
                    break;
                case ("4"):
                    System.out.print(deleteMessage);
                    int inputDelSkill = scanner.nextInt();
                    skillController.delete((long) inputDelSkill);
                    break;
                case ("5"):
                    System.out.print(getByIdMessage);
                    int inputUpdateSkillId = Integer.parseInt(scanner.nextLine());
                    System.out.println(editMessage);
                    String inputUpdateSkillName = scanner.nextLine();
                    skillController.update((long) inputUpdateSkillId, inputUpdateSkillName);
                    break;
                case ("6"):
                    isExit = true;
                    break;
                default:
                    System.out.println(incorrectInputMessage);
                    break;
            }
        } while (!isExit);
        System.out.println(endMessage);
    }


    public void printAll(List<Skill> listSkill) {
        for (Skill p : listSkill) {
            System.out.print(p.toString());
        }
    }
}