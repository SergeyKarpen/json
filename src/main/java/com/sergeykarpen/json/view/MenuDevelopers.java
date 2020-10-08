package com.sergeykarpen.json.view;

import com.sergeykarpen.json.controller.AccountController;
import com.sergeykarpen.json.controller.DeveloperController;
import com.sergeykarpen.json.controller.SkillController;
import com.sergeykarpen.json.model.Account;
import com.sergeykarpen.json.model.AccountStatus;
import com.sergeykarpen.json.model.Developer;

import java.util.*;

public class MenuDevelopers {

    private final String menuSelectionMessage = "Выберите необходимое действие:\n" +
            "1.Создать developers\n" +
            "2.Показать всех developers\n" +
            "3.Удалить developer\n" +
            "4.Изменить существующего developer\n" +
            "5.Выход";

    private final String AccountSelectionMessage = "Выберите статус аккаунта: " +
            "1-ACTIVE;" +
            "2-DELETED;" +
            "3-BANNED";

    private final String getAllMessage = "Весь список Developers:";

    private final String getByIdMessage = "Введите id для выбора Developers ";

    private final String deleteMessage = "Выберите Developers для его удаления из списка";

    private final String incorrectInputMessage = "Неверный ввод, повторите";

    private final String endMessage = "Выход из меню Developers";

/*
    public void showMenuDevelopers() throws Exception {
        DeveloperController developerController = new DeveloperController();
        SkillController skillController = new SkillController();
        AccountController accountController = new AccountController();

        boolean isExit = false;
        do {
            System.out.println(menuSelectionMessage);
            Scanner scanner = new Scanner(System.in);
            String inputNumber = scanner.nextLine();
            switch (inputNumber) {
                case ("1"):
                    System.out.println("Впишите имя developer");
                    String name = scanner.nextLine();
                    Set<Long> skillIds = new HashSet<>();
                    boolean pip = true;
                    do {
                        System.out.println("Выберите скилы из списка:");
                        MenuSkills.printAll(skillController.getAll());
                        String inputID = scanner.nextLine();
                        skillIds.add(Long.valueOf((inputID)));
                        System.out.println("Жми Q для выхода или Enter для продолжения");
                        String YN = scanner.nextLine();
                        if (YN.equalsIgnoreCase("Q")) {
                            pip = false;
                        }
                    }
                    while (pip);

                    System.out.println("Выбрать Account:");
                    MenuAccounts.printAll(accountController.getAll());
                    String accountId = scanner.nextLine();
                    Account account = accountController.getById(Long.valueOf(accountId));

                    System.out.println(AccountSelectionMessage);
                    String s = scanner.nextLine();
                    if (s.equalsIgnoreCase("1")) {
                        s = String.valueOf(AccountStatus.ACTIVE);
                    } else if (s.equalsIgnoreCase("2")) {
                        s = String.valueOf(AccountStatus.DELETED);
                    } else if (s.equalsIgnoreCase("3")) {
                        s = String.valueOf(AccountStatus.BANNED);
                    } else s = String.valueOf(AccountStatus.DELETED);
                    developerController.create(name, s, account.getId(), skillIds);
                    break;
                case ("2"):
                    System.out.println(getAllMessage);
                    printAll(developerController.getAll());
                    break;
                case ("3"):
                    System.out.println(deleteMessage);
                    printAll(developerController.getAll());
                    int inputDelDeveloper = scanner.nextInt();
                    developerController.deleteById((long) inputDelDeveloper);
                    break;
                case ("4"):
                    System.out.println(getByIdMessage);
                    printAll(developerController.getAll());
                    int upId = Integer.parseInt((scanner.nextLine()));

                    System.out.println("Впишите имя developer");
                    String upName = scanner.nextLine();
                    Set<Long> upSkillIds = new HashSet<>();
                    boolean pup = true;
                    do {
                        System.out.println("Выберите скилы из списка:");
                        MenuSkills.printAll(skillController.getAll());
                        String upSks = scanner.nextLine();
                        upSkillIds.add(Long.valueOf((upSks)));
                        System.out.println("Жми Q для выхода или Enter для продолжения");
                        String YN = scanner.nextLine();
                        if (YN.equalsIgnoreCase("Q")) {
                            pup = false;
                        }
                    }
                    while (pup);

                    System.out.println("Выбрать Account:");
                    MenuAccounts.printAll(accountController.getAll());
                    String upAccountId = scanner.nextLine();
                    Account UpAccount = accountController.getById(Long.valueOf(upAccountId));

                    System.out.println(AccountSelectionMessage);
                    String up = scanner.nextLine();
                    if (up.equalsIgnoreCase("1")) {
                        up = String.valueOf(AccountStatus.ACTIVE);
                    } else if (up.equalsIgnoreCase("2")) {
                        up = String.valueOf(AccountStatus.DELETED);
                    } else if (up.equalsIgnoreCase("3")) {
                        up = String.valueOf(AccountStatus.BANNED);
                    } else up = String.valueOf(AccountStatus.DELETED);
                    developerController.updateAll(Long.valueOf(upId), upName, up, UpAccount.getId(), upSkillIds);
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

 */
}
