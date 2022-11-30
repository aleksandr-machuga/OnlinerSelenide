package by.it_academy.onliner.api_framework.utils;

import io.restassured.response.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.apache.commons.collections4.MapUtils.emptyIfNull;
import static org.apache.hc.core5.http.HttpStatus.SC_OK;

public class GetRequestUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(GetRequestUtils.class);

    public static ResponseBody makeResponseAndRequestBody(String endpoint,
                                                          Map<String, Object> headers,
                                                          Map<String, Object> params) {
        LOGGER.info("Sending request to {} with headers {} and parameters {}", endpoint, headers, params);
        return given()
                .headers(emptyIfNull(headers))
                .params(emptyIfNull(params))
                .when()
                .get(endpoint)
                .then()
                .statusCode(SC_OK)
                .extract()
                .response()
                .getBody();
    }
}
