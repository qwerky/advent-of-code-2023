package day5;

public class SeedRange {
    long start;
    long range;

    public SeedRange(long start, long range) {
        this.start = start;
        this.range = range;
    }

    @Override
    public String toString() {
        return start + " " + range;
    }
}
