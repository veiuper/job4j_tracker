package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ConvertList2ArrayTest {

    @Test
    public void when7ElementsToThen9() {
        int[][] actual = ConvertList2Array.toArray(Arrays.asList(1, 2, 3, 4, 5, 6, 7), 3);
        int[][] expected = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 0},
        };
        assertThat(expected, is(actual));
    }
}