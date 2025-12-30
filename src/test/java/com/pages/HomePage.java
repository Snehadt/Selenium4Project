package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    private  By page_title = By.className("account");
    public HomePage(WebDriver driver){
        super(driver);
    }
    public String getPageTitle(){
        waitForvisibility(page_title);
        return driver.findElement(page_title).getText();
    }


}
