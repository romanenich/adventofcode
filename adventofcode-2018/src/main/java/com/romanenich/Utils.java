package com.romanenich;

import java.io.File;
import java.util.Objects;

public class Utils {

    public static File getFileByName(Class clazz, String fileName){
        ClassLoader classLoader = clazz.getClassLoader();
        return new File(Objects.requireNonNull(classLoader.getResource(fileName)).getFile());
    }
}
