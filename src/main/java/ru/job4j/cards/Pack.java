package ru.job4j.cards;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Pack {
    public List<Card> getPack() {
        return Stream.of(Suit.values())
                .flatMap(
                        suit -> Stream.of(Value.values())
                                .map(value -> new Card(suit, value))
                )
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        new Pack().getPack().forEach(System.out::println);
    }
}
