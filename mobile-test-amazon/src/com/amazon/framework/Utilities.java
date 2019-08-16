package com.amazon.framework;

import java.io.File;
import java.util.Properties;

public class Utilities {

    static Properties properties = null;

    public static String getRelativePath() {
        String relativePath = new File(System.getProperty("user.dir")).getAbsolutePath();
        return relativePath;
    }
}
