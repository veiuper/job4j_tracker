package ru.job4j.collection;

import java.util.ArrayList;
import java.util.List;

public class ConvertMatrix2List {
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] raw : array) {
            for (int value : raw) {
                list.add(value);
            }
        }
        return list;
    }
}
