package com.svvladimir.earthquakes.calc;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(PER_CLASS)
@DisplayName("Haversine distance calculator check")
class HaversineDistanceCalculatorTest {

    private HaversineDistanceCalculator distanceCalculator;

    @BeforeAll
    void setup() {
        distanceCalculator = new HaversineDistanceCalculator();
    }

    @Test
    @Disabled
    @DisplayName("Calculated distance should be equal to expected")
    void calculateTest() {
        assertEquals(8661.57204095562, distanceCalculator.calculate(40.730610, -73.935242, 0, 0));
    }

    @Test
    @DisplayName("Calculated rounded distance should be equal to expected")
    void calculateRoundTest() {
        assertEquals(8662, distanceCalculator.calculateRound(40.730610, -73.935242, 0, 0));
    }
}
