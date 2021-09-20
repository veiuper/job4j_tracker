package ru.job4j.collection;

import java.util.HashSet;

public class UniqueText {
    public static boolean isEquals(String originalText, String duplicateText) {
        boolean rsl = true;
        String[] origin = originalText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
        for (String value : origin) {
            check.add(value);
        }
        for (String value : text) {
            if (!check.contains(value)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}
