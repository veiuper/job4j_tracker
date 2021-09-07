package ru.job4j.oop;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class TriangleTest {

    @Test
    public void whenExist() {
        Point a = new Point(0, 0);
        Point b = new Point(4, 0);
        Point c = new Point(0, 4);
        double actual = new Triangle(a, b, c).area();
        assertThat(actual, closeTo(8, 0.001));
    }

    @Test
    public void whenNotExist() {
        Point a = new Point(1, 1);
        Point b = new Point(2, 2);
        Point c = new Point(3, 3);
        double actual = new Triangle(a, b, c).area();
        assertThat(actual, not(equalTo(-1)));
    }
}