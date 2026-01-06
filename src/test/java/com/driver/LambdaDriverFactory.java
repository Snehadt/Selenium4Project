package com.driver;
import org.configReader.ConfigReader;
import org.enums.BrowserType;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class LambdaDriverFactory {
    private LambdaDriverFactory(){}

    public static WebDriver getRemoteDriver(BrowserType browser) {
        try {
            String username = System.getenv("LT_USERNAME");
            String accessKey = System.getenv("LT_ACCESS_KEY");

            MutableCapabilities capabilities = new MutableCapabilities();
            String platform = ConfigReader.get("lt.platform");
            if (platform != null) {
                capabilities.setCapability("platformName", ConfigReader.get("lt.platform"));
            }
            capabilities.setCapability("browserName",mapBrowser(browser));
            capabilities.setCapability("browserVersion", ConfigReader.get("lt.browserVersion"));

            Map<String, Object> ltOptions = new HashMap<>();
            ltOptions.put("build", ConfigReader.get("lt.buildName"));
            ltOptions.put("selenium_version",
                    new org.openqa.selenium.BuildInfo().getReleaseLabel());
            ltOptions.put("name",
                    Thread.currentThread().getName() + " - " + browser.name());
            ltOptions.put("w3c", true);
            ltOptions.put("console", true);
            ltOptions.put("network", true);
            ltOptions.put("visual", true);
            capabilities.setCapability("LT:Options", ltOptions);

            String hubUrl = "https://" + username + ":" + accessKey + "@hub.lambdatest.com/wd/hub";
            System.out.println("Creating remote");
            return new RemoteWebDriver(new URL(hubUrl), capabilities);

        } catch (MalformedURLException e) {
            throw new RuntimeException("Failed to initialize LambdaTest driver", e);
        }
    }
    private static String mapBrowser(BrowserType browser) {
        switch (browser) {
            case CHROME:
                return "chrome";
            case FIREFOX:
                return "firefox";
            case EDGE:
                return "MicrosoftEdge";
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }
}