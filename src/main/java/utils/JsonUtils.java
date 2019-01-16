package utils;

import com.google.gson.Gson;

public class JsonUtils {
    private JsonUtils() {

    }

    public static String toJson(final Object objectToJson) {
        Gson gson = new Gson();
        return gson.toJson(objectToJson);
    }
}
