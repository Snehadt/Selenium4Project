package com.pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.pojos.Address;

import java.util.Locale;

public class AddressPage extends BasePage{

    private By company = By.id("company");
    private By address1 = By.id("address1");
    private By address2 = By.id("address2");
    private By city = By.id("city");
    private By state = By.id("id_state");
    private By zip = By.id("postcode");
    private By country = By.id("id_country");
    private By phoneNum = By.id("phone");
    private By mobileNum = By.id("phone_mobile");
    private By additionalInfo = By.id("other");
    private By alias = By.id("alias");
    private By submitAddress = By.id("submitAddress");

    Faker faker = new Faker(Locale.US);
    public AddressPage(WebDriver driver) {
        super(driver);
    }

    public AddressPage enterAddressDetails(Address addressPojo){
        sendKey(company, addressPojo.getCompany());
        sendKey(address1, addressPojo.getAddress());
        sendKey(address2, addressPojo.getAddress_line2());
        sendKey(city, addressPojo.getCity());

        sendKey(zip, addressPojo.getZip());
        //sendKey(country, addressPojo.getCountry());
        sendKey(phoneNum,addressPojo.getHome_phone());
        sendKey(mobileNum,addressPojo.getMobile_phone());
        sendKey(additionalInfo,addressPojo.getAdditional_info());
        sendKey(alias,addressPojo.getAssign_address());
        selectDropdown(state, addressPojo.getState());
        return this;

    }

    public AddressPage clickSubmitAddress(){
        click(submitAddress);
        return this;
    }

}
