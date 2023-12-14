package day14;

import aoc.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Day14 {

    static final String fileName = "day14.txt";


    public static void main(String[] args) throws URISyntaxException, IOException {

        List<String> lines = Files.lines(Util.path(fileName)).toList();
        Platform platform = new Platform(lines);
        platform.tilt();
        System.out.println("Load is " + platform.getLoad());

    }

}
