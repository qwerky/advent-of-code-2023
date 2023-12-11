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
        Assert.assertEquals("10 rows", 10, rows.size());

        Assert.assertEquals("Row 0", "..x#.x..x.", rows.get(0));
        Assert.assertEquals("Row 1", "..x..x.#x.", rows.get(1));
        Assert.assertEquals("Row 2", "#.x..x..x.", rows.get(2));
        Assert.assertEquals("Row 3", "xxxxxxxxxx", rows.get(3));
        Assert.assertEquals("Row 4", "..x..x#.x.", rows.get(4));
        Assert.assertEquals("Row 5", ".#x..x..x.", rows.get(5));
        Assert.assertEquals("Row 6", "..x..x..x#", rows.get(6));
        Assert.assertEquals("Row 7", "xxxxxxxxxx", rows.get(7));
        Assert.assertEquals("Row 8", "..x..x.#x.", rows.get(8));
        Assert.assertEquals("Row 9", "#.x.#x..x.", rows.get(9));

        Assert.assertEquals("Shortest Path", 374, Day11.getPairDistances(rows, 2));
        Assert.assertEquals("Shortest Path", 1030, Day11.getPairDistances(rows, 10));
        Assert.assertEquals("Shortest Path", 8410, Day11.getPairDistances(rows, 100));
    }



}
