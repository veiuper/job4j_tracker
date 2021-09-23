package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class JobDescByPriorityTest {

    @Test
    public void compare() {
        Job[] matcher = {
                new Job("", 2),
                new Job("", 1),
                new Job("", 0)
        };
        Job[] actual = {
                matcher[2],
                matcher[1],
                matcher[0]
        };
        Arrays.sort(actual, new JobDescByPriority());
        assertThat(actual, is(matcher));
    }

    @Test
    public void testCompare() {
    }
}