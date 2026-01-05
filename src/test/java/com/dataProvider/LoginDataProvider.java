package com.dataProvider;

import com.dataUtils.CsvDataUtility;
import com.dataUtils.ExcelDataUtility;
import com.dataUtils.JsonDataUtility;
import org.pojos.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;


public class LoginDataProvider {

    @DataProvider(name = "LoginTestDataProvider")
    public Iterator<Object[]> loginDataProvider() {
       return JsonDataUtility.jsonReader("login-data.json");
    }

    @DataProvider(name = "LoginCSVDataProvider")
    public Iterator<Object[]> csvDataProvider(){
        Iterator<User> userIterator =
        CsvDataUtility.csvreader("login-file.csv");
        List<Object[]> wrappedData = new ArrayList<>();

        while (userIterator.hasNext()) {
            wrappedData.add(new Object[]{userIterator.next()});
        }

        return wrappedData.iterator();
    }

    @DataProvider(name = "LoginExcelDataProvider")
    public Iterator<Object[]> excelDataProvider(){
        Iterator<User> userIterator =
                ExcelDataUtility.excelReader("login-excel.xlsx");

        List<Object[]> wrappedData = new ArrayList<>();

        while (userIterator.hasNext()) {
            wrappedData.add(new Object[]{userIterator.next()});
        }
        return wrappedData.iterator();
    }
}
