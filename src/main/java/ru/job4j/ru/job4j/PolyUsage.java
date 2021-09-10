package ru.job4j.ru.job4j;

public class PolyUsage {
    public static void main(String[] args) {
        Vehicle bus1 = new Bus();
        Vehicle bus2 = new Bus();
        Vehicle plane1 = new Plane();
        Vehicle plane2 = new Plane();
        Vehicle train1 = new Train();
        Vehicle train2 = new Train();
        Vehicle[] transports = new Vehicle[]{bus1, bus2, plane1, plane2, train1, train2};
        for (Vehicle curVehicle : transports) {
            curVehicle.move();
        }
    }
}
