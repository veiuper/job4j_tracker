package ru.job4j.inheritance;

public class Doctor extends Profession {
    private String hospital;

    public Doctor(String name) {
        super(name);
    }

    public String getHospital() {
        return hospital;
    }

    public Diagnosis heal(Patient patient) {
        return null;
    }
}
