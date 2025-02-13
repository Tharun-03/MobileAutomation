package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;



public class DriverFactory {
    private static DriverFactory instance = null;
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private DriverFactory(){

    }

    public static DriverFactory getInstance(){
        if (instance == null) {
            instance = new DriverFactory();
        }
        return instance;
    }

    public WebDriver getDriver() {
        if (driver.get() == null) { // Fix here
            String browser = System.getProperty("browser"); // No default value
            if (browser == null || browser.isEmpty()) {
                browser = "chrome";
            }
            driver.set(createDriver(browser.toLowerCase()));
        }
        return driver.get();
    }

    private WebDriver createDriver(String browser) {
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless", "--incognito", "--start-maximized");
                return new ChromeDriver(chromeOptions);

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--headless", "--private");
                return new FirefoxDriver(firefoxOptions);

            default:
                throw new IllegalArgumentException("❌ Unsupported browser: " + browser);
        }
    }

    public void closeDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }

}
