package utilities;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JsonReader {

    public static String getJsonValueByKey(String filePath, String key) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader(filePath));
        JSONObject jsonObject = (JSONObject) obj;

        Object value = jsonObject.get(key);

        // This is the crucial check to prevent NullPointerException
        if (value == null) {
            throw new IllegalArgumentException("Key '" + key + "' not found in JSON file: " + filePath);
        }

        return (String) value;
    }

}