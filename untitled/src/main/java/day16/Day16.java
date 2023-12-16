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
        table.energise(0, 0, Table.R);
        System.out.println("Energised tiles is " + table.countEngergisedTiles());

        // Part 2
        int highest = 0;

        // Left
        for (int y = 0; y<table.height; y++) {
            table.energise(0, y, Table.R);
            int score = table.countEngergisedTiles();
            table.reset();
            if (score > highest)
                highest = score;
        }

        // Right
        for (int y = 0; y<table.height; y++) {
            table.energise(table.width-1, y, Table.L);
            int score = table.countEngergisedTiles();
            table.reset();
            if (score > highest)
                highest = score;
        }

        // Top
        for (int x = 0; x<table.width; x++) {
            table.energise(x, 0, Table.D);
            int score = table.countEngergisedTiles();
            table.reset();
            if (score > highest)
                highest = score;
        }

        // Bottom
        for (int x = 0; x<table.width; x++) {
            table.energise(x, table.height-1, Table.U);
            int score = table.countEngergisedTiles();
            table.reset();
            if (score > highest)
                highest = score;
        }

        System.out.println("Highest energy is " + highest);
    }

}
