package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/Features", // Path to feature files
        glue = {"StepDefinitions", "hooks"}, // Path to step definitions and hooks
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        monochrome = true,
        dryRun = false
)

public class RunCuke extends AbstractTestNGCucumberTests {
}
