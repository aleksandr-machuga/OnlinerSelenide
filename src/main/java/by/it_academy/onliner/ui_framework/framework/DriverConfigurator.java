package by.it_academy.onliner.ui_framework.framework;

import static by.it_academy.onliner.ui_framework.framework.FactoryOperator.getDriverFactory;
import static com.codeborne.selenide.Configuration.*;

public class DriverConfigurator {

    public static void setUpDriver(String browser) {
        DriverFactory driverFactory = getDriverFactory();
        driverFactory.setUp(browser);
        pageLoadTimeout = 20000;
        timeout = 30000;
        browserSize = "1920x1080";
    }
}
