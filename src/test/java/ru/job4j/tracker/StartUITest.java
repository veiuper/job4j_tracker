package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        String name = "Item name";
        String[] answer = new String[]{"0", name, "1"};
        Tracker tracker = new Tracker();
        UserAction[] actions = new UserAction[]{
                new CreateAction(new StubOutput()),
                new ExitAction(new StubOutput())
        };
        new StartUI(new StubOutput()).init(new StubInput(answer), tracker, actions);
        Item actual = tracker.findAll()[0];
        Item expected = new Item(name);
        assertThat(actual.getName(), is(expected.getName()));
    }

    @Test
    public void whenDeleteItem() {
        String[] answer = new String[]{"0", "1", "1"};
        UserAction[] actions = new UserAction[]{
                new DeleteAction(),
                new ExitAction(new StubOutput())
        };
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        new StartUI(new StubOutput()).init(new StubInput(answer), tracker, actions);
        Item actual = tracker.findById(item.getId());
        assertThat(actual, is(nullValue()));
    }

    @Test
    public void whenEditItem() {
        String name = "Edit item";
        Item item = new Item(name);
        Tracker tracker = new Tracker();
        tracker.add(item);
        String expected = "New item name";
        String[] answer = new String[]{"0", "1", expected, "1"};
        UserAction[] actions = new UserAction[]{
                new EditAction(),
                new ExitAction(new StubOutput())
        };
        new StartUI(new StubOutput()).init(new StubInput(answer), tracker, actions);
        Item actual = tracker.findById(item.getId());
        assertThat(actual.getName(), is(expected));
    }

    @Test
    public void whenExitAction() {
        Output out = new StubOutput();
        Input input = new StubInput(new String[]{"0"});
        Tracker tracker = new Tracker();
        UserAction[] actions = new UserAction[]{new ExitAction(new StubOutput())};
        new StartUI(out).init(input, tracker, actions);
        String expected = "Menu:" + System.lineSeparator()
                + "0. Exit" + System.lineSeparator();
        assertThat(out.toString(), is(expected));
    }
}