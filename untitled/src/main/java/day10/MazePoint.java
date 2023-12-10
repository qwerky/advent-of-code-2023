package day10;

public class MazePoint implements Comparable<MazePoint> {

    int x;
    int y;
    int distance;

    MazePoint(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }

    @Override
    public int compareTo(MazePoint other) {
        if (this.distance != other.distance) {
            return this.distance - other.distance;
        }
        if (this.x != other.x) {
            return this.x - other.x;
        }
        return this.y - other.y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ") " + distance;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof MazePoint other) {
            return x == other.x && y == other.y;
        }
        return false;
    }
}
