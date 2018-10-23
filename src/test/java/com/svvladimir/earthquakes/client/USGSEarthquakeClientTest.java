package com.svvladimir.earthquakes.client;

import com.svvladimir.earthquakes.dto.EarthquakeCollection;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(PER_CLASS)
@DisplayName("USGS earthquake API client check")
class USGSEarthquakeClientTest {

    private EarthquakeCollection earthquakeCollection;

    @BeforeAll
    void setup() throws ServiceClientException {
        USGSEarthquakeClient earthquakeClient = new USGSEarthquakeClient();
        earthquakeCollection = earthquakeClient.getMonthEarthquakes();
    }

    @Test
    @DisplayName("Earthquake collection type should be equal to \"FeatureCollection\"")
    void getMonthEarthquakesTypeTest() {
        Assertions.assertEquals("FeatureCollection", earthquakeCollection.getType());
    }

    @Test
    @DisplayName("Earthquake collection should not be empty")
    void getMonthEarthquakesSizeTest() {
        Assertions.assertTrue(!earthquakeCollection.getEarthquakes().isEmpty());
    }
}
