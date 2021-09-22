package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SortItemByDateReverseTest {

    @Test
    public void compare() throws InterruptedException {
        Item[] expected = new Item[3];
        expected[2] = new Item("name 1");
        Thread.sleep(1);
        expected[1] = new Item("name 2");
        Thread.sleep(1);
        expected[0] = new Item("name 3");
        Thread.sleep(1);
        Item[] items = {
                expected[2],
                expected[0],
                expected[1]
        };
        Arrays.sort(items, new SortItemByDateReverse());
        assertThat(items, is(expected));
    }
}