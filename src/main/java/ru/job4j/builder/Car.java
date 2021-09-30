package ru.job4j.builder;

public class Car {
    private String brand;
    private String classCar;
    private String bodywork;
    private Integer length;
    private Integer width;
    private Integer height;
    private Integer weight;
    private String engine;
    private Integer power;

    @Override
    public String toString() {
        return "Car{"
                + "brand='" + brand + '\''
                + ", classCar='" + classCar + '\''
                + ", bodywork='" + bodywork + '\''
                + ", length=" + length
                + ", width=" + width
                + ", height=" + height
                + ", weight=" + weight
                + ", engine='" + engine + '\''
                + ", power=" + power
                + '}';
    }

    static class Builder {
        private String brand;
        private String classCar;
        private String bodywork;
        private Integer length;
        private Integer width;
        private Integer height;
        private Integer weight;
        private String engine;
        private Integer power;

        Builder buildBrand(String brand) {
            this.brand = brand;
            return this;
        }

        Builder buildClassCar(String classCar) {
            this.classCar = classCar;
            return this;
        }

        Builder buildBodywork(String bodywork) {
            this.bodywork = bodywork;
            return this;
        }

        Builder buildLength(Integer length) {
            this.length = length;
            return this;
        }

        Builder buildWidth(Integer width) {
            this.width = width;
            return this;
        }

        Builder buildHeight(Integer height) {
            this.height = height;
            return this;
        }

        Builder buildWeight(Integer weight) {
            this.weight = weight;
            return this;
        }

        Builder buildEngine(String engine) {
            this.engine = engine;
            return this;
        }

        Builder buildPower(Integer power) {
            this.power = power;
            return this;
        }

        Car build() {
            Car car = new Car();
            car.brand = brand;
            car.classCar = classCar;
            car.bodywork = bodywork;
            car.length = length;
            car.width = width;
            car.height = height;
            car.weight = weight;
            car.engine = engine;
            car.power = power;
            return car;
        }
    }

    public static void main(String[] args) {
        Car car = new Builder()
                .buildBrand("BMW 318i (E30)")
                .buildClassCar("A")
                .buildBodywork("sedan")
                .buildLength(4320)
                .buildWidth(1640)
                .buildHeight(1380)
                .buildWeight(1195)
                .buildEngine("L4")
                .buildPower(133)
                .build();
        System.out.println(car);
    }
}
