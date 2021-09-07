package ru.job4j.inheritance;

public class Surgeon extends Doctor {
    private String surgeonType;

    public Surgeon(String name) {
        super(name);
    }

    public String getType() {
        return surgeonType;
    }

    public Operation operate(Patient patient) {
        return null;
    }
}
