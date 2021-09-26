package ru.job4j.function;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class FunctionValuesInRangeTest {
    @Test
    public void whenLinear() {
        List<Double> expected = List.of(4.0, 2.0, 0.0);
        List<Double> actual = FunctionValuesInRange.diapason(-1, 2, x -> -2 * x + 2);
        assertThat(actual, is(expected));
    }

    @Test
    public void whenQuadratic() {
        List<Double> expected = List.of(-6.0, -2.0, -2.0);
        List<Double> actual = FunctionValuesInRange.diapason(-1, 2, x -> -2 * x * x + 2 * x - 2);
        assertThat(actual, is(expected));
    }

    @Test
    public void whenExponential() {
        List<Double> expected = List.of(0.5, 1.0, 2.0);
        List<Double> actual = FunctionValuesInRange.diapason(-1, 2, x -> Math.pow(2, x));
        assertThat(actual, is(expected));
    }
}