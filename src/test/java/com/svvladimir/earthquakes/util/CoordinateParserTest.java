package com.svvladimir.earthquakes.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static com.svvladimir.earthquakes.util.CoordinateParser.parseLatitude;
import static com.svvladimir.earthquakes.util.CoordinateParser.parseLongitude;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(PER_CLASS)
@DisplayName("Latitude and Longitude parser check")
class CoordinateParserTest {

    @Test
    @DisplayName("Parsed Latitude should be equal to expected")
    void parseLatitudeTest() {
        assertEquals(40.730610, parseLatitude("40.730610"));
    }

    @Test
    @DisplayName("Parsed Longitude should be equal to expected")
    void parseLongitudeTest() {
        assertEquals(-73.935242, parseLongitude("-73.935242"));
    }

    @Test
    @DisplayName("Exception should be thrown when Latitude string is null")
    void parseNullLatitudeTest() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> parseLatitude(null));
        assertEquals("Latitude can not be null or empty!", exception.getMessage());
    }

    @Test
    @DisplayName("Exception should be thrown when Longitude string is empty")
    void parseEmptyLongitudeTest() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> parseLongitude(""));
        assertEquals("Longitude can not be null or empty!", exception.getMessage());
    }

    @Test
    @DisplayName("Exception should be thrown when Latitude value is less than -90.0")
    void parseSmallLatitudeTest() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> parseLatitude("-91.0"));
        assertEquals("Latitude should be in [-90.0,90.0]!", exception.getMessage());
    }

    @Test
    @DisplayName("Exception should be thrown when Longitude value is bigger than 180.0")
    void parseBigLongitudeTest() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> parseLongitude("180.1"));
        assertEquals("Longitude should be in [-180.0,180.0]!", exception.getMessage());
    }

    @Test
    @DisplayName("Exception should be thrown when Latitude value is not parsable")
    void parseWrongLatitudeTest() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> parseLatitude("10o71gh"));
        assertEquals("Please enter correct Latitude value!", exception.getMessage());
    }

    @Test
    @DisplayName("Exception should be thrown when Longitude value is bigger than 180.0")
    void parseWrongLongitudeTest() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> parseLongitude("_1.02x1"));
        assertEquals("Please enter correct Longitude value!", exception.getMessage());
    }

}
