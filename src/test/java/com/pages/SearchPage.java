package com.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchPage extends BasePage{

    private static final Logger log = LogManager.getLogger(LoginPage.class);
    private By productList = By.xpath("//h5[@itemprop='name']");
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getAllproductList(){
        log.info("Get the product list");
        List<String> productsList = new ArrayList<>();
        List<WebElement> ele = getTheProductList(productList);

        for(WebElement e : ele) {
            productsList.add(getTextMsgs(e));
        }
        return productsList;
    }
public boolean validateTheProductList(String productName){
    List<String> productSearched = Arrays.asList(productName.toLowerCase().split(" "));
    List<String> st = getAllproductList();
    return st.stream().anyMatch(name -> (productSearched.stream().anyMatch(name.toLowerCase()::contains)));
}
}
