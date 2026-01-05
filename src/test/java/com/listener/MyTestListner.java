package com.listener;

import com.dataUtils.LoggerUtility;
import com.driver.DriverFactory;
import com.utils.ScreenshotUtil;
import io.qameta.allure.Allure;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.IRetryAnalyzer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;

public class MyTestListner implements ITestListener {
    private static final Logger log= LoggerUtility.getLogger(MyTestListner.class);

    public void onTestStart(ITestResult result) {
        log.info("STARTED: " + result.getMethod().getMethodName());
        if (result.getMethod().getDescription() != null) {
            log.info("Description: " + result.getMethod().getDescription());
        }
        log.info("Groups: " + String.join(", ", result.getMethod().getGroups()));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("PASSED: " + result.getMethod().getMethodName());
        safeQuitDriver();

    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.error("FAILED: " + result.getMethod().getMethodName());

        WebDriver driver = DriverFactory.getDriver();

        // Capture screenshot
        if (driver != null) {
            byte[] screenshot = ScreenshotUtil.captureScreenshot(driver);
            if (screenshot != null) {
                Allure.addAttachment(
                        "Failure Screenshot",
                        "image/png",
                        new ByteArrayInputStream(screenshot),
                        ".png"
                );
            }
        }
        // Capture exception
        if (result.getThrowable() != null) {
            Allure.addAttachment(
                    "Failure Reason",
                    result.getThrowable().toString()
            );
        }

        safeQuitDriver();

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.warn("SKIPPED: " + result.getMethod().getMethodName());
        if (result.getThrowable() != null) {
            log.warn("Reason: " + result.getThrowable().getMessage());
        }
        safeQuitDriver();
    }

    @Override
    public void onStart(ITestContext context) {
        log.info("Test Suite Started");
    }

    @Override
    public void onFinish(ITestContext context) {
        log.info("Test Suite Finished: " + context.getName());
    }

    private void safeQuitDriver() {
        try {
            WebDriver driver = DriverFactory.getDriver();
            if (driver != null) {
                driver.quit();
                DriverFactory.quitDriver(); // make sure thread-local is cleared
            }
        } catch (Exception e) {
            log.error("Error quitting driver: " + e.getMessage());
        }
    }
}
