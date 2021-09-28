package ru.job4j.bank.stream.travel;

public class Profile {
    private final Address address;

    public Profile(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }
}
