package com.utils;

import com.github.javafaker.Faker;
import org.pojos.Address;

import java.util.Locale;

public class FakerUtil {

    Faker faker = new Faker(Locale.US);
    Address addressPojo ;
    public Address fakerAddress(){
        addressPojo= new Address(faker.company().name(),
                faker.address().buildingNumber(),
                faker.address().streetAddress(),
                faker.address().city(),
                faker.numerify("#####"),
               // faker.address().country(),
                faker.phoneNumber().cellPhone(),
                faker.phoneNumber().cellPhone(),
                "Other",
                "Office address",
                "California");

        return addressPojo;
    }

}
