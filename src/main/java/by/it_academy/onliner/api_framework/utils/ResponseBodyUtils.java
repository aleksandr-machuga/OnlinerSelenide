package by.it_academy.onliner.api_framework.utils;

import io.restassured.response.ResponseBody;

import java.util.List;

public class ResponseBodyUtils {
    public static <T> List<T> getObjectsByJsonPath(
            ResponseBody responseBody, String jsonPath, Class<T> type) {
        return responseBody
                .jsonPath()
                .getList(jsonPath, type);
    }
}
