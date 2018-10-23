package com.svvladimir.earthquakes;

import com.svvladimir.earthquakes.client.DataSourceException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(PER_CLASS)
@DisplayName("Earthquakes manager check")
class EarthquakesManagerTest {

    private EarthquakesManager earthquakesManager;

    @BeforeAll
    void setup() {
        earthquakesManager = new EarthquakesManager();
    }

    @Test
    @DisplayName("All earthquakes map should not be empty")
    void getEarthquakesTest() throws DataSourceException {
        assertTrue(!earthquakesManager.getEarthquakes(40.730610, -73.935242).isEmpty());
    }

    @Test
    @DisplayName("Nearby earthquakes map should not be empty")
    void getNearbyEarthquakesTest() throws DataSourceException {
        assertTrue(!earthquakesManager.getNearbyEarthquakes(40.730610, -73.935242).isEmpty());
    }

    @Test
    @DisplayName("Printable nearby earthquakes string should not be empty")
    void getPrintableNearbyEarthquakesTest() throws DataSourceException {
        assertTrue(!earthquakesManager.getPrintableNearbyEarthquakes(40.730610, -73.935242).isEmpty());
    }
}
