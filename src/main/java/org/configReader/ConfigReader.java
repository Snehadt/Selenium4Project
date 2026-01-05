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
            String envName = System.getProperty(
                    "env",                                  // mvn -Denv=dev
                    properties.getProperty("env", "qa")   // fallback
            );
            EnvironmentType env =
            EnvironmentType.valueOf(envName.toUpperCase());

            String envFilePath = System.getProperty("user.dir")+"/src/test/resources/config-" +
                    env.name().toLowerCase() + ".properties";

            FileInputStream envFis = new FileInputStream(envFilePath);
            properties.load(envFis);
            properties.setProperty("env", env.name().toLowerCase());
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    public static String get(String key) {
        String systemValue = System.getProperty(key);
        if (systemValue != null) {
            return systemValue;
        }
        return properties.getProperty(key);
    }

    public static boolean isHeadless() {
        return Boolean.parseBoolean(get("headless"));
    }

    public static BrowserType getBrowser(){
        return BrowserType.valueOf(get("browser").toUpperCase());
    }

    // LambdaTest helpers
    public static boolean isLambda() {
        return get("env").equalsIgnoreCase("lambda");
    }
public static String getLambdaUsername() { return properties.getProperty("lt.username"); }
public static String getLambdaAccessKey() { return properties.getProperty("lt.accesskey"); }
public static String getLambdaPlatform() { return properties.getProperty("lt.platform"); }
public static String getLambdaBrowserVersion() { return properties.getProperty("lt.browserVersion"); }
public static String getLambdaBuildName() { return properties.getProperty("lt.buildName"); }
public static String getLambdaTestName() { return properties.getProperty("lt.testName"); }
}