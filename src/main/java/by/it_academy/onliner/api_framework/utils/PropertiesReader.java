package by.it_academy.onliner.api_framework.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
    private static final String ENDPOINTS_FILE = "/endpoints.properties";
    public static final Properties ENDPOINT_PROPERTIES = new Properties();
    public static final String UNABLE_LOAD_PROPERTIES_FROM_FILE_MESSAGE = "Unable to load properties from file: ";

    static {
        initProperties(ENDPOINT_PROPERTIES, ENDPOINTS_FILE);
    }

    public static String getEndpointProperty(String property) {
        return ENDPOINT_PROPERTIES.getProperty(property);
    }

    private static synchronized void initProperties(Properties properties, String fileName) {
        try (InputStream inputStream = PropertiesReader.class.getResourceAsStream(fileName)) {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new IllegalArgumentException(UNABLE_LOAD_PROPERTIES_FROM_FILE_MESSAGE + fileName);
        }
    }
}
