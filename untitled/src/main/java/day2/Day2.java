package day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static aoc.Util.parseIntOrWord;

public class Day2 {

    static final String fileName = "day2.txt";

    static Map<String, Integer> cubeCounts = new HashMap<>();
    static {
        cubeCounts.put("red", 12);
        cubeCounts.put("green", 13);
        cubeCounts.put("blue", 14);
    }

    public static void main(String[] args) {

        // Part 1
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream(fileName)))) {
            String line;
            int total = 0;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                int gameId = Integer.parseInt(parts[0].split(" ")[1]);
                if (isPossible(parts[1])) {
                    total += gameId;
                }
            }
            System.out.println("Sum of valid gameIds is " + total);

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }


        // Part 2
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream(fileName)))) {
            String line;
            int total = 0;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                total += gamePower(parts[1]);
            }
            System.out.println("Sum of game powers is " + total);

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }

    public static boolean isPossible(String game) {
        // Split into reveals, each reveal will be of the form;
        //   n colour, n colour, n colour
        for (String reveal : game.trim().split(";")) {
            // Split into colours, each colour will be of the form;
            //  n colour
            for (String colour : reveal.trim().split(",")) {
                int n = Integer.parseInt(colour.trim().split(" ")[0]);
                String c = colour.trim().split(" ")[1];
                if (n > cubeCounts.get(c)) {
                    return false;
                }
            }
        }
        return true;
    }


    public static int gamePower(String game) {
        cubeCounts.put("red", 0);
        cubeCounts.put("blue", 0);
        cubeCounts.put("green", 0);
        // Split into reveals, each reveal will be of the form;
        //   n colour, n colour, n colour
        for (String reveal : game.trim().split(";")) {
            // Split into colours, each colour will be of the form;
            //  n colour
            for (String colour : reveal.trim().split(",")) {
                int n = Integer.parseInt(colour.trim().split(" ")[0]);
                String c = colour.trim().split(" ")[1];

                if (n > cubeCounts.get(c)) {
                    cubeCounts.put(c, n);
                }
            }
        }
        return cubeCounts.get("red") * cubeCounts.get("blue") * cubeCounts.get("green");
    }
}
