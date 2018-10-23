package com.svvladimir.earthquakes.client;

import com.svvladimir.earthquakes.dto.EarthquakeCollection;
import com.svvladimir.earthquakes.util.PropertiesHandler;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

import static java.lang.Long.parseLong;
import static java.util.concurrent.Executors.newSingleThreadScheduledExecutor;
import static java.util.concurrent.TimeUnit.MINUTES;
import static org.apache.logging.log4j.LogManager.getLogger;

public class USGSEarthquakeClientCache extends AbstractServiceClient implements EarthquakeDataSource {

    private static final Logger LOGGER = getLogger();
    private static final String MONTH_EARTHQUAKES_URI_PROPERTY = "usgs.earthquakes.month.uri";
    private static final String CACHE_PERIOD_PROPERTY = "usgs.earthquakes.cache.period";

    private PropertiesHandler propertiesHandler = new PropertiesHandler();
    private String monthEarthquakesUri = propertiesHandler.getProperty(MONTH_EARTHQUAKES_URI_PROPERTY);
    private ScheduledExecutorService scheduler = newSingleThreadScheduledExecutor();
    private EarthquakeCollection earthquakeCollection;
    private ScheduledFuture scheduledFuture;

    public USGSEarthquakeClientCache() {
        try {
            earthquakeCollection = get(monthEarthquakesUri, EarthquakeCollection.class);
        } catch (ServiceClientException e) {
            throw new RuntimeException(e);
        }
        initCache();
    }

    @Override
    public EarthquakeCollection getMonthEarthquakes() {
        return earthquakeCollection;
    }

    @Override
    public void shutdown() {
        scheduledFuture.cancel(true);
        scheduler.shutdown();
    }

    private void initCache() {
        long initialDelay, period;
        initialDelay = period = parseLong(propertiesHandler.getProperty(CACHE_PERIOD_PROPERTY));
        scheduledFuture = scheduler.scheduleAtFixedRate(() -> {
            try {
                earthquakeCollection = get(monthEarthquakesUri, EarthquakeCollection.class);
            } catch (ServiceClientException e) {
                LOGGER.error(e);
            }
        }, initialDelay, period, MINUTES);
    }
}
