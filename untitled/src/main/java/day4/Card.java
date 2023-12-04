package day4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Card {

    int id;
    Set<Integer> winners = new HashSet<>();
    Set<Integer> numbers = new HashSet<>();
    long intersection;
    public Card(String line) {
        String[] parts = line.split(":");
        String[] cardParts = parts[0].split("\\s+");
        id = Integer.parseInt(cardParts[1]);

        String[] numberParts = parts[1].trim().split("\\|");

        String[] wins = numberParts[0].trim().split("\\s+");
        winners = Arrays.stream(wins).map(Integer::parseInt).collect(Collectors.toSet());

        String[] ours = numberParts[1].trim().split("\\s+");
        numbers = Arrays.stream(ours).map(Integer::parseInt).collect(Collectors.toSet());

        intersection = winners.stream()
                .filter(numbers::contains)
                .count();
    }

    public long getPoints() {
        if (intersection > 0) {
            return 1 << intersection - 1;
        } else {
            return 0;
        }
    }

}
