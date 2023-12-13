package day12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Day12 {

    static final String fileName = "day12.txt";

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream(fileName)))) {
            String line;
            int lineCounter = 0;
            long total = 0;
            long total2 = 0;
            while ((line = reader.readLine()) != null) {
                lineCounter++;
                try {
                    HotSpring spring = new HotSpring(line);
                    total += spring.getArrangements();
                    spring = new HotSpring(line, 5);
                    total2 += spring.getArrangements();
                } catch (Exception ex) {
                    System.out.println("Error on line " + lineCounter);
                    throw ex;
                }
            }
            System.out.println("Total combinations is " + total);
            System.out.println("Total combinations for part 2 " + total2);

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }

}
