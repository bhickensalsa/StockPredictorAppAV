package com.stockpredictor.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * {@code ConfigLoader} is a utility class for loading configuration properties
 * from a `.properties` file located in the application's classpath.
 *
 * <p>This is typically used for loading API keys, base URLs, and other application settings.
 */
public class ConfigLoader {

    /**
     * Loads a properties file from the classpath.
     *
     * @param filename the name of the properties file (e.g., "config.properties")
     * @return a {@link Properties} object containing the key-value pairs from the file
     * @throws IOException if the file is not found or cannot be read
     */
    public static Properties load(String filename) throws IOException {
        Properties props = new Properties();

        // Load the resource as a stream from the classpath
        try (InputStream input = ConfigLoader.class.getClassLoader().getResourceAsStream(filename)) {
            if (input == null) {
                // Fail if the config file does not exist in the classpath
                throw new IOException("Config file not found in classpath: " + filename);
            }
            // Load properties from the file
            props.load(input);
        }

        return props;
    }
}
