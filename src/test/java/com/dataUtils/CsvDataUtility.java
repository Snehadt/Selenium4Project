package com.dataUtils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.pojos.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CsvDataUtility {

    public static Iterator<User> csvreader(String filename) {
        File csvFile = new File(System.getProperty("user.dir") + "/src/test/resources/testData/" + filename);
        FileReader fl = null;
        CSVReader csvReader = null;
        String[] data = null;
        List<User> userList = null;
        User user;
        try {
            fl = new FileReader(csvFile);
            csvReader = new CSVReader(fl);
            csvReader.readNext();
            userList = new ArrayList<>();
            while ((data = csvReader.readNext()) != null) {
                user = new User(data[0], data[1]);
                userList.add(user);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException(e);
        }
        return userList.iterator();
    }
}
