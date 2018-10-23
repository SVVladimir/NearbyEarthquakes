# Nearby Earthquakes
  
Nearby Earthquakes is a program which for a given coordinates (lat/lon) provides 10 nearest earthquakes based on [USGS Earthquake Hazards Program](https://earthquake.usgs.gov/aboutus/) data.

## Earthquakes data
It checks all earthquakes that happened during last 30 days: https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_month.geojson  

## Calculating distance
Currently it calculates distance using Haversine formula:
```
a = sin²(Δφ/2) + cos φ1 ⋅ cos φ2 ⋅ sin²(Δλ/2)
c = 2 ⋅ atan2(√a, √(1−a))
d = R ⋅ c
```

where φ is latitude, λ is longitude, R is earth’s radius (6,371km). Angles need to be in radians to pass to trigonometric functions.

*(from R. W. Sinnott, "Virtues of the Haversine", Sky and Telescope, vol. 68, no. 2, 1984, p. 159)*

## Program input
Program accepts two float numbers on standard input: the latitude in **[-90.0, 90.0]** and the longitude in **[-180.0, 180.0]**.

## Program output 
As an output program prints a list of **10** earthquakes that happened in the closest proximity to input point, in the order from the closest to the furthest. For each earthquake it prints `description` followed by ` || ` and `distance` (rounded to full kilometers).  
```
description || distance  
description || distance  
description || distance  
```

## Summary
* Reads two float numbers from standard input that represent the lat/lon coordinates
* Gets a list of earthquakes that happened during last 30 days
* Calculates distance between given point and each of the earthquakes
* Prints the 10 earthquakes with the shortest distance to the given point
* The output list contains earthquake title and distance in kilometers

## Usage examples: 
Input example:  
```
40.730610  
-73.935242  
```

Output example:
```
M 1.3 - 2km SSE of Contoocook, New Hampshire || 331  
M 1.3 - 2km ENE of Belmont, Virginia || 354  
M 2.4 - 83km ESE of Nantucket, Massachusetts || 406  
M 1.3 - 13km ENE of Barre, Vermont || 410  
M 0.7 - 18km NW of Norfolk, New York || 476  
M 2.0 - 17km NW of Norfolk, New York || 476  
M 1.7 - 19km NNW of Beaupre, Canada || 758  
M 1.9 - 13km SW of La Malbaie, Canada || 814  
M 2.4 - 16km N of Lenoir, North Carolina || 840  
M 2.4 - 12km ESE of Carlisle, Kentucky || 896  
```
## Configuration:
Program supports following configurations (*earthquakes.properties*):
* `usgs.earthquakes.month.uri` - URI of earthquakes data source
* `usgs.earthquakes.month.nearby.limit` - number of earthquakes to be printed out
* `usgs.earthquakes.cache.enable` - enable caching of earthquakes data
* `usgs.earthquakes.cache.period` - cache update period in minutes


## Build:
Minimum requirements:
* Apache Maven 3.3.3
* JDK 1.8

Run from project root:

```
mvn clean install
```

Output directory *./target/releases*

## Run:
Instructions for running (requires JRE 1.8) you can find at *readme.txt*.
Was tested on Windows 10, Ubuntu 15.10 and MacOS 10.14.

