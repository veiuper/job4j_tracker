package ru.job4j.inheritance;

public class Programmer extends Engineer {
    private String language;

    public Programmer(String name) {
        super(name);
    }

    public String getLanguage() {
        return language;
    }

    public Programm write(Client client) {
        return null;
    }
}
