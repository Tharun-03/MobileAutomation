package com.amazon.framework;

import io.appium.java_client.android.AndroidDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public abstract class BaseTestCase {

    protected AndroidDriver driver;
    protected Properties properties;
    protected String testCaseName;
    protected HashMap<String, HashMap<String, String>> testDataMap;

    @BeforeSuite
    public void beforeSuite() {
        System.setProperty("org.uncommons.reportng.escape-output", "false");
    }

    @BeforeTest
    public void initialization(final ITestContext testContext) {
        properties = Settings.getInstance();
        driver = DriverFactory.getDriver();
        testDataMap = TestData.getInstance();
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(properties.getProperty("ImplicitWaitTime")),
                TimeUnit.SECONDS);
        testCaseName=testContext.getName();
    }

    @AfterTest
    public void cleanup() {
        try {
            if (driver != null)
                driver.quit();
        } catch (Exception ex) {
            System.out.println("Exception occurred in cleanup" + ex);
        }
    }

    @AfterSuite
    public void afterSuite() {
    }

    public String testData(String field) {
        return TestData.testData(testCaseName, field);
    }
}
