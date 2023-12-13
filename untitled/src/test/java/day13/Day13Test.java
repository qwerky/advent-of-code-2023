package day13;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Day13Test {

    @Test
    public void testImage1() {

        List<String> lines = new ArrayList<>();
        lines.add("#.##..##.");
        lines.add("..#.##.#.");
        lines.add("##......#");
        lines.add("##......#");
        lines.add("..#.##.#.");
        lines.add("..##..##.");
        lines.add("#.#.##.#.");
        Image image = new Image(lines);

        Assert.assertEquals("Vertical", 5, image.getScore());
    }

    @Test
    public void testImage2() {

        List<String> lines = new ArrayList<>();
        lines.add("#...##..#");
        lines.add("#....#..#");
        lines.add("..##..###");
        lines.add("#####.##.");
        lines.add("#####.##.");
        lines.add("..##..###");
        lines.add("#....#..#");
        Image image = new Image(lines);

        Assert.assertEquals("Horizontal", 400, image.getScore());
    }
}
