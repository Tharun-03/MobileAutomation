package com.amazon.pages;

import com.amazon.framework.BasePage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class LoginPage extends BasePage {

    public LoginPage(AndroidDriver driver) {
        super(driver);
    }
    private By loginPageHeader= By.xpath("//*[@resource-id='login_accordion_header']");
    private By usernameField= By.xpath("//*[@resource-id='ap_email_login']");
    private By passwordField= By.xpath("//*[@resource-id='ap_password']");
    private By signInBtn=By.xpath("//*[@resource-id='auth-signin-button']");

    public void waitForLoginPage() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(loginPageHeader)));
        Reporter.log("Login Page is displayed");
        Reporter.log(reportScreenShot());
    }

    public  void enterUserCredentials(String username, String password) {
        driver.findElement(usernameField).clear();
        driver.findElement(usernameField).sendKeys(username);
        Reporter.log("Username is entered");

        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
        Reporter.log("Password is entered");

        driver.findElement(signInBtn).click();
        Reporter.log("Tapped on Sign In button");
    }
}
