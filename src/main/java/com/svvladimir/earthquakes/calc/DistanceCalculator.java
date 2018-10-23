package com.svvladimir.earthquakes.calc;

public interface DistanceCalculator {

    double calculate(double lat1, double lon1, double lat2, double lon2);

    long calculateRound(double lat1, double lon1, double lat2, double lon2);
}
