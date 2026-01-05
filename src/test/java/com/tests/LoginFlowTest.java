package com.tests;

import com.listener.MyRetryAnalyzer;
import com.pages.HomePage;
import com.pages.LoginPage;
import org.pojos.User;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginFlowTest extends BaseTest {

    HomePage homePage;

/*    @Test(testName = "Login Test",
            description = "verifies the user is able to login",
            groups = {"e2e"},
            dataProviderClass = com.dataProvider.BrowserWrappedDataProvider.class,
    dataProvider = "LoginJsonWithBrowser",
            retryAnalyzer = MyRetryAnalyzer.class)
    public void user_should_login_json(User user,String browser){
        homePage = new LoginPage(driver)
                .navigateToLoginPage()
                .gotoHomePage(
                        user.getUsername(),user.getPassword()
                );
        Assert.assertEquals(homePage.getPageTitle(),"Abc test");
    }

    @Test(testName = "Login Test",
            description = "verifies the user is able to login",
            groups = {"e2e"},
            dataProviderClass = com.dataProvider.BrowserWrappedDataProvider.class,
            dataProvider = "LoginCSVWithBrowser",
            retryAnalyzer = MyRetryAnalyzer.class)
    public void user_should_login_csv(User user,String browser){
        homePage = new LoginPage(driver)
                 .navigateToLoginPage()
                .gotoHomePage(
                        user.getUsername(),user.getPassword()
                );
        Assert.assertEquals(homePage.getPageTitle(),"Abc test");
    }*/

   @Test(testName = "Login Test",
            description = "verifies the user is able to login",
            groups = {"e2e"},
            dataProviderClass = com.dataProvider.BrowserWrappedDataProvider.class,
            dataProvider = "LoginExcelWithBrowser",
            retryAnalyzer = MyRetryAnalyzer.class)

    public void user_should_login_excel(User user,String browser){
        homePage = new LoginPage(driver)
                .navigateToLoginPage()
                .gotoHomePage(
                        user.getUsername(),user.getPassword()
                );
        Assert.assertEquals(homePage.getPageTitle(),"Abc test");

    }
}
