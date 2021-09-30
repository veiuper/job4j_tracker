package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ConvertMatrix2ListTest {

    @Test
    public void when2on2ArrayThenList4() {
        ConvertMatrix2List converter = new ConvertMatrix2List();
        int[][] in = {
                {1, 2},
                {3, 4}
        };
        List<Integer> actual = converter.toList(in);
        List<Integer> expected = List.of(1, 2, 3, 4);
        assertThat(actual, is(expected));
    }

    @Test
    public void whenEmptyArrayThenEmptyList() {
        ConvertMatrix2List converter = new ConvertMatrix2List();
        int[][] in = {};
        List<Integer> actual = converter.toList(in);
        List<Integer> expected = new ArrayList<>();
        assertThat(actual, is(expected));
    }
}