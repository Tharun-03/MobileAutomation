package com.amazon.pages;

import com.amazon.framework.BasePage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class DeliveryAddressPage extends BasePage {
    public DeliveryAddressPage(AndroidDriver driver) {
        super(driver);
    }

    By deliveryAddressTitle = By.xpath("//*[@text='Enter a delivery address']");


    public void waitforDeliveryAddressPage(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(deliveryAddressTitle)));
        Reporter.log("Delivery Address Page launched");
        Assert.assertEquals(driver.findElement(deliveryAddressTitle).getText(),
                "Select a delivery address");
        Reporter.log(reportScreenShot());
    }
}
