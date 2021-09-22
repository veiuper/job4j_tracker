package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SortItemByNameTest {

    @Test
    public void compare() {
        Item[] expected = {
                new Item("name 1"),
                new Item("name 2"),
                new Item("name 3")
        };
        Item[] items = {
                expected[2],
                expected[0],
                expected[1]
        };
        Arrays.sort(items, new SortItemByName());
        assertThat(items, is(expected));
    }
}