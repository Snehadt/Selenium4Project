package com.tests;

import com.pages.MyAccountPage;
import com.pages.SearchPage;
import org.pojos.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest{

    SearchPage productPage;
    CommonTest commonTest;
    private static final String PRODUCT_SEARCH= "Printed Dress";

    @Test(testName = "search the products",
            dataProviderClass = com.dataProvider.BrowserWrappedDataProvider.class,
            dataProvider = "LoginExcel_ValidLoginUsers")
    public void getTheProducts(User user, String browser) throws InterruptedException {
        commonTest = new CommonTest(driver);
        commonTest.loginToapp(user,browser);

        productPage = new MyAccountPage(driver).clickSearch(PRODUCT_SEARCH);
        boolean result = productPage.validateTheProductList(PRODUCT_SEARCH);
        Assert.assertTrue(result);

    }
}
