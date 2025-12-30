package org.configReader;

import org.enums.BrowserType;
import org.enums.EnvironmentType;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;


    static {
        try {
            FileInputStream fis = new FileInputStream(
                    System.getProperty("user.dir")+"/src/test/resources/config.properties"
            );
            properties = new Properties();
            properties.load(fis);
            EnvironmentType env =
            EnvironmentType.valueOf(properties.getProperty("env").toUpperCase());

            String envFilePath = System.getProperty("user.dir")+"/src/test/resources/config-" +
                    env.name().toLowerCase() + ".properties";

            FileInputStream envFis = new FileInputStream(envFilePath);
            properties.load(envFis);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }

    public static boolean isHeadless() {
        return Boolean.parseBoolean(properties.getProperty("headless"));
    }

    public static BrowserType getBrowser(){
        return BrowserType.valueOf(get("browser").toUpperCase());
    }
}
