package day7;

import java.util.HashMap;
import java.util.Map;

public class Hand implements Comparable<Hand> {

    char[] cards;
    int bid;
    int rank;

    public Hand(String line) {
        line = line.replaceAll("T", "a");
        line = line.replaceAll("J", "b");
        line = line.replaceAll("Q", "c");
        line = line.replaceAll("K", "d");
        line = line.replaceAll("A", "e");

        String[] parts = line.split(" ");
        cards = parts[0].toCharArray();
        bid = Integer.parseInt(parts[1]);

        rank = parseRank(cards);
    }

    protected int parseRank(char[] cards) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c: cards)
            map.merge(c, 1, Integer::sum);

        switch (map.size()) {
            case 1:
                return FIVE;

            case 2:
                if (map.containsValue(4)) {
                    return FOUR;
                } else {
                    assert map.containsValue(3) : "Two different cards, but no set of 3";
                    return FULL_HOUSE;
                }
            case 3:
                if (map.containsValue(2)) {
                    return TWO_PAIR;
                } else {
                    assert map.containsValue(3) : "3 different cards but no 3 of a kind";
                    return THREE;
                }
            case 4:
                return PAIR;
            case 5:
                return HIGH;
            default:
                throw new RuntimeException("Error " + map.size() + " different cards in hand " + new String(cards));
        }

    }


    @Override
    public int compareTo(Hand other) {
        if (this.rank == other.rank) {
            for (int i = 0; i<cards.length; i++) {
                int cardDiff = this.cards[i] - other.cards[i];
                if (cardDiff != 0) {
                    return cardDiff;
                }
            }
            return 0;
        } else {
            return this.rank - other.rank;
        }
    }

    static final int HIGH = 1;
    static final int PAIR = 2;
    static final int TWO_PAIR = 3;
    static final int THREE = 4;
    static final int FULL_HOUSE = 5;
    static final int FOUR = 6;
    static final int FIVE = 7;

}
