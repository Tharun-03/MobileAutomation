package StepDefinitions;

import IPages.Actions.GlobalActions;
import IPages.Actions.launchAction;
import io.cucumber.java.en.Given;

import java.util.Objects;

public class MyStepdefs {
    public static GlobalActions globalActions = new GlobalActions();

    static {
        if (Objects.isNull(globalActions.getLaunch())) {
            globalActions.setLaunch(new launchAction());
        }
    }
    @Given("user launches the amazon browser")
    public void userLaunchesTheAmazonBrowser() {
        globalActions.launchBrowser();
    }
}
