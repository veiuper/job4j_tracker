package ru.job4j.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class FunctionValuesInRange {
    public static List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> rsl = new ArrayList<>(end - start);
        Consumer<Double> consumerAdd = rsl::add;
        for (int i = start; i < end; i++) {
            consumerAdd.accept(func.apply((double) i));
        }
        return rsl;
    }
}
