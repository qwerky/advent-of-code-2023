package day8;


import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


public class Day8Test {

    @Test
    public void testRL() {
        Node aaa = new Node("AAA");
        Node bbb = new Node("BBB");
        Node ccc = new Node("CCC");
        Node ddd = new Node("DDD");
        Node eee = new Node("EEE");
        Node ggg = new Node("GGG");
        Node zzz = new Node("ZZZ");

        aaa.left = bbb;
        aaa.right = ccc;

        bbb.left = ddd;
        bbb.right = eee;

        ccc.left = zzz;
        ccc.right = ggg;

        ddd.left = ddd;
        ddd.right = ddd;

        eee.left = eee;
        eee.right = eee;

        ggg.left = ggg;
        ggg.right = ggg;

        zzz.left = zzz;
        zzz.right = zzz;

        Assert.assertEquals("2 Steps", 2, Day8.navigate("RL", aaa));
    }

    @Test
    public void testLLR() {
        Node aaa = new Node("AAA");
        Node bbb = new Node("BBB");
        Node zzz = new Node("ZZZ");

        aaa.left = bbb;
        aaa.right = bbb;

        bbb.left = aaa;
        bbb.right = zzz;

        zzz.left = zzz;
        zzz.right = zzz;

        Assert.assertEquals("6 Steps", 6, Day8.navigate("LLR", aaa));
    }

    @Test
    public void testMulti() {
        Node aaa = new Node("AAA");
        Node aab = new Node("AAB");
        Node aaz = new Node("AAZ");
        Node bba = new Node("BBA");
        Node bbb = new Node("BBB");
        Node bbc = new Node("BBC");
        Node bbz = new Node("BBZ");

        aaa.left = aab;
        aab.right = aaz;
        aaz.left = aab;
        bba.left = bbb;
        bbb.left = bbc;
        bbb.right = bbc;
        bbc.left = bbz;
        bbc.right = bbz;
        bbz.left = bbb;
        bbz.right = bbb;

        Map<String,Node> map = new HashMap<>();
        map.put("AAA", aaa);
        map.put("AAB", aab);
        map.put("AAZ", aaz);
        map.put("BBA", bba);
        map.put("BBB", bbb);
        map.put("BBC", bbc);
        map.put("BBZ", bbz);

        Assert.assertEquals("6 Steps", 6, Day8.multiNavigate("LR", map));
    }
}
