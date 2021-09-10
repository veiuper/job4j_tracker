package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Drive");
    }

    @Override
    public void passengers(int count) {
        System.out.println("Count passengers: " + count);
    }

    @Override
    public double refuel(double count) {
        return count * 45.45;
    }

    public static void main(String[] args) {
        Bus bus = new Bus();
        bus.drive();
        bus.passengers(3);
        System.out.println(bus.refuel(10.5));
    }
}
