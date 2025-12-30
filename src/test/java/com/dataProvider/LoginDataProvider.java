package com.dataProvider;

import com.dataUtils.CsvDataUtility;
import com.dataUtils.ExcelDataUtility;
import com.dataUtils.JsonDataUtility;
import org.pojos.User;

import java.util.Iterator;

import org.testng.annotations.DataProvider;


public class LoginDataProvider {

    @DataProvider(name = "LoginTestDataProvider")
    public Iterator<Object[]> loginDataProvider() {
       return JsonDataUtility.jsonReader("login-data.json");
    }

    @DataProvider(name = "LoginCSVDataProvider")
    public Iterator<User> csvDataProvider(){
        return CsvDataUtility.csvreader("login-file.csv");
    }

    @DataProvider(name = "LoginExcelDataProvider")
    public Iterator<User> excelDataProvider(){
        return ExcelDataUtility.excelReader("login-excel.xlsx");
    }
}
