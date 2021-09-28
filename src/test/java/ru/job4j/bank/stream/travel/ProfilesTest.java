package ru.job4j.bank.stream.travel;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ProfilesTest {
    @Test
    public void whenEmptyListProfiles() {
        List<Address> matcher = List.of();
        List<Address> actual = new Profiles().collect(List.of());
        assertThat(actual, is(matcher));
    }

    @Test
    public void whenNotEmptyListProfiles() {
        List<Profile> in = List.of(
                new Profile(new Address("city 1", "street 1", 1, 1)),
                new Profile(new Address("city 2", "street 2", 2, 2))
        );
        List<Address> matcher = List.of(
                new Address("city 1", "street 1", 1, 1),
                new Address("city 2", "street 2", 2, 2)
        );
        List<Address> actual = new Profiles().collect(in);
        assertThat(actual, is(matcher));
    }

    @Test
    public void whenNotEmptyListProfilesAndDuplicatesAddress() {
        List<Profile> in = List.of(
                new Profile(new Address("city 1", "street 1", 1, 1)),
                new Profile(new Address("city 2", "street 2", 2, 2)),
                new Profile(new Address("city 1", "street 1", 1, 1))
        );
        List<Address> matcher = List.of(
                new Address("city 1", "street 1", 1, 1),
                new Address("city 2", "street 2", 2, 2),
                new Address("city 1", "street 1", 1, 1)
        );
        List<Address> actual = new Profiles().collect(in);
        assertThat(actual, is(matcher));
    }
}