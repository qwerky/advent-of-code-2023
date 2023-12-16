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

    @Test
    public void testBoxes() {
        Day15.process("rn=1");
        Day15.process("cm-");
        Day15.process("qp=3");
        Day15.process("cm=2");
        Day15.process("qp-");
        Day15.process("pc=4");
        Day15.process("ot=9");
        Day15.process("ab=5");
        Day15.process("pc-");
        Day15.process("pc=6");
        Day15.process("ot=7");

        Assert.assertEquals("Box 0 has 2 items", 2, Day15.boxes[0].contents.size());
        Assert.assertEquals("Box 3 has 3 items", 3, Day15.boxes[3].contents.size());

        // Test the known 5 lenses
        testBoxAndPosition(0, 0, "rn", 1);
        testBoxAndPosition(0, 1, "cm", 2);
        testBoxAndPosition(3, 0, "ot", 7);
        testBoxAndPosition(3, 1, "ab", 5);
        testBoxAndPosition(3, 2, "pc", 6);

        // Test other boxes are empty
        for (int i=0; i<256; i++)
            if (i != 0 && i != 3)
                Assert.assertEquals("Box " + i + " is empty ", 0, Day15.boxes[i].contents.size());

        // Test box power
        Assert.assertEquals("Box 0 power", 5, Day15.boxes[0].power(0));
        Assert.assertEquals("Box 3 power", 140, Day15.boxes[3].power(3));


    }

    private void testBoxAndPosition(int boxId, int pos, String label, int fl) {
        Box box = Day15.boxes[boxId];
        Assert.assertNotNull("Box " + boxId + " not null", box);
        Assert.assertEquals("Box " + boxId + " lens at " + pos + " label is " + label, label, box.contents.get(pos).label);
        Assert.assertEquals("Box " + boxId + " lens at " + pos + " fl is " + fl, fl, box.contents.get(pos).fl);
    }

}
