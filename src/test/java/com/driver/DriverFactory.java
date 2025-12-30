package com.driver;

import org.configReader.ConfigReader;
import org.enums.BrowserType;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    private DriverFactory() {
    }

    public static void initDriver(BrowserType browser) {
        boolean isHeadless = ConfigReader.isHeadless();
        if (driver.get() == null) {

            switch (browser) {
                case CHROME:
                    ChromeOptions chromeOptions = new ChromeOptions();
                    if(isHeadless){
                        chromeOptions.addArguments("--headless=new");
                        chromeOptions.addArguments("--disable-gpu");
                    }
                    driver.set(new ChromeDriver(chromeOptions));
                    break;

                case FIREFOX:
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    if (isHeadless) {
                        firefoxOptions.addArguments("-headless");
                    }
                    driver.set(new FirefoxDriver(firefoxOptions));
                    break;

                case EDGE:
                    EdgeOptions edgeOptions = new EdgeOptions();
                    if (isHeadless) {
                        edgeOptions.addArguments("--headless=new");
                    }
                    driver.set(new EdgeDriver(edgeOptions));
                    break;

                default:
                    throw new IllegalArgumentException("unsupported browser :" + browser);
            }
        }

       // driver.get().manage().window().maximize();
        driver.get().manage().window().setSize(new Dimension(1920, 1080));
    }

    public static WebDriver getDriver(){
        return driver.get();
    }

    public static void quitDriver(){
        if(driver != null){
            driver.get().quit();
            driver.remove();
        }
    }
}
