package ru.job4j.strategy;

public class Painter {
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }

    public static void main(String[] args) {
        Painter context = new Painter();
        context.draw(new Triangle());
        context.draw(new Square());
    }
}
