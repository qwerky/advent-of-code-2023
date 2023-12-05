package day5;

import java.util.Comparator;

public class AlmanacEntry {

    long dest;
    long source;
    long range;
    long modifier;

    public AlmanacEntry(String line) {
        String[] parts = line.split(" ");
        dest = Long.parseLong(parts[0]);
        source = Long.parseLong(parts[1]);
        range = Long.parseLong(parts[2]);
        modifier = dest - source;
    }

    public static Comparator<AlmanacEntry> DEST = new Comparator<AlmanacEntry>() {
        @Override
        public int compare(AlmanacEntry entry1, AlmanacEntry entry2) {
            return Long.signum(entry1.dest - entry2.dest);
        }
    };

    public static Comparator<AlmanacEntry> SRC = new Comparator<AlmanacEntry>() {
        @Override
        public int compare(AlmanacEntry entry1, AlmanacEntry entry2) {
            return Long.signum(entry1.source - entry2.source);
        }
    };

    @Override
    public String toString() {
        return dest + " " + source + " " + range + " mod: " + modifier;
    }
}
