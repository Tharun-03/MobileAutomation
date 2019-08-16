package com.amazon.pages;

import com.amazon.framework.BasePage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;

public class ItemPage extends BasePage {
    public ItemPage(AndroidDriver driver) {
        super(driver);
    }

    By buyNowBtn = By.xpath("//*[@resource-id='buyNowCheckout']");


    public void scrollAndTapBuyNow(String modelnumber){
        boolean isItemFound = driver.findElement(By.xpath("//*[contains(@text,'"+modelnumber+"')]")).isDisplayed();
        Assert.assertEquals(isItemFound, true);
        Reporter.log("Expected Item is selected and displayed on screen");
        Reporter.log(reportScreenShot());

        scrollDown(buyNowBtn);
        Reporter.log((reportScreenShot()));

        driver.findElement(buyNowBtn).click();
        Reporter.log("Buy Now Button is clicked");
    }
}
