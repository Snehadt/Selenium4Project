package com.listener;

import com.dataUtils.LoggerUtility;
import com.driver.DriverFactory;
import com.utils.ScreenshotUtil;
import io.qameta.allure.Allure;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;

public class MyTestListner implements ITestListener {
    Logger log= LoggerUtility.getLogger(this.getClass());

    public void onTestStart(ITestResult result) {
        log.info(result.getMethod().getMethodName());
        log.info(result.getMethod().getDescription());
        log.info(result.getMethod().getGroups());
    }

    public void onTestSuccess(ITestResult result) {
        log.info(result.getMethod().getMethodName()+ " "+"PASSED");

    }

    public void onTestFailure(ITestResult result) {
        log.error(result.getMethod().getMethodName()+ " "+"FAILED");

        WebDriver driver = DriverFactory.getDriver();
        if (driver != null) {
            byte[] screenshot = ScreenshotUtil.captureScreenshot(driver);
            if (screenshot.length > 0) {
                Allure.addAttachment("Failure Screenshot", new ByteArrayInputStream(screenshot));
            }
        }

        if (result.getThrowable() != null) {
            Allure.addAttachment("Failure Reason", result.getThrowable().toString());
            log.error(result.getThrowable().getMessage());
        }
    }

    public void onTestSkipped(ITestResult result) {
        log.warn(result.getThrowable().getMessage()+" "+"SKIPPED");
        if (result.getThrowable() != null) {
            Allure.addAttachment("Skip Reason", result.getThrowable().toString());
        }
    }

    public void onStart(ITestContext context) {
        log.info("Test Suite Started");
    }

    public void onFinish(ITestContext context) {
        log.info("Test Suite Completed");
    }
}
