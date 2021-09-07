package ru.job4j.inheritance;

public class Profession {
    private final String name;
    private String surname;
    private String education;
    private String birthday;

    public Profession(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEducation() {
        return education;
    }

    public String getBirthday() {
        return birthday;
    }
}
