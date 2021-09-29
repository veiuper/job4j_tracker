package ru.job4j.bank.stream;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Student {
    private final int scope;
    private final String surname;

    public Student(int scope, String surname) {
        this.scope = scope;
        this.surname = surname;
    }

    public int getScope() {
        return scope;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return scope == student.scope
                && Objects.equals(surname, student.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scope, surname);
    }

    public static Map<String, Student> listToMap(List<Student> list) {
        return list.stream()
                .distinct()
                .collect(
                        Collectors.toMap(Student::getSurname, Function.identity(), (o1, o2) -> o1)
                );
    }
}
