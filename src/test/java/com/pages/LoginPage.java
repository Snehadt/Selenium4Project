package com.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.configReader.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    private static final Logger log = LogManager.getLogger(LoginPage.class);

    public LoginPage(WebDriver driver){
        super(driver);
    }

    private By SignIn_btn = By.className("login");
    private By username_txt = By.id("email");
    private By password_txt = By.id("passwd");
    private By submit_btn = By.id("SubmitLogin");
    private By authentication_msg = By.xpath(".//div[contains(@class,'alert-danger')]");

    public LoginPage navigateToLoginPage(){
        driver.get(ConfigReader.get("url"));
        return this;
    }

    public LoginPage clickSignIn() throws InterruptedException {
        Thread.sleep(2000);
        click(SignIn_btn);
        return this;
    }

    public LoginPage enterUserNamePassword(String username , String password){
        sendKey(username_txt,username);
        sendKey(password_txt,password);
        click(submit_btn);
        return this;
    }
    public MyAccountPage gotoHomePage(String username , String password) throws InterruptedException {
        log.info("click on sign in btn");
        clickSignIn();
        log.info("enter username and password");
        enterUserNamePassword(username,password);
        return new MyAccountPage(driver);
    }

    public String authenticationMsg(){
        int attempts = 0;
        while (attempts < 5) { // try 5 times
            try {
                // always refind the element here
                if (driver.findElements(authentication_msg).size() > 0) {
                    return getTextMsg(authentication_msg);
                } else {
                    return "";
                }
            } catch (org.openqa.selenium.StaleElementReferenceException e) {
                attempts++;
                try { Thread.sleep(500); } catch (InterruptedException ignored) {}
            }
        }
        return "";
       // return getTextMsg(authentication_msg);
    }

    public boolean authenticationMsgisDisplayed() throws InterruptedException {
        return isElementVisible(authentication_msg);
    }
}
