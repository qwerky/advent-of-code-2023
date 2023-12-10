package day10;

import org.junit.Assert;
import org.junit.Test;

public class Day10Test {

    @Test
    public void testMaze1() {
        char[][] maze = new char[5][];
        maze[0] = ".....".toCharArray();
        maze[1] = ".S-7.".toCharArray();
        maze[2] = ".|.|.".toCharArray();
        maze[3] = ".L-J.".toCharArray();
        maze[4] = ".....".toCharArray();

        MazePoint start = new MazePoint(1, 1, 0);
        Assert.assertEquals("Distance is 4", 4, Day10.walkMaze(maze, start));
    }

    @Test
    public void testMaze1WithBits() {
        char[][] maze = new char[5][];
        maze[0] = "-L|F7".toCharArray();
        maze[1] = "7S-7|".toCharArray();
        maze[2] = "L|7||".toCharArray();
        maze[3] = "-L-J|".toCharArray();
        maze[4] = "L|-JF".toCharArray();

        MazePoint start = new MazePoint(1, 1, 0);
        Assert.assertEquals("Distance is 4", 4, Day10.walkMaze(maze, start));
    }

    @Test
    public void testMaze2() {
        char[][] maze = new char[5][];
        maze[0] = "..F7.".toCharArray();
        maze[1] = ".FJ|.".toCharArray();
        maze[2] = "SJ.L7".toCharArray();
        maze[3] = "|F--J".toCharArray();
        maze[4] = "LJ...".toCharArray();

        MazePoint start = new MazePoint(0, 2, 0);
        Assert.assertEquals("Distance is 8", 8, Day10.walkMaze(maze, start));
    }

    @Test
    public void testInside1() {
        char[][] maze = new char[9][];
        maze[0] = "...........".toCharArray();
        maze[1] = ".S-------7.".toCharArray();
        maze[2] = ".|F-----7|.".toCharArray();
        maze[3] = ".||.....||.".toCharArray();
        maze[4] = ".||.....||.".toCharArray();
        maze[5] = ".|L-7.F-J|.".toCharArray();
        maze[6] = ".|..|.|..|.".toCharArray();
        maze[7] = ".L--J.L--J.".toCharArray();
        maze[8] = "...........".toCharArray();

        MazePoint start = new MazePoint(1, 1, 0);
        Day10.walkMaze(maze, start);
        Assert.assertEquals("Enclosed", 4, Day10.countInside(maze));
    }

    @Test
    public void testInside2() {
        char[][] maze = new char[9][];
        maze[0] = "..........".toCharArray();
        maze[1] = ".S------7.".toCharArray();
        maze[2] = ".|F----7|.".toCharArray();
        maze[3] = ".||....||.".toCharArray();
        maze[4] = ".||....||.".toCharArray();
        maze[5] = ".|L-7F-J|.".toCharArray();
        maze[6] = ".|..||..|.".toCharArray();
        maze[7] = ".L--JL--J.".toCharArray();
        maze[8] = "..........".toCharArray();

        MazePoint start = new MazePoint(1, 1, 0);
        Day10.walkMaze(maze, start);
        Assert.assertEquals("Enclosed", 4, Day10.countInside(maze));
    }

    @Test
    public void testInside3() {
        char[][] maze = new char[10][];
        maze[0] = ".F----7F7F7F7F-7....".toCharArray();
        maze[1] = ".|F--7||||||||FJ....".toCharArray();
        maze[2] = ".||.FJ||||||||L7....".toCharArray();
        maze[3] = "FJL7L7LJLJ||LJ.L-7..".toCharArray();
        maze[4] = "L--J.L7...LJS7F-7L7.".toCharArray();
        maze[5] = "....F-J..F7FJ|L7L7L7".toCharArray();
        maze[6] = "....L7.F7||L7|.L7L7|".toCharArray();
        maze[7] = ".....|FJLJ|FJ|F7|.LJ".toCharArray();
        maze[8] = "....FJL-7.||.||||...".toCharArray();
        maze[9] = "....L---J.LJ.LJLJ...".toCharArray();

        MazePoint start = new MazePoint(12, 4, 0);
        Day10.walkMaze(maze, start);
        Assert.assertEquals("Eclosed", 8, Day10.countInside(maze));
    }
}
