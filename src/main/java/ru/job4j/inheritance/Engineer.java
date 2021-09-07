package ru.job4j.inheritance;

public class Engineer extends Profession {
    private String organisation;

    public Engineer(String name) {
        super(name);
    }

    public String getOrganisation() {
        return organisation;
    }

    public Project make(Client client) {
        return null;
    }
}
