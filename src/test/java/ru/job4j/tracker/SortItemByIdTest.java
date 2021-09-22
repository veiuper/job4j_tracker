package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SortItemByIdTest {

    @Test
    public void compare() {
        Item[] expected = {
                new Item(1, "name 1"),
                new Item(2, "name 2"),
                new Item(3, "name 3")
        };
        Item[] items = {
                expected[2],
                expected[0],
                expected[1]
        };
        Arrays.sort(items, new SortItemById());
        assertThat(items, is(expected));
    }
}