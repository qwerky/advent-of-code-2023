package day12;

import org.junit.Assert;
import org.junit.Test;

public class Day12Test {

    @Test
    public void testSprings() {
        Assert.assertEquals(1, Day12.combinations("???.### 1,1,3"));
        Assert.assertEquals(4, Day12.combinations(".??..??...?##. 1,1,3"));
        Assert.assertEquals(1, Day12.combinations("?#?#?#?#?#?#?#? 1,3,1,6"));
        Assert.assertEquals(1, Day12.combinations("????.#...#... 4,1,1"));
        Assert.assertEquals(4, Day12.combinations("????.######..#####. 1,6,5"));
        Assert.assertEquals(10, Day12.combinations("?###???????? 3,2,1"));
    }


    @Test
    public void testGetWhereDotsCanBeAdded() {

    }

}
