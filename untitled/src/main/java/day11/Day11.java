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

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream(fileName)))) {
            String line;

            List<String> rows = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                rows.add(line);
            }
            expand(rows);

            // Part 1
            long pairDistances = getPairDistances(rows, 2);
            System.out.println("Pair distances for 1 is " + pairDistances);

            // Part 1
            pairDistances = getPairDistances(rows, 1000000);
            System.out.println("Pair distances for 1 million is " + pairDistances);
            // 1115744135 too low

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }


    }

    public static void expand(List<String> rows) {
        int width = rows.get(0).length();
        String emptyRow = "x".repeat(width);
        for (int row = 0; row<rows.size(); row++) {
            if (!rows.get(row).contains("#")) {
                rows.set(row, emptyRow);
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
                    String newRow = old.substring(0, col) + "x" + old.substring(col+1);
                    rows.set(row, newRow);
                }
            }
        }
    }

    public static long getPairDistances(List<String> rows, int separation) {
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
        long total = 0;
        for (int i=0; i<locs.size(); i++) {
            for (int j=i+1; j<locs.size(); j++) {
                Point a = locs.get(i);
                Point b = locs.get(j);
                total += getPairDistance(a, b, rows, separation);
            }
        }
        return total;
    }

    public static long getPairDistance(Point a, Point b, List<String> rows, int separation) {
        long h = 0;
        int x = a.x;
        while (x != b.x) {
            x += Integer.signum(b.x - a.x);
            char c = rows.get(a.y).charAt(x);
            if (c == 'x')
                h += separation;
            else
                h ++;
        }

        long v = 0;
        int y = a.y;
        while (y != b.y) {
            y += Integer.signum(b.y - a.y);
            char c = rows.get(y).charAt(a.x);
            if (c == 'x')
                v += separation;
            else
                v ++;
        }

        return h + v;
    }

}
