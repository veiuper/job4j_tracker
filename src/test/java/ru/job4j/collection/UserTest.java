package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class UserTest {

    @Test
    public void whenCompareToNamesLessThat() {
        int rsl = new User("name 1", 2)
                .compareTo(
                        new User("name 2", 1)
                );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompareToNamesGreaterThat() {
        int rsl = new User("name 2", 1)
                .compareTo(
                        new User("name 1", 2)
                );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompareToAgesLessThat() {
        int rsl = new User("name 1", 1)
                .compareTo(
                        new User("name 1", 2)
                );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompareToAgesGreaterThat() {
        int rsl = new User("name 1", 2)
                .compareTo(
                        new User("name 1", 1)
                );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompareToEqualsThat() {
        int rsl = new User("name 1", 1)
                .compareTo(
                        new User("name 1", 1)
                );
        assertThat(rsl, equalTo(0));
    }
}