package ru.job4j.tracker;

import java.util.List;

public class ShowAllAction implements UserAction {
    private final Output out;

    public ShowAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all Items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("==== Show all items ====");
        List<Item> items = tracker.findAll();
        if (items.size() > 0) {
            for (Item curItem : items) {
                out.println(curItem);
            }
        } else {
            out.println("Хранилище не содержит заявок");
        }
        return true;
    }
}
