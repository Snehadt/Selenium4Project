package com.tests;

import com.driver.DriverFactory;
import org.configReader.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp(){
        DriverFactory.initDriver(ConfigReader.getBrowser());
        driver = DriverFactory.getDriver();
        driver.get(ConfigReader.get("url"));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        DriverFactory.quitDriver();
    }
}
