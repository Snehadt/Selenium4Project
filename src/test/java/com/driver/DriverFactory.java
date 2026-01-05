package com.driver;

import org.configReader.ConfigReader;
import org.enums.BrowserType;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

public class DriverFactory {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private DriverFactory() {}
    public static void initDriver(String browser) {
        BrowserType browserType =
                BrowserType.valueOf(browser.toUpperCase());
        initDriver(browserType);
    }

    public static void initDriver(BrowserType browser) {
        if (driver.get() == null) {
            System.out.println("The environment is :"+ConfigReader.get("env"));
            WebDriver webDriver = ConfigReader.get("env").equalsIgnoreCase("lambda")
                    ? LambdaDriverFactory.getRemoteDriver(browser)
                    : LocalDriverFactory.getLocalDriver(browser);

            driver.set(webDriver);
            driver.get().manage().window().setSize(new Dimension(1920, 1080));
        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
