package com.dataUtils;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.pojos.User;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelDataUtility {

    public static Iterator<User> excelReader(String filename){
        File excelFile;
        XSSFWorkbook xssfWorkbook;
        Iterator<Row> rowIterator;
        Row row;
        Cell username;
        Cell password;
        List<User> ll ;
        User user;
        excelFile = new File(System.getProperty("user.dir") + "/src/test/resources/testData/" + filename);
        try {
            xssfWorkbook = new XSSFWorkbook(excelFile);
            XSSFSheet xssfSheet = xssfWorkbook.getSheet("logindata");
            rowIterator = xssfSheet.iterator();
            rowIterator.next();
            ll = new ArrayList<>();
            while(rowIterator.hasNext()){
                row = rowIterator.next();
                username = row.getCell(0);
                password = row.getCell(1);
                 user = new User(username.toString(),password.toString());
                ll.add(user);
            }
            return ll.iterator();
        } catch (IOException | InvalidFormatException e) {
            throw new RuntimeException(e);
        }


    }
}
