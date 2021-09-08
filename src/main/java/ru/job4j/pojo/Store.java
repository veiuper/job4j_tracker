package ru.job4j.pojo;

public class Store {
    public static void main(String[] args) {
        Product milk = new Product("Milk", 10);
        Product bread = new Product("Bread", 4);
        Product egg = new Product("Egg", 19);
        Product[] products = new Product[3];
        products[0] = milk;
        products[1] = bread;
        products[2] = egg;
        for (Product curProduct : products) {
            System.out.println(curProduct.getName() + " - " + curProduct.getCount());
        }
        Product oil = new Product("Oil", 11);
        products[0] = oil;
        for (Product curProduct : products) {
            System.out.println(curProduct.getName() + " - " + curProduct.getCount());
        }
        System.out.println("Shown only product.count > 10");
        for (Product curProduct : products) {
            if (curProduct.getCount() > 10) {
                System.out.println(curProduct.getName() + " - " + curProduct.getCount());
            }
        }
    }
}
