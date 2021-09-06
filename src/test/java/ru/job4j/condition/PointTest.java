package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;

public class PointTest {

    @Test
    public void distance3d() {
        Point a = new Point(0, 0, 0);
        Point b = new Point(0, 2, 5);
        double actual = a.distance3d(b);
        assertThat(actual, closeTo(5.385, 0.001));
    }
}