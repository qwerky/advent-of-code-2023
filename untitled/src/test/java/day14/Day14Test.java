package day14;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Day14Test {

    @Test
    public void testThing() {

        List<String> lines = new ArrayList<>();
        lines.add("O....#....");
        lines.add("O.OO#....#");
        lines.add(".....##...");
        lines.add("OO.#O....O");
        lines.add(".O.....O#.");
        lines.add("O.#..O.#.#");
        lines.add("..O..#O..O");
        lines.add(".......O..");
        lines.add("#....###..");
        lines.add("#OO..#....");

        Platform platform = new Platform(lines);
        platform.tiltNorth();

        Assert.assertEquals("Row 1", "OOOO.#.O..", new String(platform.data[0]));
        Assert.assertEquals("Load", 136, platform.getLoad());

        Assert.assertEquals("Load", 64, platform.spin(1000000000));

    }

}
