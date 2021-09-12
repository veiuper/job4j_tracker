package ru.job4j.strategy;

public class Square implements Shape {
    @Override
    public String draw() {
        String ls = System.lineSeparator();
        return " _____" + ls
                + "|     |" + ls
                + "|_____|" + ls;
    }

    public static void main(String[] args) {
        System.out.println(new Square().draw());
    }
}
