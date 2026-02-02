package com.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;


    public BasePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected void click(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator))
                .click();
    }

    protected void sendKey(By locator,String text){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator))
                .sendKeys(text);
    }

    protected void sendKeyEnter(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator))
                .sendKeys(Keys.ENTER);
    }

    protected boolean waitForvisibility(By locator){
         wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return false;
    }

    protected String getTextMsg(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }

    protected boolean isElementVisible(By locator) {
        int attempts = 0;
        while (attempts < 10) { // try 10 times
            if (driver.findElements(locator).size() > 0) {
                return true; // element found
            }
            try {
                Thread.sleep(500); // small wait between attempts
            } catch (InterruptedException e) {
            }
            attempts++;
        }
        return false;
    }

    protected List<WebElement> getTheProductList(By locator){
        return Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOfElementLocated(locator)))
                .findElements(locator);
    }

    protected String getTextMsgs(WebElement locator){
        return wait.until(ExpectedConditions.visibilityOf(locator)).getText();
    }

    protected void selectDropdown(By locator,String text) {
        WebElement element = driver.findElement(locator);
        click(locator);
        sendKey(locator,"ca");
        sendKeyEnter(locator);
    }

}
