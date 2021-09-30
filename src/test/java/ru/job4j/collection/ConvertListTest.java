package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ConvertListTest {

    @Test
    public void whenTwoList() {
        List<int[]> in = new ArrayList<>();
        in.add(new int[]{1});
        in.add(new int[]{2, 3});
        List<Integer> actual = ConvertList.convert(in);
        List<Integer> expected = List.of(1, 2, 3);
        assertThat(actual, is(expected));
    }

    @Test
    public void whenEmptyListArraysThenEmptyList() {
        List<int[]> in = new ArrayList<>();
        in.add(new int[]{});
        in.add(new int[]{});
        List<Integer> actual = ConvertList.convert(in);
        List<Integer> expected = new ArrayList<>();
        assertThat(actual, is(expected));
    }
}