package ru.job4j.bank.lambda;

import java.util.Comparator;

public class LambdaUsage {
    public static void main(String[] args) {
        Comparator<String> desc = (s1, s2) -> {
            System.out.println("compare - " + s1 + " : " + s2);
            return Integer.compare(s2.length(), s1.length());
        };
    }
}
