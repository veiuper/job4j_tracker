package ru.job4j.bank.stream;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StudentLevel {
    public static List<Student> levelOf(List<Student> students, int bound) {
        return students
                .stream()
                .filter(Objects::nonNull)
                .sorted((o1, o2) -> Integer.compare(o2.getScope(), o1.getScope()))
                .takeWhile(student -> student.getScope() > bound)
                .collect(Collectors.toList());
    }
}
