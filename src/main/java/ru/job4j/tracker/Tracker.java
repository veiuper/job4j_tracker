package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int i = 0; i < size; i++) {
            Item item = items[i];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findByName(String name) {
        Item[] array = new Item[size];
        int count = 0;
        for (Item curItem : items) {
            if (curItem != null && curItem.getName().equals(name)) {
                array[count++] = curItem;
            }
        }
        return Arrays.copyOf(array, count);
    }

    public Item[] findAll() {
        Item[] array = new Item[size];
        int count = 0;
        for (Item curItem : items) {
            if (curItem != null) {
                array[count++] = curItem;
            }
        }
        return Arrays.copyOf(array, count);
    }
}