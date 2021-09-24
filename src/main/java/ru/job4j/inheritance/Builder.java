package ru.job4j.inheritance;

public class Builder extends Engineer {
    private final String builderType;

    public Builder(
            String name,
            String surname,
            String education,
            String birthday,
            String organisation,
            String builderType
    ) {
        super(name, surname, education, birthday, organisation);
        this.builderType = builderType;
    }

    public String getBuilderType() {
        return builderType;
    }

    public Building build(Client client) {
        return null;
    }
}
