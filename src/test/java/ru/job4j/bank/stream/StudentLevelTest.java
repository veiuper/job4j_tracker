package ru.job4j.bank.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StudentLevelTest {
    @Test
    public void levelOfWhenEmptyInList() {
        List<Student> actual = StudentLevel.levelOf(List.of(), 100);
        List<Student> matcher = List.of();
        assertThat(actual, is(matcher));
    }

    @Test
    public void levelOfWhenOnlyNullInList() {
        List<Student> actual = StudentLevel.levelOf(
                Arrays.asList(
                        null,
                        null
                ),
                100
        );
        List<Student> matcher = List.of();
        assertThat(actual, is(matcher));
    }

    @Test
    public void levelOfWhenNoNullSortedInList() {
        List<Student> actual = StudentLevel.levelOf(
                Arrays.asList(
                        new Student(100, "surname 4"),
                        new Student(75, "surname 3"),
                        new Student(50, "surname 2"),
                        new Student(25, "surname 1")
                ),
                50
        );
        List<Student> matcher = List.of(
                new Student(100, "surname 4"),
                new Student(75, "surname 3")
        );
        assertThat(actual, is(matcher));
    }

    @Test
    public void levelOfWhenNoNullUnsortedInList() {
        List<Student> actual = StudentLevel.levelOf(
                Arrays.asList(
                        new Student(50, "surname 2"),
                        new Student(100, "surname 4"),
                        new Student(25, "surname 1"),
                        new Student(75, "surname 3")
                ),
                50
        );
        List<Student> matcher = List.of(
                new Student(100, "surname 4"),
                new Student(75, "surname 3")
        );
        assertThat(actual, is(matcher));
    }

    @Test
    public void levelOfWhenHasNullSortedInList() {
        List<Student> actual = StudentLevel.levelOf(
                Arrays.asList(
                        null,
                        new Student(100, "surname 4"),
                        null,
                        new Student(75, "surname 3"),
                        null,
                        new Student(50, "surname 2"),
                        null,
                        new Student(25, "surname 1"),
                        null
                ),
                50
        );
        List<Student> matcher = List.of(
                new Student(100, "surname 4"),
                new Student(75, "surname 3")
        );
        assertThat(actual, is(matcher));
    }

    @Test
    public void levelOfWhenHasNullUnsortedInList() {
        List<Student> actual = StudentLevel.levelOf(
                Arrays.asList(
                        null,
                        new Student(50, "surname 2"),
                        null,
                        new Student(100, "surname 4"),
                        null,
                        new Student(25, "surname 1"),
                        null,
                        new Student(75, "surname 3"),
                        null
                ),
                50
        );
        List<Student> matcher = List.of(
                new Student(100, "surname 4"),
                new Student(75, "surname 3")
        );
        assertThat(actual, is(matcher));
    }
}