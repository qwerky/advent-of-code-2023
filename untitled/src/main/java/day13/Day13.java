package day13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Day13 {

    static final String fileName = "day13.txt";

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream(fileName)))) {
            String line;
            long total = 0;
            long total2 = 0;
            int count = 0;
            List<String> imageLines = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) {
                    count++;
                    Image image = new Image(imageLines);
                    imageLines.clear();

                    // Part 1
                    long score = image.getScore();
                    total += score;
                    System.out.print("Image " + count + " has score " + score);

                    //Part 2
                    image.smudge = true;
                    long smudgeScore = image.getScore();
                    total2 += smudgeScore;
                    System.out.println(" and smudge score " + smudgeScore);

                    assert score != smudgeScore : "Score are the same after smudging";

                } else {
                    imageLines.add(line);
                }
            }
            System.out.println("Score for part 1 is " + total);
            System.out.println("Score for part 2 is " + total2);

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }


    }

}
