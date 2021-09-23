package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class JobTest {

    @Test
    public void sortJobAscByNameAscByPriority() {
        Comparator<Job> comparator = new JobAscByName()
                .thenComparing(new JobAscByPriority());
        Job[] matcher = {
                new Job("name 1", 0),
                new Job("name 1", 1),
                new Job("name 2", 0),
                new Job("name 2", 1),
                new Job("name 3", 0),
                new Job("name 3", 1)
        };
        Job[] actual = {
                matcher[5],
                matcher[2],
                matcher[3],
                matcher[1],
                matcher[4],
                matcher[0]
        };
        Arrays.sort(actual, comparator);
        assertThat(actual, is(matcher));
    }

    @Test
    public void sortJobDescByNameDescByPriority() {
        Comparator<Job> comparator = new JobDescByName()
                .thenComparing(new JobDescByPriority());
        Job[] matcher = {
                new Job("name 3", 1),
                new Job("name 3", 0),
                new Job("name 2", 1),
                new Job("name 2", 0),
                new Job("name 1", 1),
                new Job("name 1", 0)
        };
        Job[] actual = {
                matcher[5],
                matcher[2],
                matcher[3],
                matcher[1],
                matcher[4],
                matcher[0]
        };
        Arrays.sort(actual, comparator);
        assertThat(actual, is(matcher));
    }

    @Test
    public void sortJobAscByNameDescByPriority() {
        Comparator<Job> comparator = new JobAscByName()
                .thenComparing(new JobDescByPriority());
        Job[] matcher = {
                new Job("name 1", 1),
                new Job("name 1", 0),
                new Job("name 2", 1),
                new Job("name 2", 0),
                new Job("name 3", 1),
                new Job("name 3", 0)
        };
        Job[] actual = {
                matcher[5],
                matcher[2],
                matcher[3],
                matcher[1],
                matcher[4],
                matcher[0]
        };
        Arrays.sort(actual, comparator);
        assertThat(actual, is(matcher));
    }

    @Test
    public void sortJobDescByNameAscByPriority() {
        Comparator<Job> comparator = new JobDescByName()
                .thenComparing(new JobAscByPriority());
        Job[] matcher = {
                new Job("name 3", 0),
                new Job("name 3", 1),
                new Job("name 2", 0),
                new Job("name 2", 1),
                new Job("name 1", 0),
                new Job("name 1", 1)
        };
        Job[] actual = {
                matcher[5],
                matcher[2],
                matcher[3],
                matcher[1],
                matcher[4],
                matcher[0]
        };
        Arrays.sort(actual, comparator);
        assertThat(actual, is(matcher));
    }

    @Test
    public void sortJobAscByPriorityAscByName() {
        Comparator<Job> comparator = new JobAscByPriority()
                .thenComparing(new JobAscByName());
        Job[] matcher = {
                new Job("name 1", 0),
                new Job("name 2", 0),
                new Job("name 3", 0),
                new Job("name 1", 1),
                new Job("name 2", 1),
                new Job("name 3", 1)
        };
        Job[] actual = {
                matcher[5],
                matcher[2],
                matcher[3],
                matcher[1],
                matcher[4],
                matcher[0]
        };
        Arrays.sort(actual, comparator);
        assertThat(actual, is(matcher));
    }

    @Test
    public void sortJobDescByPriorityDescByName() {
        Comparator<Job> comparator = new JobDescByPriority()
                .thenComparing(new JobDescByName());
        Job[] matcher = {
                new Job("name 3", 1),
                new Job("name 2", 1),
                new Job("name 1", 1),
                new Job("name 3", 0),
                new Job("name 2", 0),
                new Job("name 1", 0)
        };
        Job[] actual = {
                matcher[5],
                matcher[2],
                matcher[3],
                matcher[1],
                matcher[4],
                matcher[0]
        };
        Arrays.sort(actual, comparator);
        assertThat(actual, is(matcher));
    }

    @Test
    public void sortJobAscByPriorityDescByName() {
        Comparator<Job> comparator = new JobAscByPriority()
                .thenComparing(new JobDescByName());
        Job[] matcher = {
                new Job("name 3", 0),
                new Job("name 2", 0),
                new Job("name 1", 0),
                new Job("name 3", 1),
                new Job("name 2", 1),
                new Job("name 1", 1)
        };
        Job[] actual = {
                matcher[5],
                matcher[2],
                matcher[3],
                matcher[1],
                matcher[4],
                matcher[0]
        };
        Arrays.sort(actual, comparator);
        assertThat(actual, is(matcher));
    }

    @Test
    public void sortJobDescByPriorityAscByName() {
        Comparator<Job> comparator = new JobDescByPriority()
                .thenComparing(new JobAscByName());
        Job[] matcher = {
                new Job("name 1", 1),
                new Job("name 2", 1),
                new Job("name 3", 1),
                new Job("name 1", 0),
                new Job("name 2", 0),
                new Job("name 3", 0)
        };
        Job[] actual = {
                matcher[5],
                matcher[2],
                matcher[3],
                matcher[1],
                matcher[4],
                matcher[0]
        };
        Arrays.sort(actual, comparator);
        assertThat(actual, is(matcher));
    }
}