package Utilities;

public class BaseManagerClass {
    private static BaseManagerClass instance;
    private  DriverFactory driverFactory;
    private  UiActions uiActions;
    private  BaseTest baseTest;

    private BaseManagerClass(){
        driverFactory = DriverFactory.getInstance();
        uiActions = getUiActions();
        baseTest = getBaseTest();
    }
    public static BaseManagerClass getInstance(){
        if(instance == null){
            instance = new BaseManagerClass();
        }
        return instance;
    }
    public DriverFactory getDriverFactory() {
        return driverFactory;
    }

    public UiActions getUiActions() {
        return uiActions;
    }

    public BaseTest getBaseTest() {
        return baseTest;
    }
}
