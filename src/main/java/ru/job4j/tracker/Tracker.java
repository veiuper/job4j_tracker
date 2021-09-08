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
        int index = indexOf(id);
        return (index != -1) ? items[index] : null;
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

    public boolean replace(int id, Item item) {
        boolean rsl = false;
        int index = indexOf(id);
        if (index != -1) {
            item.setId(id);
            items[index] = item;
            rsl = true;
        }
        return rsl;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int i = 0; i < size; i++) {
            if (items[i] != null && items[i].getId() == id) {
                rsl = i;
                break;
            }
        }
        return rsl;
    }
}