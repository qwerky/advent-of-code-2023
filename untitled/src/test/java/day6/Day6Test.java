package day6;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;


public class Day6Test {



    @Test
    public void testRace1() {
        List<Integer> results = Day6.getWinningOptions(7, 9);
        Assert.assertEquals("4 results", 4, results.size());
        Assert.assertTrue("Contains 2", results.contains(2));
        Assert.assertTrue("Contains 3", results.contains(3));
        Assert.assertTrue("Contains 4", results.contains(4));
        Assert.assertTrue("Contains 5", results.contains(5));
    }

    @Test
    public void testRace2() {
        List<Integer> results = Day6.getWinningOptions(15, 40);
        Assert.assertEquals("8 results", 8, results.size());
        Assert.assertTrue("Contains 4", results.contains(4));
        Assert.assertTrue("Contains 5", results.contains(5));
        Assert.assertTrue("Contains 6", results.contains(6));
        Assert.assertTrue("Contains 7", results.contains(7));
        Assert.assertTrue("Contains 8", results.contains(8));
        Assert.assertTrue("Contains 9", results.contains(9));
        Assert.assertTrue("Contains 10", results.contains(10));
        Assert.assertTrue("Contains 11", results.contains(11));
    }

    @Test
    public void testRace3() {
        List<Integer> results = Day6.getWinningOptions(30, 200);
        Assert.assertEquals("9 results", 9, results.size());
        Assert.assertTrue("Contains 11", results.contains(11));
        Assert.assertTrue("Contains 12", results.contains(12));
        Assert.assertTrue("Contains 13", results.contains(13));
        Assert.assertTrue("Contains 14", results.contains(14));
        Assert.assertTrue("Contains 15", results.contains(15));
        Assert.assertTrue("Contains 16", results.contains(16));
        Assert.assertTrue("Contains 17", results.contains(17));
        Assert.assertTrue("Contains 18", results.contains(18));
        Assert.assertTrue("Contains 19", results.contains(19));
    }
}
