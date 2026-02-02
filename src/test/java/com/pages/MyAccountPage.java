package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends BasePage{

    private By accountName = By.className("account");
    private By searchbar = By.id("search_query_top");
    private By search_submit = By.name("submit_search");
    private By add_my_address = By.xpath(".//a[@title='Add my first address']");

    public MyAccountPage(WebDriver driver){
        super(driver);
    }
    public String getPageTitle(){
        try {
            waitForvisibility(accountName);
            return driver.findElement(accountName).getText();
        }
        catch (TimeoutException e){
            System.out.println("Account element not visible. Login may have failed or page not loaded yet.");
            return "";
        }
    }

    public SearchPage clickSearch(String productSearch){
        waitForvisibility(searchbar);
        click(searchbar);
        sendKey(searchbar, productSearch);
        sendKeyEnter(searchbar);
        return new SearchPage(driver);
    }

    public AddressPage clickMyAddress(){
        click(add_my_address);
        return new AddressPage(driver);
    }


}
