package com.svvladimir.earthquakes.client;

import com.svvladimir.earthquakes.dto.EarthquakeCollection;
import com.svvladimir.earthquakes.util.PropertiesHandler;

public class USGSEarthquakeClient extends AbstractServiceClient implements EarthquakeDataSource {

    private static final String MONTH_EARTHQUAKES_URI_PROPERTY = "usgs.earthquakes.month.uri";

    private PropertiesHandler propertiesHandler = new PropertiesHandler();
    private String monthEarthquakesUri = propertiesHandler.getProperty(MONTH_EARTHQUAKES_URI_PROPERTY);

    @Override
    public EarthquakeCollection getMonthEarthquakes() throws ServiceClientException {
        return get(monthEarthquakesUri, EarthquakeCollection.class);
    }
}
