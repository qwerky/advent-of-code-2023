package day4;

import day3.Day3;
import org.junit.Assert;
import org.junit.Test;

public class Day4Test {

    @Test
    public void testCard() {
        Assert.assertEquals("Card 1", 8, new Card("Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53").getPoints());
        Assert.assertEquals("Card 2", 2, new Card("Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19").getPoints());
        Assert.assertEquals("Card 3", 2, new Card("Card 3:  1 21 53 59 44 | 69 82 63 72 16 21 14  1").getPoints());
        Assert.assertEquals("Card 4", 1, new Card("Card 4: 41 92 73 84 69 | 59 84 76 51 58  5 54 83").getPoints());
        Assert.assertEquals("Card 5", 0, new Card("Card 5: 87 83 26 28 32 | 88 30 70 12 93 22 82 36").getPoints());
        Assert.assertEquals("Card 6", 0, new Card("Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 11").getPoints());
    }
}
