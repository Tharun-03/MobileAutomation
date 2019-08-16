package com.amazon.framework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Settings
{
    private static Properties properties = loadFromPropertiesFile();

    private Settings() {

    }

    public static Properties getInstance() {
        return properties;
    }

    private static Properties loadFromPropertiesFile()
    {
        Properties properties = new Properties();

        try {
            properties.load(new FileInputStream(Utilities.getRelativePath() + "/" + "resources" +
                    "/" + "config.properties"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}

