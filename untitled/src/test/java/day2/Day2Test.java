package day2;

import org.junit.Assert;
import org.junit.Test;

public class Day2Test {

    @Test
    public void testGame1() {
        Assert.assertTrue("Game 1", Day2.isPossible("3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green"));
   }
    @Test
    public void testGame2() {
        Assert.assertTrue("Game 2", Day2.isPossible("1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue"));
    }

    @Test
    public void testGame3() {
        Assert.assertFalse("Game 3", Day2.isPossible("8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red"));
    }

    @Test
    public void testGame4() {
        Assert.assertFalse("Game 4", Day2.isPossible("1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red"));
    }

    @Test
    public void testGame5() {
        Assert.assertTrue("Game 5", Day2.isPossible("6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green"));
    }

    @Test
    public void testPower1() {
        Assert.assertEquals("Game 1", 48, Day2.gamePower("3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green"));
    }

    @Test
    public void testPower2() {
        Assert.assertEquals("Game 2", 12, Day2.gamePower("1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue"));
    }

    @Test
    public void testPower3() {
        Assert.assertEquals("Game 3", 1560, Day2.gamePower("8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red"));
    }

    @Test
    public void testPower4() {
        Assert.assertEquals("Game 4", 630, Day2.gamePower("1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red"));
    }

    @Test
    public void testPower5() {
        Assert.assertEquals("Game 5", 36, Day2.gamePower("6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green"));
    }
}
