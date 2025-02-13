package Utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected JavascriptExecutor jsExecutor;

    public BaseTest(){
        this.driver = DriverFactory.getInstance().getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.jsExecutor = (JavascriptExecutor) driver;
    }
    public void waitForElementToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void clickElementByJS(String value, WebElement element) {
        jsExecutor.executeScript(value, element);
    }

    public void pause(int duration){
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
