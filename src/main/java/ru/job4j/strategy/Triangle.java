package ru.job4j.strategy;

public class Triangle implements Shape {
    @Override
    public String draw() {
        String ls = System.lineSeparator();
        return "   ^" + ls
                + " /   \\" + ls
                + "/_____\\";
    }

    public static void main(String[] args) {
        System.out.println(new Triangle().draw());
    }
}
