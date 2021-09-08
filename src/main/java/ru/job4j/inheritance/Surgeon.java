package ru.job4j.inheritance;

public class Surgeon extends Doctor {
    private final String surgeonType;

    public Surgeon(String name, String surname, String education, String birthday, String hospital, String surgeonType) {
        super(name, surname, education, birthday, hospital);
        this.surgeonType = surgeonType;
    }

    public String getType() {
        return surgeonType;
    }

    public Operation operate(Patient patient) {
        return null;
    }
}
