package IPages.Actions;

import IPages.Launch;
import Utilities.BaseManagerClass;
import Utilities.DriverFactory;

public class launchAction implements Launch {
     private final DriverFactory  driverFactory = BaseManagerClass.getInstance().getDriverFactory();
    @Override
    public void launchBrowser() {
      driverFactory.getDriver().get("https://www.amazon.in/");
    }
}
