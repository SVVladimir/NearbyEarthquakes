package com.svvladimir.earthquakes.util;

public class CoordinateParser {

    public static double parseLatitude(String line) {
        return parse("Latitude", -90.0, 90.0, line);
    }

    public static double parseLongitude(String line) {
        return parse("Longitude", -180.0, 180.0, line);
    }

    private static double parse(String type, double low, double high, String line) {
        if (line == null || line.isEmpty()) {
            throw new IllegalArgumentException(type + " can not be null or empty!");
        } else {
            try {
                double latitude = Double.parseDouble(line);
                if (latitude < low || latitude > high) {
                    throw new IllegalArgumentException(type + " should be in [" + low + "," + high + "]!");
                } else {
                    return latitude;
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Please enter correct " + type + " value!");
            }
        }
    }
}
