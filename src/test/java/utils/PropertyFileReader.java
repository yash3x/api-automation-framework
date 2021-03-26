package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {
    public static void main(String[] args) throws IOException {
        String propertyFile = "qa";
        Properties properties = loadProperty(propertyFile);
        System.out.println(properties.getProperty("baseURL"));

    }

    public static Properties loadProperty(String fileName) throws IOException {
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
