package day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day4 {

    static final String fileName = "day4.txt";

    public static void main(String[] args) {

        // Part 1
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream(fileName)))) {
            String line;
            int total = 0;
            while ((line = reader.readLine()) != null) {
                Card card = new Card(line);
                total += card.getPoints();
            }
            System.out.println("Total points " + total);

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        //Part 2
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream(fileName)))) {

            int[] cardCounts = new int[188];
            Arrays.fill(cardCounts, 1);

            String line;
            while ((line = reader.readLine()) != null) {
                Card card = new Card(line);

                for (int i=1; i<=card.intersection; i++) {
                    if (card.id + i < 188)
                        cardCounts[card.id + i] += cardCounts[card.id];
                }
            }

            int total = Arrays.stream(cardCounts).sum() - 1;
            System.out.println("Total points " + total);

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }

}
