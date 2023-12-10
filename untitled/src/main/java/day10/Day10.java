package day10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Pattern;

public class Day10 {

    static final String fileName = "day10.txt";
    static Map<String, Integer> processed = new HashMap<>();
    static Pattern boundaryPattern = Pattern.compile("-|FJ|7L");

    public static void main(String[] args) throws Exception {

        char[][] maze = new char[140][];

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream(fileName)))) {
            String line;
            int n = 0;
            MazePoint start = null;

            while ((line = reader.readLine()) != null) {
                maze[n] = line.toCharArray();
                if (line.contains("S")) {
                    start = new MazePoint(line.indexOf("S"), n, 0);
                }
                n++;
            }

            // Part 1
            int highest = walkMaze(maze, start);
            System.out.println("Highest in maze = " + highest);

            // Part 2
            int inside = countInside(maze);
            System.out.println("Inside = " + inside);
        }

    }


    public static int walkMaze(char[][] maze, MazePoint start) {
        SortedSet<MazePoint> todo = new TreeSet<>();
        processed.clear();
        processed.put(start.x + "," + start.y, 0);

        // Add the start connection points
        if (start.y > 0) {
            char above = maze[start.y-1][start.x];
            if (above == '|' || above == '7' || above == 'F') {
                MazePoint m = new MazePoint(start.x, start.y-1, 1);
                todo.add(m);
                processed.put(start.x + "," + (start.y-1), 1);
            }
        }
        if (start.y < maze.length - 1) {
            char below = maze[start.y+1][start.x];
            if (below == '|' || below == 'L' || below == 'J') {
                MazePoint m = new MazePoint(start.x, start.y+1, 1);
                todo.add(m);
                processed.put(start.x + "," + (start.y+1), 1);
            }
        }
        if (start.x > 0) {
            char left = maze[start.y][start.x-1];
            if (left == '-' || left == 'F' || left == 'L') {
                MazePoint m = new MazePoint(start.x-1, start.y, 1);
                todo.add(m);
                processed.put((start.x-1) + "," + start.y, 1);
            }
        }
        if (start.x < maze[0].length - 1) {
            char right = maze[start.y][start.x+1];
            if (right == '-' || right == 'J' || right == '7') {
                MazePoint m = new MazePoint(start.x+1, start.y, 1);
                todo.add(m);
                processed.put((start.x+1) + "," + start.y, 1);
            }
        }

        // Go through the list, always starting at the nearest point to the start.
        // Check to see if the ordinals are connected and if so add them to the todo
        int highest = 0;
        while (!todo.isEmpty()) {

            Iterator<MazePoint> iterator = todo.iterator();
            MazePoint p = iterator.next();
            iterator.remove();

            char c = maze[p.y][p.x];

            // Should add above?
            if (c == '|' || c == 'L' || c == 'J') {
                if (p.y > 0 && !processed.containsKey(p.x + "," + (p.y-1))) {
                    todo.add(new MazePoint(p.x, p.y-1, p.distance+1));
                    processed.put(p.x + "," + (p.y-1), p.distance+1);
                    if (p.distance+1 > highest)
                        highest++;
                }
            }

            // Should add below?
            if (c == '|' || c == '7' || c == 'F') {
                if (p.y < maze.length - 1 && !processed.containsKey(p.x + "," + (p.y+1))) {
                    todo.add(new MazePoint(p.x, p.y+1, p.distance + 1));
                    processed.put(p.x + "," + (p.y+1), p.distance + 1);
                    if (p.distance + 1 > highest)
                        highest++;
                }
            }

            // Should add left?
            if (c == '-' || c == 'J' || c == '7') {
                if (p.x > 0 && !processed.containsKey((p.x-1) + "," + p.y)) {
                    todo.add(new MazePoint(p.x-1, p.y, p.distance+1));
                    processed.put((p.x-1) + "," + p.y, p.distance+1);
                    if (p.distance+1 > highest)
                        highest++;
                }
            }

            // Should add right?
            if (c == '-' || c == 'L' || c == 'F') {
                if (p.x < maze[0].length - 1 && !processed.containsKey((p.x+1) + "," + p.y)) {
                    todo.add(new MazePoint(p.x+1, p.y, p.distance+1));
                    processed.put((p.x+1) + "," + p.y, p.distance+1);
                    if (p.distance+1 > highest)
                        highest++;
                }
            }
        }

        for (int y=0; y<maze.length; y++) {
            for (int x=0; x<maze[y].length; x++) {
                String key = x + "," + y;
                if (processed.containsKey(key)) {
                    System.out.print('#');
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
        return highest;
    }



    public static int countInside(char[][] maze) {
        // Probablty some optimisation here; there are some points that
        // are obviously outside because they are adjacent to other points
        // that have already been determined to be outside... so we could
        // likely bypass a lot of this checking.
        int inside = 0;
        for (int y=0; y<maze.length; y++) {
            for (int x = 0; x < maze[y].length; x++) {
                if (isInside(x, y, maze)) {
                    inside++;
                }
            }
        }
        return inside;
    }

    private static boolean isInside(int x, int y, char[][] maze) {
        // If on the loop
        String key = x + "," + y;
        if (processed.containsKey(key)) {
            return false;
        }

        // Build a string of the lines we cross, starting at x,y and moving downwards.
        StringBuilder buf = new StringBuilder();
        for (int dy=1; dy+y<maze.length; dy++) {
            key = x + "," + (y+dy);

            // Originally missed this step and got a number too high because I was erroneously
            // counting boundaries that were not on the main loop. I got stuck for a while but
            // the realisation came to me while (I kid you not) I was on the toilet! Looking back
            // at the problem there is an example, but I missed writing the test case for it.
            if (!processed.containsKey(key))
                continue;

            char c = maze[y+dy][x];

            if (c == '-' || c == 'F' || c == 'L' || c == '7' || c == 'J')
                buf.append(c);
        }

        // Count the boundaries. A boundary is "-" or "FJ" or "7L"
        // but not "FL" or "7J".
        long boundaries = boundaryPattern.matcher(buf.toString()).results().count();

        // Inside if we cross an odd number of boundaries
        return boundaries % 2 == 1;
    }

}
