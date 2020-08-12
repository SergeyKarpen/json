package com.sergeykarpen.crudconsole.util;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IOUtil {

    public static List<String> readFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(getPathToFile(fileName)));
        String line;
        List<String> listOfStrings = new ArrayList<>();
        while ((line = reader.readLine()) != null) {
            listOfStrings.addAll(Arrays.asList(line.split("\\s+")));
        }
        return listOfStrings;
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
