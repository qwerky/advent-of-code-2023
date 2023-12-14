package day14;

import aoc.Util;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.util.List;

public class Day14 {

    static final String fileName = "day14.txt";


    public static void main(String[] args) throws URISyntaxException, IOException {

        List<String> lines = Files.lines(Util.path(fileName)).toList();
        Platform platform = new Platform(lines);

        // Part 1
        platform.tiltNorth();
        System.out.println("Load is " + platform.getLoad());

        // Part 2
        System.out.println("Load is " + platform.spin(1000000000));

    }

}
