package com.svvladimir.earthquakes;

import com.svvladimir.earthquakes.calc.DistanceCalculator;
import com.svvladimir.earthquakes.calc.HaversineDistanceCalculator;
import com.svvladimir.earthquakes.client.DataSourceException;
import com.svvladimir.earthquakes.client.EarthquakeDataSource;
import com.svvladimir.earthquakes.client.USGSEarthquakeClient;
import com.svvladimir.earthquakes.client.USGSEarthquakeClientCache;
import com.svvladimir.earthquakes.dto.Earthquake;
import com.svvladimir.earthquakes.util.PropertiesHandler;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static java.lang.Boolean.parseBoolean;
import static java.lang.Integer.parseInt;
import static org.apache.logging.log4j.LogManager.getLogger;

public class EarthquakesManager {

    private static final Logger LOGGER = getLogger();
    private static final String NEARBY_LIMIT_PROPERTY = "usgs.earthquakes.month.nearby.limit";
    private static final String CACHE_ENABLE_PROPERTY = "usgs.earthquakes.cache.enable";

    private EarthquakeDataSource dataSource;
    private DistanceCalculator distanceCalculator = new HaversineDistanceCalculator();
    private PropertiesHandler propertiesHandler = new PropertiesHandler();

    public EarthquakesManager() {
        boolean cacheEnable = parseBoolean(propertiesHandler.getProperty(CACHE_ENABLE_PROPERTY));
        if (cacheEnable) {
            dataSource = new USGSEarthquakeClientCache();
        } else {
            dataSource = new USGSEarthquakeClient();
        }
    }

    public Map<Long, Earthquake> getEarthquakes(double lat, double lon) throws DataSourceException {
        List<Earthquake> earthquakeCollection = dataSource.getMonthEarthquakes().getEarthquakes();
        Map<Long, Earthquake> earthquakesByDistance = new TreeMap<>();
        final long startTime = System.nanoTime();
        earthquakeCollection.forEach(earthquake -> {
            double eLat = earthquake.getGeometry().getCoordinates().get(1);
            double eLon = earthquake.getGeometry().getCoordinates().get(0);
            long distance = distanceCalculator.calculateRound(lat, lon, eLat, eLon);
            earthquakesByDistance.put(distance, earthquake);
        });
        final long endTime = System.nanoTime();
        double executionTimeInSeconds = ((double) endTime - startTime) / 1000000000.0;
        LOGGER.debug("Execution time for " + earthquakeCollection.size() + " entries in seconds: " + executionTimeInSeconds);
        return earthquakesByDistance;
    }

    public Map<Long, Earthquake> getNearbyEarthquakes(double lat, double lon) throws DataSourceException {
        int count = parseInt(propertiesHandler.getProperty(NEARBY_LIMIT_PROPERTY));
        Map<Long, Earthquake> allEarthquakes = getEarthquakes(lat, lon);
        return allEarthquakes.entrySet().stream().limit(count)
                .collect(TreeMap::new, (limited, all) -> limited.put(all.getKey(), all.getValue()), Map::putAll);
    }

    public String getPrintableNearbyEarthquakes(double lat, double lon) throws DataSourceException {
        StringBuilder stringBuilder = new StringBuilder();
        Map<Long, Earthquake> earthquakes = getNearbyEarthquakes(lat, lon);
        earthquakes.forEach((distance, earthquake) -> {
            if (stringBuilder.toString().isEmpty()) {
                stringBuilder.append(earthquake.getProperties().getTitle()).append(" || ").append(distance);
            } else {
                stringBuilder.append("\n").append(earthquake.getProperties().getTitle()).append(" || ").append(distance);
            }
        });
        return stringBuilder.toString();
    }

    public void shutdown() {
        dataSource.shutdown();
    }
}
