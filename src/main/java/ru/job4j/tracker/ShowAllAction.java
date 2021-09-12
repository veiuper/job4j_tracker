package ru.job4j.tracker;

public class ShowAllAction implements UserAction {
    @Override
    public String name() {
        return "Show all Items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("==== Show all items ====");
        Item[] items = tracker.findAll();
        if (items.length > 0) {
            for (Item curItem : items) {
                System.out.println(curItem);
            }
        } else {
            System.out.println("Хранилище не содержит заявок");
        }
        return true;
    }
}
