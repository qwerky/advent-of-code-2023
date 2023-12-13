package day12;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

public class Day12Test {

    @Test
    public void testSprings() {
        Assert.assertEquals("#", 1, new HotSpring("# 1").getArrangements());
        Assert.assertEquals("?", 1, new HotSpring("# 1").getArrangements());
        Assert.assertEquals("???.### 1,1,3", 1, new HotSpring("???.### 1,1,3").getArrangements());
        Assert.assertEquals(".??..??...?##. 1,1,3", 4, new HotSpring(".??..??...?##. 1,1,3").getArrangements());
        Assert.assertEquals("?#?#?#?#?#?#?#? 1,3,1,6", 1, new HotSpring("?#?#?#?#?#?#?#? 1,3,1,6").getArrangements());
        Assert.assertEquals("????.#...#... 4,1,1", 1, new HotSpring("????.#...#... 4,1,1").getArrangements());
        Assert.assertEquals("????.######..#####. 1,6,5", 4, new HotSpring("????.######..#####. 1,6,5").getArrangements());
        Assert.assertEquals("?###???????? 3,2,1", 10, new HotSpring("?###???????? 3,2,1").getArrangements());
    }

    @Test
    public void testBigSprings() {
        Assert.assertEquals("???.### 1,1,3", 1, new HotSpring("???.### 1,1,3", 5).getArrangements());
        Assert.assertEquals(".??..??...?##. 1,1,3", 16384, new HotSpring(".??..??...?##. 1,1,3", 5).getArrangements());
        Assert.assertEquals("?#?#?#?#?#?#?#? 1,3,1,6", 1, new HotSpring("?#?#?#?#?#?#?#? 1,3,1,6", 5).getArrangements());
        Assert.assertEquals("????.#...#... 4,1,1", 16, new HotSpring("????.#...#... 4,1,1", 5).getArrangements());
        Assert.assertEquals("????.######..#####. 1,6,5", 2500, new HotSpring("????.######..#####. 1,6,5", 5).getArrangements());
        Assert.assertEquals("?###???????? 3,2,1", 506250, new HotSpring("?###???????? 3,2,1", 5).getArrangements());
    }

}
