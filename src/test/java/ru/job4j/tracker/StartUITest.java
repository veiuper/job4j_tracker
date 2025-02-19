package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        String name = "Item name";
        List<String> answer = Arrays.asList("0", name, "1");
        Tracker tracker = new Tracker();
        Output out = new StubOutput();
        List<UserAction> actions = Arrays.asList(
                new CreateAction(out),
                new ExitAction(out)
        );
        new StartUI(out).init(new StubInput(answer), tracker, actions);
        Item actual = tracker.findAll().get(0);
        Item expected = new Item(name);
        assertThat(actual.getName(), is(expected.getName()));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        List<UserAction> actions = Arrays.asList(
                new DeleteAction(out),
                new ExitAction(out)
        );
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        List<String> answer = Arrays.asList("0", String.valueOf(item.getId()), "1");
        new StartUI(out).init(new StubInput(answer), tracker, actions);
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
        List<String> answer = Arrays.asList("0", String.valueOf(item.getId()), expected, "1");
        Output out = new StubOutput();
        List<UserAction> actions = Arrays.asList(
                new EditAction(out),
                new ExitAction(out)
        );
        new StartUI(out).init(new StubInput(answer), tracker, actions);
        Item actual = tracker.findById(item.getId());
        assertThat(actual.getName(), is(expected));
    }

    @Test
    public void whenExitAction() {
        Output out = new StubOutput();
        Input input = new StubInput(List.of("0"));
        Tracker tracker = new Tracker();
        List<UserAction> actions = List.of(new ExitAction(out));
        new StartUI(out).init(input, tracker, actions);
        String ls = System.lineSeparator();
        String expected = "Menu:" + ls
                + "0. Exit" + ls;
        assertThat(out.toString(), is(expected));
    }

    @Test
    public void whenShowAllActionWithoutItems() {
        StubOutput out = new StubOutput();
        List<String> answer = Arrays.asList("0", "1");
        List<UserAction> actions = Arrays.asList(
                new ShowAllAction(out),
                new ExitAction(out)
        );
        new StartUI(out).init(new StubInput(answer), new Tracker(), actions);
        String ls = System.lineSeparator();
        String expected = "Menu:" + ls
                + "0. Show all Items" + ls
                + "1. Exit" + ls
                + "==== Show all items ====" + ls
                + "Хранилище не содержит заявок" + ls
                + "Menu:" + ls
                + "0. Show all Items" + ls
                + "1. Exit" + ls;
        assertThat(out.toString(), is(expected));
    }

    @Test
    public void whenFindByNameActionWithoutItems() {
        String name = "";
        StubOutput out = new StubOutput();
        List<String> answer = Arrays.asList("0", name, "1");
        List<UserAction> actions = Arrays.asList(
                new FindItemsByNameAction(out),
                new ExitAction(out)
        );
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
        List<String> answer = Arrays.asList("0", id, "1");
        List<UserAction> actions = Arrays.asList(
                new FindItemByIdAction(out),
                new ExitAction(out)
        );
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
        List<String> answer = Arrays.asList("0", "1");
        List<UserAction> actions = Arrays.asList(
                new ShowAllAction(out),
                new ExitAction(out)
        );
        Tracker tracker = new Tracker();
        tracker.add(new Item("name 1"));
        tracker.add(new Item("name 2"));
        new StartUI(out).init(new StubInput(answer), tracker, actions);
        String ls = System.lineSeparator();
        String expected = "Menu:" + ls
                + "0. Show all Items" + ls
                + "1. Exit" + ls
                + "==== Show all items ====" + ls
                + tracker.findById(1).toString() + ls
                + tracker.findById(2).toString() + ls
                + "Menu:" + ls
                + "0. Show all Items" + ls
                + "1. Exit" + ls;
        assertThat(out.toString(), is(expected));
    }

    @Test
    public void whenFindByNameAction() {
        String name1 = "name 1";
        String name2 = "name 2";
        StubOutput out = new StubOutput();
        List<String> answer = Arrays.asList("0", name1, "1");
        List<UserAction> actions = Arrays.asList(
                new FindItemsByNameAction(out),
                new ExitAction(out)
        );
        Tracker tracker = new Tracker();
        tracker.add(new Item(name1));
        tracker.add(new Item(name2));
        new StartUI(out).init(new StubInput(answer), tracker, actions);
        String ls = System.lineSeparator();
        String expected = "Menu:" + ls
                + "0. Find items by name" + ls
                + "1. Exit" + ls
                + "==== Find items by name ====" + ls
                + tracker.findByName(name1).get(0).toString() + ls
                + "Menu:" + ls
                + "0. Find items by name" + ls
                + "1. Exit" + ls;
        assertThat(out.toString(), is(expected));
    }

    @Test
    public void whenFindByIdAction() {
        String id = "1";
        StubOutput out = new StubOutput();
        List<String> answer = Arrays.asList("0", id, "1");
        List<UserAction> actions = Arrays.asList(
                new FindItemByIdAction(out),
                new ExitAction(out)
        );
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

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        List<String> answer = Arrays.asList("-1", "0");
        List<UserAction> actions = List.of(new ExitAction(out));
        new StartUI(out).init(new StubInput(answer), new Tracker(), actions);
        String ls = System.lineSeparator();
        String expected = "Menu:" + ls
                + "0. Exit" + ls
                + "Wrong input, you can select: 0 .. 0" + ls
                + "Menu:" + ls
                + "0. Exit" + ls;
        assertThat(out.toString(), is(expected));
    }
}