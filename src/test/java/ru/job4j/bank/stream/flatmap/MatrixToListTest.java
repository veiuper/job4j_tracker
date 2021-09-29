package ru.job4j.bank.stream.flatmap;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MatrixToListTest {
    @Test
    public void convertWhenFullEmptyMatrix() {
        List<Integer> actual = MatrixToList.convert(new Integer[][]{});
        List<Integer> matcher = List.of();
        assertThat(actual, is(matcher));
    }

    @Test
    public void convertWhenEmptyInnerElements() {
        List<Integer> actual = MatrixToList.convert(
                new Integer[][]{
                        new Integer[]{},
                        new Integer[]{}
                }
        );
        List<Integer> matcher = List.of();
        assertThat(actual, is(matcher));
    }

    @Test
    public void convert() {
        List<Integer> actual = MatrixToList.convert(
                new Integer[][]{
                        new Integer[]{-1, 0, 1},
                        new Integer[]{-1, 0, 1},
                        new Integer[]{-2, 2}
                }
        );
        List<Integer> matcher = List.of(-1, 0, 1, -1, 0, 1, -2, 2);
        assertThat(actual, is(matcher));
    }
}