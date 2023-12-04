package day3;

import day2.Day2;
import org.junit.Assert;
import org.junit.Test;

public class Day3Test {

    private String[] schematic;

    public Day3Test() {
        schematic = new String[] {
                "467..114..",
                "...*......",
                "..35..633.",
                "......#...",
                "617*......",
                ".....+.58.",
                "..592.....",
                "......755.",
                "...$.*....",
                ".664.598.."
        };
        Day3.symbols.add('*');
        Day3.symbols.add('#');
        Day3.symbols.add('+');
        Day3.symbols.add('$');
    }

    @Test
    public void testCount() {
        Assert.assertEquals("Count", 4361, Day3.countParts(schematic));
    }

    @Test
    public void testGears() {
        Assert.assertEquals("Gears", 467835, Day3.getGearRatios(schematic));
    }
}
