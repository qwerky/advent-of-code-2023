package day11;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Day11Test {

    @Test
    public void testThing() {
        List<String> rows = new ArrayList<>();
        rows.add("...#......");
        rows.add(".......#..");
        rows.add("#.........");
        rows.add("..........");
        rows.add("......#...");
        rows.add(".#........");
        rows.add(".........#");
        rows.add("..........");
        rows.add(".......#..");
        rows.add("#...#.....");

        Day11.expand(rows);
        Assert.assertEquals("12 rows", 12, rows.size());

        Assert.assertEquals("Row 0", "....#........", rows.get(0));
        Assert.assertEquals("Row 1", ".........#...", rows.get(1));
        Assert.assertEquals("Row 2", "#............", rows.get(2));
        Assert.assertEquals("Row 3", ".............", rows.get(3));
        Assert.assertEquals("Row 4", ".............", rows.get(4));
        Assert.assertEquals("Row 5", "........#....", rows.get(5));
        Assert.assertEquals("Row 6", ".#...........", rows.get(6));
        Assert.assertEquals("Row 7", "............#", rows.get(7));
        Assert.assertEquals("Row 8", ".............", rows.get(8));
        Assert.assertEquals("Row 9", ".............", rows.get(9));
        Assert.assertEquals("Row10", ".........#...", rows.get(10));
        Assert.assertEquals("Row11", "#....#.......", rows.get(11));

        Assert.assertEquals("Shortest Path", 374, Day11.getPairDistances(rows));
    }



}
