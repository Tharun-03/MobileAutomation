package com.amazon.pages;

import com.amazon.framework.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.testng.Reporter;

public class SearchPage extends BasePage {
    public SearchPage(AndroidDriver driver) {
        super(driver);
    }

    By searchField = By.id("rs_search_src_text");


    public void searchItem(String item, String model){
        driver.findElement(searchField).click();
        driver.findElement(searchField).sendKeys(item);
        Reporter.log("Search Value enterted");
        Reporter.log(reportScreenShot());
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));

        By searchItem = By.xpath("//*[contains(@text,'"+ model +"')]");
        scrollDown(searchItem);
        Reporter.log((reportScreenShot()));

        driver.findElement(searchItem).click();
        Reporter.log("Searched Item found and clicked");
    }
}
