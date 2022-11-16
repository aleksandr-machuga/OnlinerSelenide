package by.it_academy.tests.api_tests;

import by.it_academy.onliner.api_framework.entity.Product;
import io.restassured.response.ResponseBody;
import org.testng.annotations.Test;

import java.util.List;

import static by.it_academy.onliner.api_framework.endpoints.OnlinerEndpoints.getProductsEndpoint;
import static by.it_academy.onliner.api_framework.utils.GetParamsUtils.getProductFilteringParams;
import static by.it_academy.onliner.api_framework.utils.GetRequestUtils.makeResponseAndRequestBody;
import static by.it_academy.onliner.api_framework.utils.ResponseBodyUtils.getObjectsByJsonPath;
import static java.util.List.of;
import static org.assertj.core.api.Assertions.assertThat;

public class SushiveslaTest {

    public static final String PRODUCTS_JSON_PATH = "products";
    public static final String FILTER_VALUE = "roll";
    public static final String NAME_PREFIX_JSON_PATH = "products.name_prefix";
    public static final String EXPECTED_VALUE = "Роллы";

    @Test
    public void testProductFields() {
        ResponseBody responseBody = makeResponseAndRequestBody(getProductsEndpoint(), null, null);
        List<Product> products = getObjectsByJsonPath(responseBody, PRODUCTS_JSON_PATH, Product.class);
        products.forEach(product -> assertThat(product)
                .as("Product " + product.getId() + " has null fields")
                .hasNoNullFieldsOrProperties());
    }

    @Test
    public void testProductFiltering() {
        ResponseBody responseBody = makeResponseAndRequestBody(getProductsEndpoint(), null,
                getProductFilteringParams("union", of(FILTER_VALUE)));
        List<String> namePrefixList = getObjectsByJsonPath(responseBody, NAME_PREFIX_JSON_PATH, String.class);
        assertThat(namePrefixList)
                .as("Name prefix does not meet expectations")
                .filteredOn(value -> !value.equals(EXPECTED_VALUE))
                .isEmpty();
    }
}
