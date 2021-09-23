package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class JobAscByNameTest {

    @Test
    public void compare() {
        Job[] matcher = {
                new Job("name 1", 0),
                new Job("name 2", 0),
                new Job("name 3", 0)
        };
        Job[] actual = {
                matcher[2],
                matcher[1],
                matcher[0]
        };
        Arrays.sort(actual, new JobAscByName());
        assertThat(actual, is(matcher));
    }
}