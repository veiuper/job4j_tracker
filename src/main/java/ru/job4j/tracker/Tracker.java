package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return (index != -1) ? items.get(index) : null;
    }

    public List<Item> findByName(String name) {
        List<Item> list = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(name)) {
                list.add(item);
            }
        }
        return list;
    }

    public List<Item> findAll() {
        return items;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            item.setId(id);
            items.set(index, item);
        }
        return rsl;
    }

    public boolean delete(int id) {
        boolean rsl = false;
        int index = indexOf(id);
        if (index != -1) {
            items.set(items.size() - 1, null);
            rsl = true;
        }
        return rsl;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i) != null && items.get(i).getId() == id) {
                rsl = i;
                break;
            }
        }
        return rsl;
    }
}