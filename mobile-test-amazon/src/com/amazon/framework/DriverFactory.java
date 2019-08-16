package com.amazon.framework;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.util.Properties;

public class DriverFactory {

    private static AndroidDriver driver;

    private DriverFactory() {
    }

    public static AndroidDriver getDriver() {
        Properties properties = Settings.getInstance();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", properties.getProperty("deviceName"));
        capabilities.setCapability("platformName", properties.getProperty("platformName"));
        capabilities.setCapability("platformVersion", properties.getProperty("platformVersion"));
        capabilities.setCapability("appPackage",properties.getProperty("appPackage"));
        capabilities.setCapability("appActivity", properties.getProperty("appActivity"));
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("app", Utilities.getRelativePath()+"/"+
                properties.getProperty("app"));
        System.out.println("Desired capabilities setup done -- " + capabilities);

        try {
            String host = properties.getProperty("appium.host");
            int port = Integer.parseInt(properties.getProperty("appium.port"));
            driver = new AndroidDriver(new URL("http://" + host + ":" + port + "/wd/hub"), capabilities);
            System.out.print("App Launched successfully");
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return driver;
    }
}
