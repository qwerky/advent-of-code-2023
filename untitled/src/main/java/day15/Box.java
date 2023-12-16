package day15;

import java.util.ArrayList;
import java.util.List;

public class Box {

    List<Lens> contents = new ArrayList<>();

    public void remove(String label) {
        contents.removeIf(box -> box.label.equals(label));
    }

    public void replace(Lens replacement) {
        for (Lens lens : contents) {
            if (lens.label.equals(replacement.label)) {
                lens.fl = replacement.fl;
                return;
            }
        }
        contents.add(replacement);
    }

    public int power(int position) {
        int boxPower = 0;
        for (int i=0; i<contents.size(); i++) {
            boxPower += ((1+position) * (1+i) * contents.get(i).fl);
        }
        return boxPower;
    }
}
