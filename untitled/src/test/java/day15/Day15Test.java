package day15;

import org.junit.Assert;
import org.junit.Test;

public class Day15Test {

    @Test
    public void testHashing() {

        Assert.assertEquals("rn=1", 30, Day15.hash("rn=1"));
        Assert.assertEquals("cm-", 253, Day15.hash("cm-"));
        Assert.assertEquals("qp=3", 97, Day15.hash("qp=3"));
        Assert.assertEquals("cm=2", 47, Day15.hash("cm=2"));
        Assert.assertEquals("qp-", 14, Day15.hash("qp-"));
        Assert.assertEquals("pc=4", 180, Day15.hash("pc=4"));
        Assert.assertEquals("ot=9", 9, Day15.hash("ot=9"));
        Assert.assertEquals("ab=5", 197, Day15.hash("ab=5"));
        Assert.assertEquals("pc-1", 48, Day15.hash("pc-"));
        Assert.assertEquals("pc=6", 214, Day15.hash("pc=6"));
        Assert.assertEquals("ot=7", 231, Day15.hash("ot=7"));
    }



}
