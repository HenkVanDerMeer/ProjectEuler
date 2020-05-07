package service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class EulerProperties {

    private static final Properties properties = new Properties();

    public EulerProperties() throws IOException {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("application.properties")) {
            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                System.err.println("application.properties not found");
            }
        }
    }

    public static String getPropertyValue(String property) {
        return properties.getProperty(property);
    }
}
