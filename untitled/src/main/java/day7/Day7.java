package day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static aoc.Util.parseIntOrWord;

public class Day7 {

    static final String fileName = "day7.txt";

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream(fileName)))) {

            List<Hand> hands = new ArrayList<>();
            List<Hand> jokerHands = new ArrayList<>();
            List<Hand> altJokerHands = new ArrayList<>();

            String line;
            while ((line = reader.readLine()) != null) {
                hands.add(new Hand(line));
                jokerHands.add(new JokerHand(line));
                altJokerHands.add(new AltJokerHand(line));
            }

            Collections.sort(hands);
            Collections.sort(jokerHands);
            Collections.sort(altJokerHands);

            System.out.println("Total is " + getTotal(hands));
            System.out.println("Joker Total is " + getTotal(jokerHands));
            System.out.println("AltJoker Total is " + getTotal(altJokerHands));

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }

    public static long getTotal(List<Hand> hands) {
        long total = 0;
        for (int i = 0; i< hands.size(); i++) {
            Hand hand = hands.get(i);
            total += hand.bid * (i+1);
        }
        return total;
    }

}
