package day7;

import java.util.HashMap;
import java.util.Map;

public class JokerHand extends Hand {

    public JokerHand(String line) {
        super(line.replaceAll("J", "0"));
    }

    protected int parseRank(char[] cards) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c: cards)
            map.merge(c, 1, Integer::sum);

        if (!map.containsKey('0'))
            return super.parseRank(cards);

        int jokers = map.get('0');
        int faces = map.size();

        switch (jokers) {
            case 1:
                // Options are;
                // JABCD
                if (faces == 5)
                    return PAIR;
                // JAABC
                if (faces == 4)
                    return THREE;
                // JAAAA
                if (faces == 2)
                    return FIVE;
                // JAAAB
                // JAABB
                assert faces == 3 : "A joker and two other faces" + new String(cards);
                if (map.containsValue(3))
                    return FOUR;
                else
                    return FULL_HOUSE;

            case 2:
                // Options are;
                // JJABC
                if (faces == 4)
                    return THREE;
                // JJAAB
                if (faces == 3)
                    return FOUR;
                // JJAAA
                if (faces == 2)
                    return FIVE;

            case 3:
                // Options are;
                // JJJAA
                if (faces == 2)
                    return FIVE;
                // JJJAB
                assert faces == 3: "Three jokers and two other faces " + new String(cards);
                return FOUR;

            case 4:
            case 5:
                return FIVE;
            default:
                throw new RuntimeException("Error " + map.size() + " different cards in hand " + new String(cards));
        }

    }
}
