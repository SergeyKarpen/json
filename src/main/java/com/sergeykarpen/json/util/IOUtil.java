package com.sergeykarpen.json.util;

import com.google.gson.Gson;
import com.sergeykarpen.json.model.Skill;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class IOUtil {

    public static Map<Long, Skill> readFile(String fileName) throws IOException {
        Gson gson = new Gson();
        Reader reader = Files.newBufferedReader(Paths.get(fileName));
        Map mapSkills = gson.fromJson(reader, Map.class);
        reader.close();
        return mapSkills;
    }

    public static void writeInFileList(List<String> newList, String fileName) {
        try (FileWriter writer = new FileWriter(getPathToFile(fileName), false)) {
            try {
                for (String s : newList) {
                    writer.write(s);
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


    public static void writeInFileString(String newString, String fileName) {
        try (FileWriter writer = new FileWriter(getPathToFile(fileName), true)) {
            try {
                writer.write(newString);
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

    public static String getPathToFile(String relativePathToFile) {
        File file = new File(relativePathToFile);
        return file.getAbsolutePath();
    }
}
