package by.it_academy.onliner.framework;

import static com.codeborne.selenide.Configuration.*;
import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class DriverConfigurator {
    public static void setUpDriver() {
        chromedriver().setup();
        browser = "chrome";
        pageLoadTimeout = 20000;
        timeout = 30000;
        browserSize = "1920x1080";
    }
}
