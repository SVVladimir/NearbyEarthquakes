package com.svvladimir.earthquakes.client;

import com.svvladimir.earthquakes.dto.EarthquakeCollection;

public interface EarthquakeDataSource {

    EarthquakeCollection getMonthEarthquakes() throws DataSourceException;

    default void shutdown() {
    }
}
