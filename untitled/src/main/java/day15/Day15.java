package day15;

import java.util.*;

public class Day15 {

    static final String fileName = "day15.txt";

    static Box[] boxes = new Box[256];
    static {
        for (int i=0; i<boxes.length; i++) {
            boxes[i] = new Box();
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(ClassLoader.getSystemResourceAsStream(fileName)).useDelimiter(",");

        int total = 0;

        while (input.hasNext()) {
            String s = input.next();
            int h = hash(s);

            // Part 1
            total += h;

            // Part 2
            process(s);

        }
        System.out.println("Total is " + total);
        System.out.println("Total2 is " + power());

    }

    public static void process(String s) {
        if (s.endsWith("-")) {
            // Remove label from box
            String label = s.substring(0, s.length()-1);
            int boxId = hash(label);
            boxes[boxId].remove(label);
        } else {
            //Replace or add from box
            String[] parts = s.split("=");
            String label = parts[0];
            int boxId = hash(label);
            Lens lens = new Lens(label, parts[1]);
            boxes[boxId].replace(lens);
        }
    }

    public static int power() {
        int power = 0;
        for (int i=0; i<boxes.length; i++) {
            power += boxes[i].power(i);
        }
        return power;
    }

    public static int hash(String s) {
        int hash = 0;
        for (char c : s.toCharArray()) {
            hash += c;
            hash *= 17;
            hash = hash % 256;
        }
        return hash;
    }


}
