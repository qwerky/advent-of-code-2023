package day14;

import java.util.List;

public class Platform {

    char[][] data;
    int width;
    int height;

    public Platform(List<String> lines) {
        data = new char[lines.size()][];
        width = lines.get(0).length();
        height = lines.size();
        for (int i=0; i<lines.size(); i++) {
            data[i] = lines.get(i).toCharArray();
        }
    }

    public void tilt() {
        for (int x=0; x<width; x++) {
            for (int y=1; y<height; y++) {
                // If its a round rock
                if (data[y][x] == 'O') {
                    int n = y;
                    // Move north while the space above is free
                    while (n>0 && data[n-1][x] == '.')
                        n--;
                    // If we moved then swap the data points
                    if (n != y) {
                        data[y][x] = '.';
                        data[n][x] = 'O';
                    }
                }
            }
        }
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
}
