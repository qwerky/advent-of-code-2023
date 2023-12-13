package day13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Image {

    String[] data;
    boolean smudge;

    public Image(List<String> lines) {
        data = new String[lines.size()];
        for (int i=0; i<lines.size(); i++) {
            data[i] = lines.get(i);
        }
    }

    public long getScore() {
        int vertical = getVertical();
        if (vertical != 0) {
            return vertical;
        }

        int horiz = getHorizontal();
        if (horiz != 0) {
            return 100L * horiz;
        }
        throw new RuntimeException("Cannot find line of syummetry");
    }

    private int getHorizontal() {
        List<String> above = new ArrayList<>();
        above.add(data[0]);
        List<String> below = new ArrayList<>(Arrays.asList(data).subList(1, data.length));

        while (!below.isEmpty()) {
            if (isSymmetry(above, below)) {
                return above.size();
            }
            above.add(0, below.remove(0));
        }

        return 0;
    }


    private int getVertical() {
        int width = data[0].length();
        int height = data.length;

        List<String> left = new ArrayList<>();
        char[] column = new char[height];
        for (int row=0; row<height; row++) {
            column[row] = data[row].charAt(0);
        }
        left.add(new String(column));

        List<String> right = new ArrayList<>();
        for (int col = 1; col<width; col++) {
            for (int row=0; row<height; row++) {
                column[row] = data[row].charAt(col);
            }
            right.add(new String(column));
        }

        while (!right.isEmpty()) {
            if (isSymmetry(left, right)) {
                return left.size();
            }
            left.add(0, right.remove(0));
        }
        return 0;
    }

    private boolean isSymmetry(List<String> a, List<String> b) {
        int min = Math.min(a.size(), b.size());

        int wrong = 0;
        for (int i=0; i<min; i++) {
            wrong += getWrongCharCount(a.get(i), b.get(i));
        }
        if (smudge) {
            return wrong == 1;
        } else {
            return wrong == 0;
        }
    }

    private int getWrongCharCount(String a, String b) {
        int wrong = 0;
        for (int pos=0; pos<a.length(); pos++) {
            if (a.charAt(pos) != b.charAt(pos)) {
                wrong++;

                // If we get above the acceptable level of smudge we can probably
                // optimise by returning early; no need to check more.
            }
        }
        return wrong;
    }
}
