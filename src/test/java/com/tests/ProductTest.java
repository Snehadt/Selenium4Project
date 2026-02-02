package com.tests;

import com.pages.MyAccountPage;
import com.pages.SearchPage;
import org.pojos.User;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest{

    SearchPage productPage;
    CommonTest commonTest;
    private static final String PRODUCT_SEARCH= "Printed Dress";

    @Test(testName = "Producttest",
            dataProviderClass = com.dataProvider.BrowserWrappedDataProvider.class,
            dataProvider = "LoginExcel_ValidLoginUsers")
    public void searchProduct(User user, String browser) throws InterruptedException {
        commonTest = new CommonTest(driver);
        commonTest.loginToapp(user,browser);

        productPage = new MyAccountPage(driver).clickSearch(PRODUCT_SEARCH);

    }
}
