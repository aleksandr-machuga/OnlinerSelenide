package by.it_academy.onliner.api_framework.endpoints;

import static by.it_academy.onliner.api_framework.utils.PropertiesReader.getEndpointProperty;

public class OnlinerEndpoints {

    public static final String PRODUCTS_PROPERTY = "products";

    public static String getProductsEndpoint() {
        return getEndpointProperty(PRODUCTS_PROPERTY);
    }
}
