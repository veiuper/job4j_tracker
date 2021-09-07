package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

public class MaxTest {

    @Test
    public void whenMax10To2Then10() {
        int in1 = 10;
        int in2 = -2;
        int expected = 10;
        int actual = Max.max(in1, in2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void whenMaxN2ToN15ThenN2() {
        int in1 = -15;
        int in2 = -2;
        int expected = -2;
        int actual = Max.max(in1, in2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void whenMax0To0Then0() {
        int in1 = 0;
        int in2 = 0;
        int expected = 0;
        int actual = Max.max(in1, in2);
        Assert.assertEquals(expected, actual);
    }
}