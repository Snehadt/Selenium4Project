package com.tests;

import com.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.pojos.User;

public class CommonTest extends BaseTest {

    LoginPage loginPage;

    public CommonTest(WebDriver driver) {
        this.driver = driver;
    }

    public void loginToapp(User user, String browser) throws InterruptedException {
        loginPage = new LoginPage(driver)
                .navigateToLoginPage()
                .clickSignIn()
                .enterUserNamePassword(user.getUsername(), user.getPassword());
    }
}
