package helpers;

import managers.*;

public class TestContext {
    private DriverManager driverManager;
    private PagesManager pagesManager;

    public TestContext() {
        driverManager = new DriverManager();
        pagesManager = new PagesManager(driverManager.getDriver());
    }

    public DriverManager getDriverManager() {
        return driverManager;
    }

    public PagesManager getPageObjectManager() {
        return pagesManager;
    }
}