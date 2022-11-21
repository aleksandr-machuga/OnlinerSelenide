package by.it_academy.onliner.ui_framework.framework;

import static by.it_academy.onliner.ui_framework.framework.ConfigurationConstants.DRIVER_HOST_PROPERTY;
import static java.lang.System.getProperty;
import static java.util.Objects.nonNull;

public class FactoryOperator {

    public static DriverFactory getDriverFactory() {
        if (nonNull(getProperty(DRIVER_HOST_PROPERTY))) {
            return new RemoteDriverFactory();
        } else {
            return new LocalDriverFactory();
        }
    }
}
