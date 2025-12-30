package com.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    public LoginPage clickSignIn(){
        click(SignIn_btn);
        return this;
    }

    public LoginPage enterUserNamePassword(String username , String password){
        sendKey(username_txt,username);
        sendKey(password_txt,password);
        click(submit_btn);
        return this;
    }
    public HomePage gotoHomePage(String username , String password){
        log.info("click on sign in btn");
        clickSignIn();
        log.info("enter username and password");
        enterUserNamePassword(username,password);
        return new HomePage(driver);
    }
}
