package day9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Day9 {

    static final String fileName = "day9.txt";
    static final Pattern pattern = Pattern.compile(" ");

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream(fileName)))) {
            String line;

            long total = 0;
            long backTotal = 0;
            while ((line = reader.readLine()) != null) {
                total += getNextInSequence(line, true);
                backTotal += getNextInSequence(line, false);
            }
            System.out.println("Total = " + total);
            System.out.println("Prev Total = " + backTotal);

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }


    }

    public static long getNextInSequence(String line, boolean next) {
        return getNextInSequence(pattern.splitAsStream(line)
                    .map(Long::parseLong)
                    .collect(Collectors.toList())
                , next);
    }

    private static long getNextInSequence(List<Long> numbers, boolean next) {
        // If they are all the same, return the value that the list contains
        if (numbers.stream().distinct().count() == 1) {
            return numbers.get(0);
        }

        // Make a list of the differences
        List<Long> differences = new ArrayList<>();
        for (int i = 1; i<numbers.size(); i++ ) {
            long a = numbers.get(i-1);
            long b = numbers.get(i);
            long d = b - a;
            differences.add(d);
        }

        if (next)
            // Return the last number added to the next in the sequence of differences
            return numbers.get(numbers.size() - 1) + getNextInSequence(differences, true);
        else
            // Return the first number minus the prev in the sequence of differences
            return numbers.get(0) - getNextInSequence(differences, false);
    }

}
