package ru.job4j.bank.stream;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StudentTest {

    @Test
    public void listToMapWhenEmptyList() {
        Map<String, Student> actual = Student.listToMap(List.of());
        Map<String, Student> matcher = Map.of();
        assertThat(actual, is(matcher));
    }

    @Test
    public void listToMapWhenNoDuplicates() {
        Map<String, Student> actual = Student.listToMap(
                List.of(
                        new Student(0, "surname 2"),
                        new Student(0, "surname 1")
                )
        );
        Map<String, Student> matcher = Map.of(
                "surname 2", new Student(0, "surname 2"),
                "surname 1", new Student(0, "surname 1")
        );
        assertThat(actual, is(matcher));
    }

    @Test
    public void listToMapWhenInListDuplicates() {
        Map<String, Student> actual = Student.listToMap(
                List.of(
                        new Student(0, "surname 2"),
                        new Student(0, "surname 1"),
                        new Student(0, "surname 2"),
                        new Student(0, "surname 1")
                )
        );
        Map<String, Student> matcher = Map.of(
                "surname 2", new Student(0, "surname 2"),
                "surname 1", new Student(0, "surname 1")
        );
        assertThat(actual, is(matcher));
    }

    @Test
    public void listToMapWhenSurnameDuplicates() {
        Map<String, Student> actual = Student.listToMap(
                List.of(
                        new Student(1, "surname 2"),
                        new Student(0, "surname 1"),
                        new Student(0, "surname 2"),
                        new Student(0, "surname 1"),
                        new Student(1, "surname 1")
                )
        );
        Map<String, Student> matcher = Map.of(
                "surname 2", new Student(1, "surname 2"),
                "surname 1", new Student(0, "surname 1")
        );
        assertThat(actual, is(matcher));
    }
}