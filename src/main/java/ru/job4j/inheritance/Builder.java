package ru.job4j.inheritance;

public class Builder extends Engineer {
    private String builderType;

    public Builder(String name) {
        super(name);
    }

    public String getBuilderType() {
        return builderType;
    }

    public Building build(Client client) {
        return null;
    }
}
