package ru.job4j.bank.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamUsage {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(
                -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5
        );
        List<Integer> rsl = integers.stream().filter(i -> i > 0).collect(Collectors.toList());
        rsl.forEach(System.out::println);
    }
}
