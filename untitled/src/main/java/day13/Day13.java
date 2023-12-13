package day13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Day13 {

    static final String fileName = "day13.txt";

    public static void main(String[] args) {

        // Part 1
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream(fileName)))) {
            String line;
            long total = 0;
            int count = 0;
            List<String> imageLines = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) {
                    count++;
                    Image image = new Image(imageLines);
                    imageLines.clear();
                    long score = image.getScore();
                    total += score;
                    System.out.println("Image " + count + " has score " + score);
                } else {
                    imageLines.add(line);
                }
            }
            System.out.println("Score for part 1 is " + total);

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }


    }

}
