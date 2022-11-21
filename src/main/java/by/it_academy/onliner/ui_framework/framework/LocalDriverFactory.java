package by.it_academy.onliner.ui_framework.framework;

import com.codeborne.selenide.Configuration;

import static by.it_academy.onliner.ui_framework.framework.ConfigurationConstants.DEFAULT_BROWSER;
import static io.github.bonigarcia.wdm.WebDriverManager.*;
import static org.apache.commons.lang3.ObjectUtils.defaultIfNull;

public class LocalDriverFactory implements DriverFactory {

    @Override
    public void setUp(String browser) {
        Configuration.browser = defaultIfNull(browser, DEFAULT_BROWSER);
        switch (defaultIfNull(browser, DEFAULT_BROWSER)) {
            case ConfigurationConstants.EDGE_BROWSER -> edgedriver().setup();
            case ConfigurationConstants.FIREFOX_BROWSER -> firefoxdriver().setup();
            default -> chromedriver().setup();
        }
    }
}
