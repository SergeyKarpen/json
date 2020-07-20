package main.java.com.sergeykarpen.crudconsole.repository;

import main.java.com.sergeykarpen.crudconsole.model.Skill;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static main.java.com.sergeykarpen.crudconsole.resources.Variables.pathToSkillFile;

public class Repository {

    // считываем содержимое файла в String с помощью BufferedReader
    private static List<String> readFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(pathToSkillFile));
        String line;
        List<String> listOfStrings = new ArrayList<>();
        while ((line = reader.readLine()) != null) {
            listOfStrings.addAll(Arrays.asList(line.split("\\s+")));
        }
        return listOfStrings;
    }

    private static List<Skill> convertStringToSkillArray() throws IOException {
        List<Skill> resultList = new ArrayList<>();
        for (String str : readFile()) {
            String[] splitedString = str.split(",");
            Skill mySkill = new Skill();
            mySkill.setId((long) Integer.parseInt(splitedString[0]));
            mySkill.setName(splitedString[1]);
            resultList.add(mySkill);
        }
        return resultList;
    }

    /*вроде как не нужен этот метод
    private void writeInfileString(String input) throws IOException {
        FileWriter fileWriter = new FileWriter(pathToSkillFile, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write("\n" + (readFile().size() + 1) + "," + input);
        bufferedWriter.close();
        fileWriter.close();
    }
*/
    //1 Показать все скилы
    private List<Skill> getAll() throws IOException {
        return convertStringToSkillArray();
    }

    //2 Выбрать скил по id
    private Skill getById(Long id) throws IOException {
        Skill needSkillById = new Skill();
        for (Skill needSkill : convertStringToSkillArray()) {
            if (needSkill.getId().equals(id)) {
                needSkillById = needSkill;
            }
        }
        return needSkillById;
    }

    //3 Добавить новыйц скил в существующий список

    private Skill save(Skill skill) throws IOException {
        List<Skill> newSkills = new ArrayList<>(convertStringToSkillArray());
        Skill saveSkill = new Skill();
        saveSkill.setName(skill.getName());
        saveSkill.setId((long) (newSkills.size() + 1));
        newSkills.add(saveSkill);
        writeInFile(newSkills);
        return saveSkill;
    }

    //4 Удалить скил без изменения Id
    private void delete(Long id) throws IOException {
        List<Skill> newSkills = new ArrayList<>(convertStringToSkillArray());
        for (Skill s : newSkills) {
            if (s.getId().equals(id)) {
                s.setName(null);
            }
        }
        writeInFile(newSkills);
    }


    //5 Обновить скил без изменения Id
    public Skill update(Skill skill) throws IOException {
        List<Skill> newSkills = new ArrayList<>(convertStringToSkillArray());
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



/*
    //Реализация ввода данных с консоли
    public void showMenu() throws IOException {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        do {
            System.out.println(selectMenu);
            String sc = scanner.nextLine();
            switch (sc) {
                case ("1"):
                    System.out.println(getAll());
                    break;
                case ("2"):
                    setList();
                    sc = scanner.nextLine();
                    System.out.println(getById((long) Integer.parseInt(sc)));
                    break;
                case ("3"):
                    setList();
                    System.out.println("Введите название скила который будет добавлен в существующий список:");
                    sc = scanner.nextLine();
                    save(sc);
                    break;
                case ("4"):
                    setList();
                    System.out.println("Введите id скила который будет удален");
                    sc = scanner.nextLine();
                    delete((long) Integer.parseInt(sc));
                    break;
                case ("5"):
                    setList();
                    System.out.println("Введите id скила который будет обновлен, а затем название скила");
                    sc = scanner.nextLine();
                    update((long) Integer.parseInt(sc), scanner.nextLine());
                    break;
                case ("6"):
                    exit = true;
                    break;
                default:
                    break;
            }
        } while (!exit);
    }
*/

}

