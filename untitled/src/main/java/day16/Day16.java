package day16;

import aoc.Util;

import java.nio.file.Files;
import java.util.List;

public class Day16 {

    static final String fileName = "day16.txt";

    public static void main(String[] args) throws Exception {

        List<String> lines = Files.lines(Util.path(fileName)).toList();
        Table table = new Table(lines);

        // Part 1
        table.energise();
        System.out.println("Energised tiles is " + table.countEngergisedTiles());
    }

}
