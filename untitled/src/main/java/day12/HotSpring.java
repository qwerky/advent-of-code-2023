package day12;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static aoc.Util.fillArray;

public class HotSpring {

    String arrangement;
    int[] groups;
    Map<Key, Long> knownValues = new HashMap<>();

    static class Key {
        int a, b, c;
        Key(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public boolean equals(Object other) {
            if (other instanceof Key o) {
                return o.a == this.a && o.b == this.b && o.c == this.c;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b, c);
        }

        @Override
        public String toString() {
            return a + "," + b + "," + c;
        }

    }

    public HotSpring(String line) {
        String[] parts = line.split(" ");
        this.arrangement = parts[0];
        this.groups = Arrays.stream(parts[1].split(",")).mapToInt(Integer::parseInt).toArray();
    }

    public HotSpring(String line, int bigness) {
        String[] parts = line.split(" ");
        this.arrangement = String.join("?", fillArray(parts[0], bigness));
        this.groups = Arrays.stream(String.join(",", fillArray(parts[1], bigness)).split(","))
                .mapToInt(Integer::parseInt).toArray();
    }

    public long getArrangements() {
        int pos = 0;
        int group = 0;
        int posInGroup = 0;

        return getArrangements(pos, group, posInGroup);
    }

    private long getArrangements(int pos, int group, int posInGroup) {
        Key key = new Key(pos, group, posInGroup);
        Long result = knownValues.get(key);
        if (result != null)
            return result;

        if (pos == arrangement.length()) {
            if (group == groups.length && posInGroup == 0) {
                knownValues.put(key,  1L);
                return 1;
            } else if (group == groups.length - 1 && posInGroup == groups[group]) {
                knownValues.put(key, 1L);
                return 1;
            } else {
                knownValues.put(key, 0L);
                return 0;
            }
        }

        long count = 0;

        char lookingAt = arrangement.charAt(pos);
        if (lookingAt == '#') {
            count += getArrangements(pos+1, group, posInGroup+1);
        } else if (lookingAt == '.') {
            if (posInGroup == 0)
                count += getArrangements(pos + 1, group, posInGroup);
            else if (group < groups.length && posInGroup == groups[group])
                count += getArrangements(pos + 1, group+1, 0);
        } else if (lookingAt == '?') {
            if (posInGroup == 0)
                count += getArrangements(pos + 1, group, posInGroup);
            else if (group < groups.length && posInGroup == groups[group])
                count += getArrangements(pos + 1, group+1, 0);

            count += getArrangements(pos+1, group, posInGroup+1);
        }

        knownValues.put(key, count);
        return count;
    }
}
