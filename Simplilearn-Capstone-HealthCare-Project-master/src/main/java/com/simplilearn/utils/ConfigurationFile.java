package com.simplilearn.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationFile {

    final static String PROJECT_PROPERTY_FILE = "project.properties";

    static Properties properties = null;

    static void loadPropertiesIfNotLoadedAlready() {

        if(properties == null) {
            properties = new Properties();
            String propertyFilePath = System.getProperty("user.dir") + "/src/test/resources/" + PROJECT_PROPERTY_FILE;
            try {
                InputStream inputStream = new FileInputStream(propertyFilePath);
                properties.load(inputStream);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    public static String getProperty(String name) {
        loadPropertiesIfNotLoadedAlready();
        return properties.getProperty(name);
    }

}

