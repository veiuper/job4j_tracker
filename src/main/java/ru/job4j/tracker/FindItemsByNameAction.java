package ru.job4j.tracker;

import java.util.List;

public class FindItemsByNameAction implements UserAction {
    private final Output out;

    public FindItemsByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("==== Find items by name ====");
        String name = input.askStr("Enter name: ");
        List<Item> items = tracker.findByName(name);
        if (items.size() > 0) {
            for (Item curItem : items) {
                out.println(curItem);
            }
        } else {
            out.println("Заявки с именем '" + name + "' не найдены");
        }
        return true;
    }
}
