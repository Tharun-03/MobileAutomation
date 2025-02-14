package IPages.Actions;

import IPages.Launch;

public class GlobalActions implements Launch {

    private Launch launch;

    public Launch getLaunch() {
        return launch;
    }

    public void setLaunch(Launch launch) {
        this.launch = launch;
    }

    @Override
    public void launchBrowser() {
       this.launch.launchBrowser();
    }
}

