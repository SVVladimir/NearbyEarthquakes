package com.svvladimir.earthquakes.util;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(PER_CLASS)
@DisplayName("Properties handler check")
class PropertiesHandlerTest {

    private PropertiesHandler propertiesHandler;

    @BeforeAll
    void setup() {
        propertiesHandler = new PropertiesHandler();
    }

    @Test
    @DisplayName("Existing property should be successfully gotten")
    void getExistingPropertyTest() {
        assertEquals("test property value", propertiesHandler.getProperty("test.property"));
    }

    @Test
    @DisplayName("Not existing property should not be successfully gotten")
    void getNotExistingPropertyTest() {
        assertNull(propertiesHandler.getProperty("test.property2"));
    }
}
