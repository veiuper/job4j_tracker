package ru.job4j.ru.job4j;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println("The train rides on the rails.");
    }
}
