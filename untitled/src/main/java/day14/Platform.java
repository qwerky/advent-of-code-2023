package day14;

import java.util.*;

public class Platform {

    char[][] data;
    int width;
    int height;

    // When shuffling all the rocks we only need to make
    // one pass through a row/col if we keep track of the
    // free spaces as we process it.
    Deque<Integer> free = new LinkedList<>();

    public Platform(List<String> lines) {
        data = new char[lines.size()][];
        width = lines.get(0).length();
        height = lines.size();
        for (int i=0; i<lines.size(); i++) {
            data[i] = lines.get(i).toCharArray();
        }
    }

    public void tiltNorth() {
        for (int x=0; x<width; x++) {
            free.clear();
            for (int y=0; y<height; y++) {
                rollV(x, y);
            }
        }
    }

    public void tiltSouth() {
        for (int x=0; x<width; x++) {
            free.clear();
            for (int y=height-1; y>-1; y--) {
                rollV(x, y);
            }
        }
    }

    public void tiltWest() {
        for (int y=0; y<height; y++) {
            free.clear();
            for (int x=0; x<width; x++) {
                rollH(x, y);
            }
        }
    }

    public void tiltEast() {
        for (int y=0; y<height; y++) {
            free.clear();
            for (int x=width-1; x>-1; x--) {
                rollH(x, y);
            }
        }
    }

    private void rollV(int x, int y) {
        if (data[y][x] == '.') {
            free.add(y);
        } else if (data[y][x] == '#') {
            free.clear();
        } else if (!free.isEmpty()) {
            data[free.pop()][x] = 'O';
            free.add(y);
            data[y][x] = '.';
        }
    }

    private void rollH(int x, int y) {
        if (data[y][x] == '.') {
            free.add(x);
        } else if (data[y][x] == '#') {
            free.clear();
        } else if (!free.isEmpty()) {
            data[y][free.pop()] = 'O';
            free.add(x);
            data[y][x] = '.';
        }
    }

    public int spin(int count) {
        // We probably don't need to tilt all the times given. Its a lot, so
        // it's probably not even feasible. If we can find a repeated pattern
        // of states we can shortcut.
        Map<String, Integer> states = new HashMap<>();
        Map<Integer, Integer> repeatSequence = new HashMap<>();
        StringBuilder buf = new StringBuilder();
        for (int i=1; i<count; i++) {

            tiltNorth();
            tiltWest();
            tiltSouth();
            tiltEast();

            buf.setLength(0);
            for (char[] row : data) {
                buf.append(new String(row));
            }
            String state = buf.toString();
            if (states.containsKey(state)) {
                System.out.println("Saw this state after " + states.get(state) + " and now at " + i);
                if (repeatSequence.containsKey(states.get(state))) {
                    System.out.println("\tSequence repeats");
                    int s = repeatSequence.keySet().stream().mapToInt(Integer::intValue).min().getAsInt();
                    int p = repeatSequence.size();
                    int sameAs = s + ((count - s) % p);
                    System.out.println("Value for " + count + " is same as value for " + sameAs);
                    return repeatSequence.get(sameAs);
                }
                repeatSequence.put(states.get(state), getLoad());
            } else {
                states.put(state, i);
            }

        }
        //Expect to never get here for large valus of count
        return getLoad();
    }

    public int getLoad() {
        int load = 0;
        for (int y=0; y<height; y++) {
            int moment = height - y;
            long rockCount = new String(data[y]).chars().filter(c -> c == 'O').count();
            load += (moment*rockCount);
        }
        return load;
    }

    private void render() {

        int oCount = 0;
        for (char[] row : data) {
            for (char c : row) {
                if (c == 'O') oCount++;
            }
        }
        System.out.println("O count is " + oCount);

        for (char[] line : data) {
            System.out.println(new String(line));
        }
        System.out.println();
    }

}
