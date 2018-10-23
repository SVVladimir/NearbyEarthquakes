package com.svvladimir.earthquakes;

import com.svvladimir.earthquakes.client.DataSourceException;

import java.util.Scanner;

import static com.svvladimir.earthquakes.util.CoordinateParser.parseLatitude;
import static com.svvladimir.earthquakes.util.CoordinateParser.parseLongitude;

public class NearbyEarthquakes {

    private boolean running = true;
    private Scanner scanner = new Scanner(System.in);
    private EarthquakesManager earthquakesManager = new EarthquakesManager();

    public static void main(String[] args) {
        new NearbyEarthquakes().run();
    }

    private void run() {
        System.out.println(" _   _                 _             _____           _   _                       _             \n" +
                "| \\ | | ___  __ _ _ __| |__  _   _  | ____|__ _ _ __| |_| |__   __ _ _   _  __ _| | _____  ___ \n" +
                "|  \\| |/ _ \\/ _` | '__| '_ \\| | | | |  _| / _` | '__| __| '_ \\ / _` | | | |/ _` | |/ / _ \\/ __|\n" +
                "| |\\  |  __/ (_| | |  | |_) | |_| | | |__| (_| | |  | |_| | | | (_| | |_| | (_| |   <  __/\\__ \\\n" +
                "|_| \\_|\\___|\\__,_|_|  |_.__/ \\__, | |_____\\__,_|_|   \\__|_| |_|\\__, |\\__,_|\\__,_|_|\\_\\___||___/\n" +
                "                             |___/                                |_|                          \n");
        while (running) {
            System.out.println("Please enter latitude and longitude to get nearest earthquakes (press enter after each value)");
            System.out.println("Note: latitude should be in [-90.0, 90.0], longitude should be in [-180.0,180.0]");
            System.out.println("To exit the program enter \"quit\" or \"q\"");
            performAction();
        }
        System.out.println("Thank you for using Nearby Earthquakes!");
    }

    private void performAction() {
        String line = scanner.nextLine();
        if (line.equals("quit") || line.equals("q")) {
            earthquakesManager.shutdown();
            running = false;
        } else {
            try {
                double latitude = parseLatitude(line);
                double longitude = parseLongitude(scanner.nextLine());
                System.out.println("Searching for nearest to point (" + latitude + ", " + longitude + ") earthquakes...");
                System.out.println(earthquakesManager.getPrintableNearbyEarthquakes(latitude, longitude));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (DataSourceException e) {
                System.out.println("Something went wrong, please try again...");
            }
        }
    }
}
