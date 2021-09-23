package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        char separator = '.';
        return Integer.compare(
                Integer.parseInt(o1.substring(0, o1.indexOf(separator))),
                Integer.parseInt(o2.substring(0, o2.indexOf(separator)))
        );
    }
}
