package day12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Day12 {

    static final String fileName = "day12.txt";


    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream(fileName)))) {
            String line;
            int lineCounter = 0;
            int total = 0;
            while ((line = reader.readLine()) != null) {
                lineCounter++;
                try {
                    total += combinations(line);
                } catch (Exception ex) {
                    System.out.println("Error on line " + lineCounter);
                    throw ex;
                }
            }
            System.out.println("Total combinations is " + total);


        } catch (IOException ioe) {
            ioe.printStackTrace();
        }


    }

    public static long combinations(String line) {
        String[] parts = line.split(" ");

        try {
            //Strip leading, trailing and sequential dots as they are irrelevant
            String toMatch = parts[0].replaceAll("\\A\\.+", "")
                    .replaceAll("\\.+\\z", "")
                    .replaceAll("\\.+", ".");

            /*
                Strategy is to create a minimal arrangement of hashes
                matching the known groups, separating each group with a dot
                so 1,1,3 would have a minimal arrangement of #.#.###

                Then we can see how many dots need to be added to make
                the arrangement the same length of the unknown arrangement
                that we have to match against

                Once we know how many dots need to be added we can test all
                possible combinations of adding dots, then see if it is a match
             */

            List<Integer> groups = Pattern.compile(",").splitAsStream(parts[1])
                    .mapToInt(Integer::parseInt).boxed().toList();

            StringBuilder minArrangementBuilder = new StringBuilder();
            for (int i : groups) {
                String section = "#".repeat(i) + ".";
                minArrangementBuilder.append(section);
            }
            String minArrangement = minArrangementBuilder.substring(0, minArrangementBuilder.length()-1);

            if (minArrangement.length() == toMatch.length())
                return 1;

            Set<String> validArrangements = new HashSet<>();
            populateValidArrangements(validArrangements, minArrangement, toMatch);
            return validArrangements.size();

        } catch (Exception ex) {
            System.err.println("Ooops " + line);
            throw ex;
        }
    }

    private static void populateValidArrangements(Set<String> validArrangements, String arrangement, String toMatch) {
        int dotsToAdd = toMatch.length() - arrangement.length();

        if (dotsToAdd == 0) {
            if (isArrangementValid(arrangement, toMatch)) {
                validArrangements.add(arrangement);
            }
            return;
        }

        //For each space where you can add a dot
        for (int pos : getWhereDotsCanBeAdded(arrangement)) {

            //Add the dot
            String prefix = arrangement.substring(0, pos);
            String suffix = arrangement.substring(pos);
            String newArrangement = prefix + "." + suffix;

            //Recurse
            populateValidArrangements(validArrangements, newArrangement, toMatch);
        }

    }

    public static List<Integer> getWhereDotsCanBeAdded(String arrangement) {
        List<Integer> positions = new ArrayList<>();
        positions.add(0);

        boolean onHash = false;
        for (int pos=0; pos<arrangement.length(); pos++) {
            char c = arrangement.charAt(pos);
            if (c == '#')
                onHash = true;
            if (c == '.' && onHash) {
                onHash = false;
                positions.add(pos);
            }
        }
        if (onHash)
            positions.add(arrangement.length());

        return positions;
    }

    public static boolean isArrangementValid(String arrangement, String toMatch) {
        boolean valid = true;

        if (arrangement.length() != toMatch.length())
            return false;

        for (int i=0; i<arrangement.length(); i++) {
            if (toMatch.charAt(i) == '#' && arrangement.charAt(i) != '#')
                return false;
            if (toMatch.charAt(i) == '.' && arrangement.charAt(i) != '.')
                return false;
        }

        return valid;
    }

}
