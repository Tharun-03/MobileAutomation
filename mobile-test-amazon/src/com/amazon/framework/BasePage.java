package com.amazon.framework;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;

public class BasePage {

    protected AndroidDriver driver;
    protected Properties properties=Settings.getInstance();
    protected HashMap<String, HashMap<String, String>> testDataMap = TestData.getInstance();

    public BasePage(AndroidDriver driver) {
        this.driver = driver;
    }

    public String takeScreenshot() {
        String fileName = "screen_" + new SimpleDateFormat("yyyyMMdd_hhmmssSSS").format(new Date()) + ".png";
        fileName = Utilities.getRelativePath() + properties.getProperty("ScreenShotPath")+
                "\\" + fileName;

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(fileName), true);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return fileName;
    }

    public String reportScreenShot() {
        String screenShot = takeScreenshot();
        screenShot = "<img src='"+screenShot+"' height='200'>";
        return screenShot;
    }

    public void scrollDown(By element) {

        Dimension size = driver.manage().window().getSize();
        int startx = size.width / 2;
        int starty = size.height / 2;
        int endx = size.width / 2;
        int endy = size.height / 4;

        for (int i = 0; i < 10; i++)
            try {
                driver.findElement(element);
                return;
            } catch (Exception ex) {
                TouchAction action = new TouchAction(driver).press(PointOption.point(startx, starty)).
                        waitAction().
                        moveTo(PointOption.point(endx, endy)).
                        release().
                        perform();
                driver.performTouchAction(action);
            }
    }

    public void scrollUp(By element) {
        Dimension size = driver.manage().window().getSize();
        int startx = size.width / 2;
        int starty = size.height / 2;
        int endx = size.width / 2;
        int endy = (int) ((double) size.height * 0.80000000000000004D);
        for (int i = 0; i < 10; i++)
            try {
                driver.findElement(element);
                return;
            } catch (Exception ex) {
                TouchAction action = new TouchAction(driver).press(PointOption.point(startx, starty)).
                        waitAction().
                        moveTo(PointOption.point(endx, endy)).
                        release().
                        perform();
                driver.performTouchAction(action);
            }
    }


}
