package com.sergeykarpen.json.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sergeykarpen.json.model.Skill;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class IOUtil {
    public static String getPathToFile(String relativePathToFile) {
        File file = new File(relativePathToFile);
        return file.getAbsolutePath();
    }
}
