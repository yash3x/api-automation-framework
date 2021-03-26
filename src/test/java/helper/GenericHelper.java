package helper;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

public class GenericHelper {
    public Map<String, String> readJsonfile(String methodName, String jsonFileName, String folderName) throws FileNotFoundException {
        String filePath = System.getProperty("user.dir")
                + File.separator + "src" + File.separator
                + File.separator + "test" + File.separator
                + File.separator + "resources" + File.separator
                + File.separator + folderName + File.separator
                + jsonFileName + ".json";
        JsonElement jsonElement = (new JsonParser()).parse(new FileReader(filePath));
        JsonObject object = jsonElement.getAsJsonObject();
        JsonElement ele = object.get(methodName);
        JsonObject jObject = ele.getAsJsonObject();
        Map<String, String> mObject = new HashMap<String, String>();
        Iterator iterator = jObject.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            mObject.put(entry.getKey().toString(), entry.getValue().toString().replace("\"", ""));
        }
        return mObject;
    }

    public Properties loadProperty(String fileName) throws IOException {
        String path = System.getProperty("user.dir")
                + File.separator + "src" + File.separator
                + File.separator + "test" + File.separator
                + File.separator + "resources" + File.separator
                + fileName + ".properties";
        File file = new File(path);
        FileInputStream fileInput = new FileInputStream(file);
        Properties prop = new Properties();
        prop.load(fileInput);
        return prop;
    }
}
