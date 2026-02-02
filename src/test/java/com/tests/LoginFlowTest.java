package com.tests;

import com.pages.MyAccountPage;
import com.pages.LoginPage;
import org.pojos.User;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginFlowTest extends BaseTest {

    MyAccountPage homePage;
    LoginPage loginPage;

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
            dataProvider = "LoginExcel_AllLoginUsers")
           // retryAnalyzer = MyRetryAnalyzer.class)

    public void user_should_login_excel(User user,String browser) throws InterruptedException {
        loginPage = new LoginPage(driver)
                .navigateToLoginPage()
                .clickSignIn()
                .enterUserNamePassword(user.getUsername(), user.getPassword());
            if(loginPage.authenticationMsgisDisplayed()) {
                Assert.assertEquals(loginPage.authenticationMsg(), "There is 1 error\n" +
                        "Authentication failed.");
                return;
            }
            Thread.sleep(3000);
                homePage = new MyAccountPage(driver);
                Assert.assertEquals(homePage.getPageTitle(), "Abc test");
            }

}
