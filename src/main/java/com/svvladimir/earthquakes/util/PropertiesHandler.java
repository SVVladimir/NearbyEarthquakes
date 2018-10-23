package com.svvladimir.earthquakes.util;

import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static java.lang.ClassLoader.getSystemResourceAsStream;
import static org.apache.logging.log4j.LogManager.getLogger;

public class PropertiesHandler {

    private static final Logger LOGGER = getLogger();
    private static final String DEFAULT_PROPERTIES_FILE_NAME = "earthquakes.properties";

    private String propertiesFileName;
    private Properties properties;

    public PropertiesHandler() {
        this(DEFAULT_PROPERTIES_FILE_NAME);
    }

    public PropertiesHandler(String propertiesFileName) {
        LOGGER.debug("Using properties file: " + propertiesFileName);
        this.propertiesFileName = propertiesFileName;
        readPropertiesFromFile();
    }

    public String getProperty(String propertyName) {
        return properties.getProperty(propertyName);
    }

    private void readPropertiesFromFile() {
        properties = new Properties();
        try (InputStream inputStream = getSystemResourceAsStream(propertiesFileName)) {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
