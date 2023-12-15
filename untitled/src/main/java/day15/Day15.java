package day15;

import java.util.Scanner;

public class Day15 {

    static final String fileName = "day15.txt";



    public static void main(String[] args) {

        Scanner input = new Scanner(ClassLoader.getSystemResourceAsStream(fileName)).useDelimiter(",");

        int total = 0;
        while (input.hasNext()) {
            total += hash(input.next());
        }
        System.out.println("Total is " + total);
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
