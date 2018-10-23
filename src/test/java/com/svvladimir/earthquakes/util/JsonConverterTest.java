package com.svvladimir.earthquakes.util;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(PER_CLASS)
@DisplayName("JSON converter check")
class JsonConverterTest {

    private JsonConverter jsonConverter;
    private String testJson = "{\"stringField\":\"string\",\"intField\":10}";

    @BeforeAll
    void setup() {
        jsonConverter = new JsonConverter();
    }

    private static class TestObject {
        private String stringField;
        private int intField;

        String getStringField() {
            return stringField;
        }

        void setStringField(String stringField) {
            this.stringField = stringField;
        }

        int getIntField() {
            return intField;
        }

        void setIntField(int intField) {
            this.intField = intField;
        }
    }

    @Test
    @DisplayName("JSON should be successfully deserialized to Object")
    void jsonToObjectTest() {
        TestObject testObject = jsonConverter.jsonToObject(testJson, TestObject.class);
        assertTrue(testObject.getIntField() == 10 && testObject.getStringField().equals("string"));
    }

    @Test
    @DisplayName("JSON should be successfully prettified")
    void prettifyJsonTest() {
        String prettifiedJson = jsonConverter.prettifyJson(testJson);
        assertEquals("{\n  \"stringField\" : \"string\",\n  \"intField\" : 10\n}", prettifiedJson);
    }
}
