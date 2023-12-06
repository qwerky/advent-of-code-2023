package day6;


import java.util.ArrayList;
import java.util.List;


public class Day6 {

    static final String fileName = "day6.txt";


    public static void main(String[] args) {

        // Likely easier to work out on pen and paper by solving
        // the quadratic equation x^2 - tx + d = 0 and counting
        // integers between the two solutions.
        // But hey; this is a programming challenge not a maths challenge!!

        // Part 1
        int answer = 1;
        answer *= getWinningOptions(48, 296).size();
        answer *= getWinningOptions(93, 1928).size();
        answer *= getWinningOptions(85, 1236).size();
        answer *= getWinningOptions(95, 1391).size();
        System.out.println("Answer is " + answer);

        //Part 2
        answer = getWinningOptions(48938595d, 296192812361391d).size();
        System.out.println("Answer is " + answer);
    }


    public static List<Integer> getWinningOptions(double timeToBeat, double distance) {
        List<Integer> results = new ArrayList<>();
        for (int buttonTime=1; buttonTime<timeToBeat; buttonTime++) {
            double totalTime = buttonTime + distance / buttonTime;
            if (totalTime < timeToBeat) {
                results.add(buttonTime);
            }
        }
        return results;
    }

}
