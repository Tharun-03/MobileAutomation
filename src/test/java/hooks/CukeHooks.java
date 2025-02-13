package hooks;

import Utilities.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class CukeHooks {

    @Before
    public void beforeScenario(Scenario scenario) {
        System.out.println("🚀 Starting Scenario: " + scenario.getName());

    }

    @After
    public void afterScenario(Scenario scenario) {
        System.out.println("✅ Finished Scenario: " + scenario.getName());

        // Capture screenshot if scenario fails
        if (scenario.isFailed()) {
            TakesScreenshot takesScreenshot = (TakesScreenshot)DriverFactory.getInstance().getDriver();
            byte[] screenshot = takesScreenshot.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
    }
}
