package day7;

public class AltJokerHand extends Hand {

    public AltJokerHand(String line) {
        super(line.replaceAll("J", "0"));
    }

    protected int parseRank(char[] cards) {
        int jokerCount = 0;
        for (char c: cards)
            if (c == '0') jokerCount++;

        int rank = super.parseRank(cards);
        if (jokerCount == 0)
            return rank;

        // Hands with jokers are boosted two ranks except;
        // A high becomes a pair
        if (rank == HIGH)
            return PAIR;

        // Two pairs, where one pair are jokers become four of a kind
        if (rank == TWO_PAIR && jokerCount == 2)
            return FOUR;

        // Anything else gets boosted 2 ranks up to the max rank
        //    A pair becomes three of a kind
        //    Two pair and one joker becomes a full house
        //    Three of a kind becomes four of a kind
        //    Full house becomes five
        //    Four becomes five
        return Math.min(FIVE, rank + 2);
    }
}
