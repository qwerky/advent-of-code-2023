package day8;


import aoc.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;


public class Day8 {

    static final String fileName = "day8.txt";

    public static void main(String[] args) {



        try (BufferedReader reader = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream(fileName)))) {

            Map<String,Node> nodes = new HashMap<>();
            String instructions = reader.readLine();
            reader.readLine();

            String line;
            while ((line = reader.readLine()) != null) {

                String id = line.substring(0, 3);
                String leftId = line.substring(7, 10);
                String rightId = line.substring(12, 15);


                Node node;
                if (nodes.containsKey(id)) {
                    node = nodes.get(id);
                } else {
                    node = new Node(id);
                    nodes.put(id, node);
                }

                Node left;
                if (nodes.containsKey(leftId)) {
                    left = nodes.get(leftId);
                } else {
                    left = new Node(leftId);
                    nodes.put(leftId, left);
                }
                node.left = left;

                Node right;
                if (nodes.containsKey(rightId)) {
                    right = nodes.get(rightId);
                } else {
                    right = new Node(rightId);
                    nodes.put(rightId, right);
                }
                node.right = right;
            }

            // Part 1
            int steps = navigate(instructions, nodes.get("AAA"));
            System.out.println("Took " + steps + " steps");

            // Part 2
            long bigSteps = multiNavigate(instructions, nodes);
            System.out.println("Took " + bigSteps + " steps");

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }


    public static int navigate(String instructions, Node node) {
        int steps = 0;
        int instructionPointer = 0;
        while (!"ZZZ".equals(node.id)) {
            if (instructionPointer == instructions.length()) {
                instructionPointer = 0;
            }
            char instruction = instructions.charAt(instructionPointer);
            if (instruction == 'L') {
                node = node.left;
            } else {
                node = node.right;
            }
            instructionPointer++;
            steps++;
        }
        return steps;
    }

    public static long multiNavigate(String instructions, Map<String, Node> nodes) {
        List<BigInteger> patterns = new ArrayList<>();

        // Find each node that starts with A and add the number
        // of steps for the journey to xxZ into a list. Then we
        // can work out the lowest common multiple of each journey
        for (Node node : nodes.values()) {
            if (node.id.endsWith("A")) {
                int steps = 0;
                int instructionPointer = 0;
                while (!node.id.endsWith("Z")) {
                    if (instructionPointer == instructions.length()) {
                        instructionPointer = 0;
                    }
                    char instruction = instructions.charAt(instructionPointer);
                    if (instruction == 'L') {
                        node = node.left;
                    } else {
                        node = node.right;
                    }
                    instructionPointer++;
                    steps++;
                }

                patterns.add(BigInteger.valueOf(steps));
            }
        }
        return Util.lcm(patterns).longValue();
    }

    private static boolean areWeThereYet(List<Node> nodes) {
        return nodes.stream().allMatch(node -> node.id.endsWith("Z"));
    }


}
