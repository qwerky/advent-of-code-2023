package day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Day3 {

    static final String fileName = "day3.txt";
    static final Pattern pattern = Pattern.compile("\\d+");
    static final Set<Character> symbols = new HashSet<>();

    //Part 2
    static final Map<String, List<Integer>> gearSystems = new HashMap<>();

    public static void main(String[] args) {

        String[] schematic = loadSchematic();

        // Part 1
        int total = countParts(schematic);
        System.out.println("Sum of parts is " + total);


        // Part 2
        total = getGearRatios(schematic);
        System.out.println("Sum of gear ratios is " + total);

    }

    public static int countParts(String[] schematic) {
        int total = 0;
        for (int i=0; i<schematic.length; i++) {
            Matcher matcher = pattern.matcher(schematic[i]);
            while (matcher.find()) {
                int number = Integer.parseInt(matcher.group());
                int start = matcher.start();
                int end = matcher.end();

                boolean valid = false;
                //Check to see if the number has an adjacent symbol
                if (start > 0 && symbols.contains(schematic[i].charAt(start-1))) {
                    //Left
                    valid = true;
                } else if (end < schematic[i].length() && symbols.contains(schematic[i].charAt(end))) {
                    //Right
                    valid = true;
                }
                if (i > 0) {
                    //Above
                    String above = schematic[i-1].substring(Math.max(0, start-1), Math.min(end+1, schematic[i].length()));
                    if (above.chars().mapToObj(c -> (char)c).anyMatch(symbols::contains)) {
                        valid = true;
                    }
                }
                if (i < schematic.length - 1) {
                    //Below
                    String below = schematic[i+1].substring(Math.max(0, start-1), Math.min(end+1, schematic[i].length()));
                    if (below.chars().mapToObj(c -> (char)c).anyMatch(symbols::contains)) {
                        valid = true;
                    }
                }

                if (valid) {
                    total += number;
                }

            }
        }
        return total;
    }


    public static int getGearRatios(String[] schematic) {

        // Strategy is to iterate through the schematic looking at all tha parts (numbers) and
        // seeing which ones are part of a "gear system". Each gear system will be put into a map
        // with the location of gear ('*' character) as the map key and the ratio as the map value.
        
        for (int i=0; i<schematic.length; i++) {
            Matcher matcher = pattern.matcher(schematic[i]);
            while (matcher.find()) {
                int number = Integer.parseInt(matcher.group());
                int start = matcher.start();
                int end = matcher.end();

                //Check to see if the number has an adjacent gear
                if (start > 0 && schematic[i].charAt(start-1) == '*') {
                    //Left
                    String key = i + "," + (start-1);
                    addToGears(key, number);
                } else if (end < schematic[i].length() && schematic[i].charAt(end) == '*') {
                    //Right
                    String key = i + "," + end;
                    addToGears(key, number);
                }
                if (i > 0) {
                    //Above
                    int s = Math.max(0, start-1);
                    int limit = Math.min(end+1, schematic[i].length());
                    for (int pos = s; pos<limit; pos++) {
                        if (schematic[i-1].charAt(pos) == '*') {
                            String key = (i-1) + "," + pos;
                            addToGears(key, number);
                        }
                    }

                }
                if (i < schematic.length - 1) {
                    //Below
                    int s = Math.max(0, start-1);
                    int limit = Math.min(end+1, schematic[i].length());
                    for (int pos = s; pos<limit; pos++) {
                        if (schematic[i+1].charAt(pos) == '*') {
                            String key = (i+1) + "," + pos;
                            addToGears(key, number);
                        }
                    }
                }

            }
        }

        int total = 0;
        for (List<Integer> list : gearSystems.values()) {
            // Gear with only 1 part are not included
            if (list.size() > 1) {
                total += list.stream().reduce(1, (a,b) -> a*b);
            }
        }
        return total;
    }

    private static void addToGears(String key, int number) {
        if (!gearSystems.containsKey(key)) {
            List<Integer> list = new ArrayList<>();
            gearSystems.put(key, list);
        }
        gearSystems.get(key).add(number);
    }

    private static String[] loadSchematic() {
        List<String> schematic = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream(fileName)))) {
            String line;

            int i = 0;
            while ((line = reader.readLine()) != null) {
                schematic.add(line);
                for (char c : line.toCharArray())
                    symbols.add(c);
                i++;
            }
            symbols.removeIf(c -> c == '.' || (c > 47 && c < 58));

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return schematic.toArray(new String[]{});
    }

}
