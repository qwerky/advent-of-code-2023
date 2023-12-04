package day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static aoc.Util.parseIntOrWord;

public class Day1 {

    static final String fileName = "day1.txt";

    static final Pattern pattern1 = Pattern.compile("\\d");
    static final Pattern pattern2 = Pattern.compile("(?=(\\d|one|two|three|four|five|six|seven|eight|nine))");

    public static void main(String[] args) {

        // Part 1
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream(fileName)))) {
            String line;
            int total = 0;
            while ((line = reader.readLine()) != null) {
                total += getCalibrationValue(line);
            }
            System.out.println("Calibration Total: " + total);

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }


        // Part 2
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream(fileName)))) {
            String line;
            int total = 0;
            while ((line = reader.readLine()) != null) {
                total += getDigitCalibrationValue(line);
            }
            System.out.println("Digit Calibration Total: " + total);

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }


    static int getCalibrationValue(final String line) {
        int first = -1;
        int last = -1;

        Matcher matcher = pattern1.matcher(line);
        while (matcher.find()) {
            if (first == -1) {
                first = Integer.parseInt(matcher.group());
            }
            last = Integer.parseInt(matcher.group());
        }

        assert first != -1 : "Didn't find first";
        assert last != -1 : "Didn't find last";
        return 10 * first + last;
    }

    static int getDigitCalibrationValue(final String line) {
        int first = -1;
        int last = -1;

        Matcher matcher = pattern2.matcher(line);
        while (matcher.find()) {
            if (first == -1) {
                first = parseIntOrWord(matcher.group(1));
            }
            last = parseIntOrWord(matcher.group(1));
        }

        assert first != -1 : "Didn't find first";
        assert last != -1 : "Didn't find last";
        return 10 * first + last;
    }

}
