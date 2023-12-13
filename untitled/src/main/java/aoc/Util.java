package aoc;

import java.math.BigInteger;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Util {

    public static Path path(String filename) throws URISyntaxException {
        return Path.of(ClassLoader.getSystemResource(filename).toURI());
    }

    public static String[] fillArray(String member, int size) {
        String[] array = new String[size];
        Arrays.fill(array, member);
        return array;
    }

    public static String reverse(final String string) {
        char[] chars = string.toCharArray();
        int start = 0;
        int end = chars.length - 1;
        char temp;
        while (end > start) {
            temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            end--;
            start++;
        }
        return new String(chars);
    }


    public static int parseIntOrWord(final String s) {
        try {
            return Integer.parseInt(s);
        } catch (Exception ex) {
            switch (s) {
                case "zero": return 0;
                case "one": return 1;
                case "two": return 2;
                case "three": return 3;
                case "four": return 4;
                case "five": return 5;
                case "six": return 6;
                case "seven": return 7;
                case "eight": return 8;
                case "nine": return 9;
            }
        }
        throw new NumberFormatException("Can't parse " + s);
    }

    public static BigInteger lcm(List<BigInteger> numbers) {
        BigInteger lcm = numbers.get(0);
        for (BigInteger number : numbers) {
             lcm = lcm(lcm, number);
        }
        return lcm;
    }

    public static BigInteger lcm(BigInteger a, BigInteger b) {
        BigInteger gcd = a.gcd(b);
        return a.multiply(b).abs().divide(gcd);
    }
}
