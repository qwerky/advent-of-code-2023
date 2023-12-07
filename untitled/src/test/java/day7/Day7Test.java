package day7;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day7Test {

    @Test
    public void testRanks() {
        Assert.assertEquals("Rank is five", Hand.FIVE, new Hand("AAAAA 1").rank);
        Assert.assertEquals("Rank is four", Hand.FOUR, new Hand("AAAAB 1").rank);
        Assert.assertEquals("Rank is full house", Hand.FULL_HOUSE, new Hand("AAABB 1").rank);
        Assert.assertEquals("Rank is three", Hand.THREE, new Hand("AAACD 1").rank);
        Assert.assertEquals("Rank is two pair", Hand.TWO_PAIR, new Hand("AABBC 1").rank);
        Assert.assertEquals("Rank is pair", Hand.PAIR, new Hand("AABCD 1").rank);
        Assert.assertEquals("Rank is high", Hand.HIGH, new Hand("ABCDE 1").rank);
    }

    @Test
    public void testJokerRanks() {
        Assert.assertEquals("Rank is five", Hand.FIVE, new JokerHand("JAAAA 1").rank);
        Assert.assertEquals("Rank is four", Hand.FOUR, new JokerHand("AJAAB 1").rank);
        Assert.assertEquals("Rank is full house", Hand.FULL_HOUSE, new JokerHand("AAJBB 1").rank);
        Assert.assertEquals("Rank is three", Hand.THREE, new JokerHand("AJACD 1").rank);
        Assert.assertEquals("Rank is pair", Hand.PAIR, new JokerHand("JABCD 1").rank);
    }

    @Test
    public void testTotals() {
        Hand hand1 = new Hand("32T3K 765");
        Assert.assertEquals("Hand 1", Hand.PAIR, hand1.rank);

        Hand hand2 = new Hand("T55J5 684");
        Assert.assertEquals("Hand 2", Hand.THREE, hand2.rank);

        Hand hand3 = new Hand("KK677 28");
        Assert.assertEquals("Hand 3", Hand.TWO_PAIR, hand3.rank);

        Hand hand4 = new Hand("KTJJT 220");
        Assert.assertEquals("Hand 4", Hand.TWO_PAIR, hand4.rank);

        Hand hand5 = new Hand("QQQJA 483");
        Assert.assertEquals("Hand 5", Hand.THREE, hand5.rank);

        List<Hand> hands = new ArrayList<>();
        hands.add(hand1);
        hands.add(hand2);
        hands.add(hand3);
        hands.add(hand4);
        hands.add(hand5);

        Collections.sort(hands);

        Assert.assertEquals("Total winnings ", 6440, Day7.getTotal(hands));
    }

    @Test
    public void testJokerTotals() {
        Hand hand1 = new JokerHand("32T3K 765");
        Assert.assertEquals("Hand 1", Hand.PAIR, hand1.rank);

        Hand hand2 = new JokerHand("T55J5 684");
        Assert.assertEquals("Hand 2", Hand.FOUR, hand2.rank);

        Hand hand3 = new JokerHand("KK677 28");
        Assert.assertEquals("Hand 3", Hand.TWO_PAIR, hand3.rank);

        Hand hand4 = new JokerHand("KTJJT 220");
        Assert.assertEquals("Hand 4", Hand.FOUR, hand4.rank);

        Hand hand5 = new JokerHand("QQQJA 483");
        Assert.assertEquals("Hand 5", Hand.FOUR, hand5.rank);

        List<Hand> hands = new ArrayList<>();
        hands.add(hand1);
        hands.add(hand2);
        hands.add(hand3);
        hands.add(hand4);
        hands.add(hand5);

        Collections.sort(hands);

        Assert.assertEquals("Total winnings ", 5905, Day7.getTotal(hands));
    }

}
