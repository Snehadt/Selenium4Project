package com.tests;

import com.listener.MyRetryAnalyzer;
import com.listener.MyTestListner;
import com.pages.HomePage;
import com.pages.LoginPage;
import org.pojos.User;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


public class LoginFlowTest extends BaseTest {

    HomePage homePage;

    @Test(testName = "Login Test",
            description = "verifies the user is able to login",
            groups = {"e2e"},
            dataProviderClass = com.dataProvider.LoginDataProvider.class,
    dataProvider = "LoginTestDataProvider")
    public void user_should_login_json(User user){
        homePage = new LoginPage(driver)
                .gotoHomePage(
                        user.getUsername(),user.getPassword()
                );
        Assert.assertEquals(homePage.getPageTitle(),"Abc test");
    }

    @Test(testName = "Login Test",
            description = "verifies the user is able to login",
            groups = {"e2e"},
            dataProviderClass = com.dataProvider.LoginDataProvider.class,
            dataProvider = "LoginCSVDataProvider")
    public void user_should_login_csv(User user){
        homePage = new LoginPage(driver)
                .gotoHomePage(
                        user.getUsername(),user.getPassword()
                );
        Assert.assertEquals(homePage.getPageTitle(),"Abc test");
    }

    @Test(testName = "Login Test",
            description = "verifies the user is able to login",
            groups = {"e2e"},
            dataProviderClass = com.dataProvider.LoginDataProvider.class,
            dataProvider = "LoginExcelDataProvider",
    retryAnalyzer = MyRetryAnalyzer.class)

    public void user_should_login_excel(User user){
        homePage = new LoginPage(driver)
                .gotoHomePage(
                        user.getUsername(),user.getPassword()
                );
        Assert.assertEquals(homePage.getPageTitle(),"Abc test");

    }
}
