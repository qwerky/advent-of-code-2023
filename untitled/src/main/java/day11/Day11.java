package day11;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Day11 {

    static final String fileName = "day11.txt";


    public static void main(String[] args) {

        // Part 1
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream(fileName)))) {
            String line;

            List<String> rows = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                rows.add(line);
            }
            expand(rows);
            int pairDistances = getPairDistances(rows);
            System.out.println("Pair distances is " + pairDistances);


        } catch (IOException ioe) {
            ioe.printStackTrace();
        }


    }

    public static void expand(List<String> rows) {
        int width = rows.get(0).length();
        String emptyRow = ".".repeat(width);
        ListIterator<String> iterator = rows.listIterator();
        while (iterator.hasNext()) {
            String row = iterator.next();
            if (!row.contains("#")) {
                iterator.add(emptyRow);
            }
        }

        int height = rows.size();
        for (int col = width-1; col>=0; col--) {
            boolean isEmpty = true;
            for (String row : rows) {
                if (row.charAt(col) == '#') {
                    isEmpty = false;
                    break;
                }
            }
            if (isEmpty) {
                for (int row = 0; row<height; row++) {
                    String old = rows.get(row);
                    String newRow = old.substring(0, col) + "." + old.substring(col);
                    rows.set(row, newRow);
                }
            }
        }
    }

    public static int getPairDistances(List<String> rows) {
        // Build a list of all the galaxy locations
        List<Point> locs = new ArrayList<>();
        for (int row = 0; row<rows.size(); row++) {
            for (int col = 0; col<rows.get(row).length(); col++) {
                if (rows.get(row).charAt(col) == '#') {
                    locs.add(new Point(col, row));
                }
            }
        }
        System.out.println("There are " + locs.size() + " galaxies");
        int total = 0;
        for (int i=0; i<locs.size(); i++) {
            for (int j=i+1; j<locs.size(); j++) {
                Point a = locs.get(i);
                Point b = locs.get(j);
                int dist = Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
                total += dist;
            }
        }
        return total;
    }

}
