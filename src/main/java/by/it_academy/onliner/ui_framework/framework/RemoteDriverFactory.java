package by.it_academy.onliner.ui_framework.framework;

import com.codeborne.selenide.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static by.it_academy.onliner.ui_framework.framework.ConfigurationConstants.*;
import static java.lang.String.format;
import static java.lang.System.getProperty;
import static org.apache.commons.lang3.ObjectUtils.defaultIfNull;

public class RemoteDriverFactory implements DriverFactory {
    private static final Logger LOGGER = LoggerFactory.getLogger(RemoteDriverFactory.class);

    @Override
    public void setUp(String browser) {
        Configuration.browser = defaultIfNull(browser, DEFAULT_BROWSER);
        Configuration.remote = format(HUB_URL_PATTERN, getProperty(DRIVER_HOST_PROPERTY));
        LOGGER.info("Test started remotely on {}", Configuration.remote);
    }
}
