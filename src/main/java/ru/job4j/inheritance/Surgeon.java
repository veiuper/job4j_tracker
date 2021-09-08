package ru.job4j.inheritance;

public class Surgeon extends Doctor {
    private String surgeonType;

    public String getType() {
        return surgeonType;
    }

    public Operation operate(Patient patient) {
        return null;
    }
}
