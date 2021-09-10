package ru.job4j.oop;

public class HierarchyUsage {
    public static void main(String[] args) {
        Car car = new Car();
        Transport transport = car;
        Object object = transport;
        Object objectCar = new Car();
        Car carFromObject = (Car) objectCar;
        Object bicycle = new Bicycle();
        //Car cb = (Car) bicycle;
    }
}
