package day5;

import day4.Card;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Day5 {

    static final String fileName = "day5.txt";

    static List<Long> seeds = new ArrayList<>();
    static List<AlmanacEntry> seedToSoilEntries = new ArrayList<>();
    static List<AlmanacEntry> soilToFertilizerEntries = new ArrayList<>();
    static List<AlmanacEntry> ferilizerToWaterEntries = new ArrayList<>();
    static List<AlmanacEntry> waterToLightEntries = new ArrayList<>();
    static List<AlmanacEntry> lightToTempEntries = new ArrayList<>();
    static List<AlmanacEntry> tempToHumidEntries = new ArrayList<>();
    static List<AlmanacEntry> humidToLocEntries = new ArrayList<>();

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream(fileName)))) {

            //Read seeds
            String line = reader.readLine();
            String[] seedArray = line.split(" ");
            for (int i=1; i<seedArray.length; i++) {
                seeds.add(Long.parseLong(seedArray[i]));
            }
            reader.readLine();

            //Read the other 'maps'
            readIntoList(reader, seedToSoilEntries);
            readIntoList(reader, soilToFertilizerEntries);
            readIntoList(reader, ferilizerToWaterEntries);
            readIntoList(reader, waterToLightEntries);
            readIntoList(reader, lightToTempEntries);
            readIntoList(reader, tempToHumidEntries);
            readIntoList(reader, humidToLocEntries);

            //Work through the seeds
            long lowestLocation = Integer.MAX_VALUE;
            long seedForLowestLocation = -1;
            for (long seed : seeds) {
                long soil = matchInList(seed, seedToSoilEntries);
                long fertilizer = matchInList(soil, soilToFertilizerEntries);
                long water = matchInList(fertilizer, ferilizerToWaterEntries);
                long light = matchInList(water, waterToLightEntries);
                long temp = matchInList(light, lightToTempEntries);
                long humidity = matchInList(temp, tempToHumidEntries);
                long location = matchInList(humidity, humidToLocEntries);
                if (location < lowestLocation) {
                    lowestLocation = location;
                    seedForLowestLocation = seed;
                }
            }

            //Part 1
            System.out.println("Seed " + seedForLowestLocation + " has location " + lowestLocation);

            //Part 2 - It would take too long to calculate the location for every seed, so we'll start at
            //         location 0 and go up, working backwards until we find a valid chain.
            List<SeedRange> seedRanges = new ArrayList<>();
            Iterator<Long> i = seeds.iterator();
            while (i.hasNext()) {
                long start = i.next();
                long range = i.next();
                seedRanges.add(new SeedRange(start, range));
            }

            humidToLocEntries.sort(AlmanacEntry.DEST);
            tempToHumidEntries.sort(AlmanacEntry.DEST);
            lightToTempEntries.sort(AlmanacEntry.DEST);
            waterToLightEntries.sort(AlmanacEntry.DEST);
            ferilizerToWaterEntries.sort(AlmanacEntry.DEST);
            soilToFertilizerEntries.sort(AlmanacEntry.DEST);
            seedToSoilEntries.sort(AlmanacEntry.DEST);


            long location = 0;
            boolean foundSeed = false;
            while (!foundSeed) {
                long humidity = matchBackwards(location, humidToLocEntries);
                long temp = matchBackwards(humidity, tempToHumidEntries);
                long light = matchBackwards(temp, lightToTempEntries);
                long water = matchBackwards(light, waterToLightEntries);
                long fertilizer = matchBackwards(water, ferilizerToWaterEntries);
                long soil = matchBackwards(fertilizer, soilToFertilizerEntries);
                long seed = matchBackwards(soil, seedToSoilEntries);

                //Does it exist?
                for (SeedRange seedRange : seedRanges) {
                    if (seed >= seedRange.start && seed <= (seedRange.start + seedRange.range - 1)) {
                        foundSeed = true;
                        break;
                    }
                }

                if (!foundSeed)
                    location++;

            }
            System.out.println("Location " + location + " has a seed");
            // Lower than 11 611 183

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }


    }


    private static void readIntoList(BufferedReader reader, List<AlmanacEntry> list) throws IOException {
        //Skip the header and read the first line
        String line = reader.readLine();
        line = reader.readLine();

        while (line != null && !line.isBlank()) {
            list.add(new AlmanacEntry(line));
            line = reader.readLine();
        }
        list.sort(AlmanacEntry.SRC);
    }

    /**
     * Find the destination for a given source in a list of entries.
     * @param source
     * @param entries
     * @return
     */
    public static long matchInList(long source, List<AlmanacEntry> entries) {
        // For each entry
        for (AlmanacEntry entry : entries) {

            //If the source is within the entry's source range
            if (source >= entry.source && source <= (entry.source + entry.range - 1)) {

                //Return the source with the modifier added
                return source + entry.modifier;
            }
        }

        //No entries match so the dest is the same as the source
        return source;
    }


    public static long matchBackwards(long dest, List<AlmanacEntry> entries) {
        for (AlmanacEntry entry : entries) {
            if (dest >= entry.dest && dest <= (entry.dest + entry.range - 1)) {
                return dest - entry.dest + entry.source;
            }
        }
        return dest;
    }

}
