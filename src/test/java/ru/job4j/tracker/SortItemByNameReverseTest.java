package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SortItemByNameReverseTest {

    @Test
    public void compare() {
        Item[] expected = {
                new Item("name 3"),
                new Item("name 2"),
                new Item("name 1")
        };
        Item[] items = {
                expected[2],
                expected[0],
                expected[1]
        };
        Arrays.sort(items, new SortItemByNameReverse());
        assertThat(items, is(expected));
    }
}