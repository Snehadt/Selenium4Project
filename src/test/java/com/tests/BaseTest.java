package com.tests;

import com.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;
    String browser = "";
    @BeforeMethod
    public void setUp(Object[] testData){
        if (testData != null
                && testData.length > 0
                && testData[testData.length - 1] instanceof String) {

            browser = (String) testData[testData.length - 1];
        }
        DriverFactory.initDriver(browser);
        driver = DriverFactory.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        //DriverFactory.quitDriver();
    }
}
