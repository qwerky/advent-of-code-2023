package day5;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Day5Test {



    @Test
    public void testMatch() {
        List<AlmanacEntry> entries = new ArrayList<>();
        entries.add(new AlmanacEntry("50 98 2"));
        entries.add(new AlmanacEntry("52 50 48"));

        Assert.assertEquals("Seed 0", 0, Day5.matchInList(0, entries));
        Assert.assertEquals("Seed 49", 49, Day5.matchInList(49, entries));
        Assert.assertEquals("Seed 50", 52, Day5.matchInList(50, entries));
        Assert.assertEquals("Seed 51", 53, Day5.matchInList(51, entries));
        Assert.assertEquals("Seed 52", 54, Day5.matchInList(52, entries));
        Assert.assertEquals("Seed 53", 55, Day5.matchInList(53, entries));
        Assert.assertEquals("Seed 96", 98, Day5.matchInList(96, entries));
        Assert.assertEquals("Seed 97", 99, Day5.matchInList(97, entries));
        Assert.assertEquals("Seed 98", 50, Day5.matchInList(98, entries));
        Assert.assertEquals("Seed 99", 51, Day5.matchInList(99, entries));
        Assert.assertEquals("Seed 100", 100, Day5.matchInList(100, entries));

    }
}
