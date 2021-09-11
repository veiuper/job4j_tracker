package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        String name = "Fix PC";
        String[] answer = new String[]{name};
        Input input = new StubInput(answer);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item(name);
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void whenDeleteItem() {
        Item[] expected = new Item[]{};
        Tracker tracker = new Tracker();
        Item item = new Item();
        tracker.add(item);
        String[] answer = new String[]{String.valueOf(item.getId())};
        StartUI.deleteItem(new StubInput(answer), tracker);
        Item[] actual = tracker.findAll();
        assertThat(actual, is(expected));
    }
}