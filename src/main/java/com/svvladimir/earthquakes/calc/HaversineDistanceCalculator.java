package com.svvladimir.earthquakes.calc;

import static java.lang.Math.*;

public class HaversineDistanceCalculator implements DistanceCalculator {

    private static final int EARTH_RADIUS = 6371;

    /**
     * Calculate distance between two points using Haversine formula:
     * a = sin²(Δφ/2) + cos φ1 ⋅ cos φ2 ⋅ sin²(Δλ/2)
     * c = 2 ⋅ atan2(√a, √(1−a))
     * d = R ⋅ c
     * where φ is latitude, λ is longitude, R is earth’s radius (6,371km).
     * Angles need to be in radians to pass to trigonometric functions.
     * (from R. W. Sinnott, "Virtues of the Haversine", Sky and Telescope, vol. 68, no. 2, 1984, p. 159)
     *
     * @param lat1 latitude of first point, in degrees
     * @param lon1 longitude of first point, in degrees
     * @param lat2 latitude of second point, in degrees
     * @param lon2 longitude of second point, in degrees
     * @return the distance in kilometers
     * @since 1.0
     */
    @Override
    public double calculate(double lat1, double lon1, double lat2, double lon2) {
        double lat1Rad = toRadians(lat1);
        double lat2Rad = toRadians(lat2);
        double latDelta = toRadians(lat2 - lat1);
        double lonDelta = toRadians(lon2 - lon1);
        double a = sin(latDelta / 2) * sin(latDelta / 2)
                + cos(lat1Rad) * cos(lat2Rad)
                * sin(lonDelta / 2) * sin(lonDelta / 2);
        double c = 2 * atan2(sqrt(a), sqrt(1 - a));
        return EARTH_RADIUS * c;
    }

    @Override
    public long calculateRound(double lat1, double lon1, double lat2, double lon2) {
        return Math.round(calculate(lat1, lon1, lat2, lon2));
    }
}
