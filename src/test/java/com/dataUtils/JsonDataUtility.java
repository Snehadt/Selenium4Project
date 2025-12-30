package com.dataUtils;

import com.google.gson.Gson;
import org.pojos.LoginTestData;
import org.pojos.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JsonDataUtility {
    public static Iterator<Object[]> jsonReader(String fileName){
        try {
            Gson gson = new Gson();
            File testDatafile = new File(
                    System.getProperty("user.dir") + "/src/test/resources/testData/"+fileName);
            FileReader fileReader = new FileReader(testDatafile);
            LoginTestData loginTestData = gson.fromJson(fileReader, LoginTestData.class);
            List<Object[]> dataToReturn = new ArrayList<>();
            for (User datas : loginTestData.getData()) {
                dataToReturn.add(new Object[]{datas});
            }
            return dataToReturn.iterator();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
