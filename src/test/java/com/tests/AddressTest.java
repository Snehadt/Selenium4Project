package com.tests;

import com.github.javafaker.Faker;
import com.pages.AddressPage;
import com.pages.MyAccountPage;
import com.pages.SearchPage;
import com.utils.FakerUtil;
import org.pojos.User;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Locale;

public class AddressTest extends BaseTest{

    SearchPage productPage;
    CommonTest commonTest;
    MyAccountPage myAccountPage;
    AddressPage addressPage;
    FakerUtil fakerUtil = new FakerUtil();

    @Test(testName = "search the products",
            dataProviderClass = com.dataProvider.BrowserWrappedDataProvider.class,
            dataProvider = "LoginExcel_ValidLoginUsers")
    public void selectAddress(User user, String browser) throws InterruptedException {
        commonTest = new CommonTest(driver);
        commonTest.loginToapp(user,browser);
        myAccountPage = new MyAccountPage(driver);
        myAccountPage.clickMyAddress();
        addressPage = new AddressPage(driver);
        addressPage.enterAddressDetails(fakerUtil.fakerAddress()).clickSubmitAddress();



    }
}
