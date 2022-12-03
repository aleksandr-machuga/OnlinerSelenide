package by.it_academy.onliner.ui_framework.framework;

import com.codeborne.selenide.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static by.it_academy.onliner.ui_framework.framework.ConfigurationConstants.DEFAULT_BROWSER;
import static by.it_academy.onliner.ui_framework.framework.ConfigurationConstants.FIREFOX_BROWSER;
import static io.github.bonigarcia.wdm.WebDriverManager.*;
import static org.apache.commons.lang3.ObjectUtils.defaultIfNull;

public class LocalDriverFactory implements DriverFactory {
    private static final Logger LOGGER = LoggerFactory.getLogger(LocalDriverFactory.class);

    @Override
    public void setUp(String browser) {
        Configuration.browser = defaultIfNull(browser, DEFAULT_BROWSER);
        LOGGER.info("Browser start configuration {}", Configuration.browser);
        if (FIREFOX_BROWSER.equals(Configuration.browser)) {
            firefoxdriver().setup();
        } else {
            chromedriver().setup();
        }
    }
}
