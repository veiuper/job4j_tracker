package ru.job4j.collection;

import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class StringCompareTest {

    @Test
    public void compare() {
        Comparator<String> comparator = new StringCompare();
        assertThat(comparator.compare("11", "11"), is(0));
        assertThat(comparator.compare("12", "11"), greaterThan(0));
        assertThat(comparator.compare("21", "11"), greaterThan(0));
        assertThat(comparator.compare("11", "12"), lessThan(0));
        assertThat(comparator.compare("11", "21"), lessThan(0));
        assertThat(comparator.compare("11", "111"), lessThan(0));
        assertThat(comparator.compare("12", "111"), greaterThan(0));
        assertThat(comparator.compare("21", "111"), greaterThan(0));
        assertThat(comparator.compare("11", "121"), lessThan(0));
        assertThat(comparator.compare("11", "211"), lessThan(0));
        assertThat(comparator.compare("111", "11"), greaterThan(0));
        assertThat(comparator.compare("121", "11"), greaterThan(0));
        assertThat(comparator.compare("211", "11"), greaterThan(0));
        assertThat(comparator.compare("111", "12"), lessThan(0));
        assertThat(comparator.compare("111", "21"), lessThan(0));
    }
}