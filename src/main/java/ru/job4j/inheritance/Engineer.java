package ru.job4j.inheritance;

public class Engineer extends Profession {
    private final String organisation;

    public Engineer(String name,
                    String surname,
                    String education,
                    String birthday,
                    String organisation) {
        super(name, surname, education, birthday);
        this.organisation = organisation;
    }

    public String getOrganisation() {
        return organisation;
    }

    public Project make(Client client) {
        return null;
    }
}
