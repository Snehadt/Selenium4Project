package com.listener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetryAnalyzer implements IRetryAnalyzer {
    private final static int MAX_NUMBER_OF_ATTEMPTS = 2;
    private int current_attempt = 1;
    @Override
    public boolean retry(ITestResult iTestResult) {
        if(current_attempt <= MAX_NUMBER_OF_ATTEMPTS) {
            current_attempt++;
            return true;
        }
        return false;
    }
}
