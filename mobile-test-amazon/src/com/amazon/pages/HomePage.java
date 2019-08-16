package com.amazon.pages;

import com.amazon.framework.BasePage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class HomePage extends BasePage {

    public HomePage(AndroidDriver driver) {
        super(driver);
    }
    private By amazonLogo= By.id("sso_splash_logo");
    private By signinToYourAccount= By.id("signin_to_yourAccount");
    private By signInBtn= By.id("sign_in_button");

    public void waitForAmazonLogo() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(amazonLogo)));
        Reporter.log("Home Page launched");
        Reporter.log(reportScreenShot());
    }

    public  void navigateToLoginPage() {
        driver.findElement(signinToYourAccount).click();
        driver.findElement(signInBtn).click();
        Reporter.log("Tapped on Sign In button");
    }



}
