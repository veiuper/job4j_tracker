package ru.job4j.inheritance;

public class Dentist extends Doctor {
    private String dentistType;

    public Dentist(String name) {
        super(name);
    }

    public String getDentistType() {
        return dentistType;
    }

    public Service provide(Patient patient) {
        return null;
    }
}
