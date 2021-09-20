package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class FillSearchTest {

    @Test
    public void extractNumber() {
        List<Task> list = Arrays.asList(
                new Task("1", "First desc"),
                new Task("2", "Second desc"),
                new Task("1", "First desc")
        );
        Set<String> actual = FillSearch.extractNumber(list);
        Set<String> expected = new HashSet<>(Arrays.asList("1", "2"));
        assertThat(actual, is(expected));
    }
}