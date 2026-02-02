package com.dataProvider;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class BrowserWrappedDataProvider {

    private static List<String> getBrowsers() {
        String browserProp = System.getProperty("browser", "chrome");
        return Arrays.stream(browserProp.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    /* ---------- JSON ---------- */

    @DataProvider(name = "LoginJsonWithBrowser", parallel = true)
    public static Iterator<Object[]> loginJsonWithBrowser() {

        Iterator<Object[]> baseData =
                new LoginDataProvider().loginDataProvider();

        return wrapIterator(baseData);
    }

    /* ---------- CSV ---------- */

    @DataProvider(name = "LoginCSVWithBrowser", parallel = true)
    public static Iterator<Object[]> loginCsvWithBrowser() {

        Iterator<Object[]> baseData =
                new LoginDataProvider().csvDataProvider();

        return wrapIterator(baseData);
    }

    /* ---------- EXCEL ---------- */

    @DataProvider(name = "LoginExcel_ValidLoginUsers", parallel = true)
    public static Iterator<Object[]> validLoginUsers() {

        Iterator<Object[]> baseData =
                new LoginDataProvider().excelDataProvider("login_valid");

        return wrapIterator(baseData);
    }

    @DataProvider(name = "LoginExcel_AllLoginUsers", parallel = true)
    public static Iterator<Object[]> allLoginUsers() {

        Iterator<Object[]> baseData =
                new LoginDataProvider().excelDataProvider("login_all");

        return wrapIterator(baseData);
    }

    /* ---------- WRAPPERS ---------- */

    private static Iterator<Object[]> wrapIterator(Iterator<Object[]> baseData) {

        List<Object[]> finalData = new ArrayList<>();
        List<String> browsers = getBrowsers();

        while (baseData.hasNext()) {
            Object[] row = baseData.next();
            for (String browser : browsers) {
                Object[] newRow = Arrays.copyOf(row, row.length + 1);
                newRow[row.length] = browser;
                finalData.add(newRow);
            }

        }
        return finalData.iterator();
    }
}
