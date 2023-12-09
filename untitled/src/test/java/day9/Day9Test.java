package day9;

import org.junit.Assert;
import org.junit.Test;

public class Day9Test {

    @Test
    public void testSequence() {
        Assert.assertEquals("Sequence 1", 18, Day9.getNextInSequence("0 3 6 9 12 15", true));
        Assert.assertEquals("Sequence 2", 28, Day9.getNextInSequence("1 3 6 10 15 21", true));
        Assert.assertEquals("Sequence 3", 68, Day9.getNextInSequence("10 13 16 21 30 45", true));
    }

    @Test
    public void testSequenceBackwards() {
        Assert.assertEquals("Sequence 1", -3, Day9.getNextInSequence("0 3 6 9 12 15", false));
        Assert.assertEquals("Sequence 2", 0, Day9.getNextInSequence("1 3 6 10 15 21", false));
        Assert.assertEquals("Sequence 3", 5, Day9.getNextInSequence("10 13 16 21 30 45", false));
    }

}
