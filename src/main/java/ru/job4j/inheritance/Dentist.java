package ru.job4j.inheritance;

public class Dentist extends Doctor {
    private final String dentistType;

    public Dentist(String name, String surname, String education, String birthday, String hospital, String dentistType) {
        super(name, surname, education, birthday, hospital);
        this.dentistType = dentistType;
    }

    public String getDentistType() {
        return dentistType;
    }

    public Service provide(Patient patient) {
        return null;
    }
}
