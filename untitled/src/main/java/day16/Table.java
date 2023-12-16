package day16;

import java.util.List;

public class Table {

    static int R = 1;
    static int L = 2;
    static int U = 4;
    static int D = 8;

    char[][] grid;
    int [][] path;

    int width;
    int height;

    public Table(List<String> lines) {
        width = lines.get(0).length();
        height = lines.size();
        grid = new char[height][];
        path = new int[height][];
        for (int i=0; i<height; i++) {
            grid[i] = lines.get(i).toCharArray();
            path[i] = new int[width];
        }
    }

    public void reset() {
        path = new int[height][];
        for (int i=0; i<height; i++) {
            path[i] = new int[width];
        }
    }


    public void energise(int x, int y, int d) {

        // If we've been this way before, we don't need to carry on
        if ((path[y][x] & d) == d) {
            return;
        }

        // Set the path bit to represent the direction
        path[y][x] = path[y][x] | d;

        char tile = grid[y][x];

        // Energise down?
        if (y < height-1) {
            if ((tile == '.' && d == D) ||
                (tile == '\\' && d == R) ||
                (tile == '|' && (d == R || d == L || d == D)) ||
                (tile == '/' && d == L)) {
                energise(x, y + 1, D);
            }
        }

        // Energise up?
        if (y > 0) {
            if ((tile == '.' && d == U) ||
                (tile == '\\' && d == L) ||
                (tile == '|' && (d == R || d == L || d == U)) ||
                (tile == '/' && d == R)) {
                energise(x, y-1, U);
            }
        }

        // Energise left?
        if (x > 0) {
            if ((tile == '.' && d == L) ||
                (tile == '\\' && d == U) ||
                (tile == '-' && (d == U || d == D || d == L)) ||
                (tile == '/' && d == D)) {
                energise(x-1, y, L);
            }
        }

        // Energise right?
        if (x < width-1) {
            if ((tile == '.' && d == R) ||
                (tile == '\\' && d == D) ||
                (tile == '-' && (d == U || d == D || d == R)) ||
                (tile == '/' && d == U)) {
                energise(x+1, y, R);
            }
        }

    }

    public int countEngergisedTiles() {
        int count = 0;
        for (int y=0; y<height; y++) {
            for (int x=0; x<width; x++) {
                if (path[y][x] > 0) count++;
            }
        }
        return count;
    }

    public void printTiles() {
        for (int i = 0; i < width; i++) {
            System.out.println(new String(grid[i]));
        }
        System.out.println();
    }

    public void printPath() {
        for (int y = 0; y < height; y++) {
            for (int x=0; x<width; x++) {
                if (path[y][x] == 0) {
                    System.out.print(".");
                } else if (path[y][x] == U) {
                    System.out.print("^");
                } else if (path[y][x] == D) {
                    System.out.print("v");
                } else if (path[y][x] == L) {
                    System.out.print("<");
                } else if (path[y][x] == R) {
                    System.out.print(">");
                } else {
                    System.out.print("n");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

}
