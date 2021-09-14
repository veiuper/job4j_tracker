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
        UserAction[] actions = new UserAction[]{
                new DeleteAction(new StubOutput()),
                new ExitAction(new StubOutput())
        };
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        String[] answer = new String[]{"0", String.valueOf(item.getId()), "1"};
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
        String[] answer = new String[]{"0", String.valueOf(item.getId()), expected, "1"};
        UserAction[] actions = new UserAction[]{
                new EditAction(new StubOutput()),
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
        String ls = System.lineSeparator();
        String expected = "Menu:" + ls
                + "0. Exit" + ls;
        assertThat(out.toString(), is(expected));
    }

    @Test
    public void whenShowAllActionWithoutItems() {
        StubOutput out = new StubOutput();
        String[] answer = new String[]{"0", "1"};
        UserAction[] actions = new UserAction[]{
                new ShowAllAction(out),
                new ExitAction(out)
        };
        new StartUI(new StubOutput()).init(new StubInput(answer), new Tracker(), actions);
        String ls = System.lineSeparator();
        String expected = "==== Show all items ====" + ls
                + "Хранилище не содержит заявок" + ls;
        assertThat(out.toString(), is(expected));
    }

    @Test
    public void whenFindByNameActionWithoutItems() {
        String name = "";
        StubOutput out = new StubOutput();
        String[] answer = new String[]{"0", name, "1"};
        UserAction[] actions = new UserAction[]{
                new FindItemsByNameAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(new StubInput(answer), new Tracker(), actions);
        String ls = System.lineSeparator();
        String expected = "Menu:" + ls
                + "0. Find items by name" + ls
                + "1. Exit" + ls
                + "==== Find items by name ====" + ls
                + "Заявки с именем '" + name + "' не найдены" + ls
                + "Menu:" + ls
                + "0. Find items by name" + ls
                + "1. Exit" + ls;
        assertThat(out.toString(), is(expected));
    }

    @Test
    public void whenFindByIdActionWithoutItems() {
        String id = "1";
        StubOutput out = new StubOutput();
        String[] answer = new String[]{"0", id, "1"};
        UserAction[] actions = new UserAction[]{
                new FindItemByIdAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(new StubInput(answer), new Tracker(), actions);
        String ls = System.lineSeparator();
        String expected = "Menu:" + ls
                + "0. Find item by id" + ls
                + "1. Exit" + ls
                + "==== Find item by id ====" + ls
                + "Заявка с введенным id '" + id + "' не найдена" + ls
                + "Menu:" + ls
                + "0. Find item by id" + ls
                + "1. Exit" + ls;
        assertThat(out.toString(), is(expected));
    }

    @Test
    public void whenShowAllAction() {
        StubOutput out = new StubOutput();
        String[] answer = new String[]{"0", "1"};
        UserAction[] actions = new UserAction[]{
                new ShowAllAction(out),
                new ExitAction(out)
        };
        Tracker tracker = new Tracker();
        tracker.add(new Item("name 1"));
        tracker.add(new Item("name 2"));
        new StartUI(new StubOutput()).init(new StubInput(answer), tracker, actions);
        String ls = System.lineSeparator();
        String expected = "==== Show all items ====" + ls
                + tracker.findById(1).toString() + ls
                + tracker.findById(2).toString() + ls;
        assertThat(out.toString(), is(expected));
    }

    @Test
    public void whenFindByNameAction() {
        String name1 = "name 1";
        String name2 = "name 2";
        StubOutput out = new StubOutput();
        String[] answer = new String[]{"0", name1, "1"};
        UserAction[] actions = new UserAction[]{
                new FindItemsByNameAction(out),
                new ExitAction(out)
        };
        Tracker tracker = new Tracker();
        tracker.add(new Item(name1));
        tracker.add(new Item(name2));
        new StartUI(out).init(new StubInput(answer), tracker, actions);
        String ls = System.lineSeparator();
        String expected = "Menu:" + ls
                + "0. Find items by name" + ls
                + "1. Exit" + ls
                + "==== Find items by name ====" + ls
                + tracker.findByName(name1)[0].toString() + ls
                + "Menu:" + ls
                + "0. Find items by name" + ls
                + "1. Exit" + ls;
        assertThat(out.toString(), is(expected));
    }

    @Test
    public void whenFindByIdAction() {
        String id = "1";
        StubOutput out = new StubOutput();
        String[] answer = new String[]{"0", id, "1"};
        UserAction[] actions = new UserAction[]{
                new FindItemByIdAction(out),
                new ExitAction(out)
        };
        Tracker tracker = new Tracker();
        tracker.add(new Item());
        tracker.add(new Item());
        new StartUI(out).init(new StubInput(answer), tracker, actions);
        String ls = System.lineSeparator();
        String expected = "Menu:" + ls
                + "0. Find item by id" + ls
                + "1. Exit" + ls
                + "==== Find item by id ====" + ls
                + tracker.findById(Integer.parseInt(id)).toString() + ls
                + "Menu:" + ls
                + "0. Find item by id" + ls
                + "1. Exit" + ls;
        assertThat(out.toString(), is(expected));
    }
}