package day1;

import org.junit.Assert;
import org.junit.Test;

public class Day1Test {

    @Test
    public void testCalibration() {
        Assert.assertEquals("1abc2", Day1.getCalibrationValue("1abc2"), 12);
        Assert.assertEquals("pqr3stu8vwx", Day1.getCalibrationValue("pqr3stu8vwx"), 38);
        Assert.assertEquals("a1b2c3d4e5f", Day1.getCalibrationValue("a1b2c3d4e5f"), 15);
        Assert.assertEquals("treb7uchet", Day1.getCalibrationValue("treb7uchet"), 77);
    }


    @Test
    public void testDigitCalibration() {
        Assert.assertEquals("two1nine", Day1.getDigitCalibrationValue("two1nine"), 29);
        Assert.assertEquals("eightwothree", Day1.getDigitCalibrationValue("eightwothree"), 83);
        Assert.assertEquals("abcone2threexyz", Day1.getDigitCalibrationValue("abcone2threexyz"), 13);
        Assert.assertEquals("xtwone3four", Day1.getDigitCalibrationValue("xtwone3four"), 24);
        Assert.assertEquals("4nineeightseven2", Day1.getDigitCalibrationValue("4nineeightseven2"), 42);
        Assert.assertEquals("zoneight234", Day1.getDigitCalibrationValue("zoneight234"), 14);
        Assert.assertEquals("7pqrstsixteen", Day1.getDigitCalibrationValue("7pqrstsixteen"), 76);
    }
}
