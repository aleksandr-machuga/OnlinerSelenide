package by.it_academy.onliner.api_framework.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.String.format;

public class GetParamsUtils {

    public static final String OPERATION = "sushi_typ[operation]";
    public static final String FILTER_KEY = "sushi_typ[%s]";

    public static Map<String, Object> getProductFilteringParams(String operation, List<String> filters) {
        Map<String, Object> params = new HashMap<>();
        params.put(OPERATION, operation);
        filters.forEach(filter -> params
                .put(format(FILTER_KEY, filters.indexOf(filter)), filter));
        return params;
    }
}
