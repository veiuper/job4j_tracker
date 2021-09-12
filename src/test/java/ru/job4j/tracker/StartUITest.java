package ru.job4j.tracker;

public class StartUITest {
//    @Test
//    public void whenCreateItem() {
//        String name = "Fix PC";
//        String[] answer = new String[]{name};
//        Tracker tracker = new Tracker();
//        new CreateAction().execute(new StubInput(answer), tracker);
//        Item created = tracker.findAll()[0];
//        Item expected = new Item(name);
//        assertThat(created.getName(), is(expected.getName()));
//    }
//
//    @Test
//    public void whenDeleteItem() {
//        Tracker tracker = new Tracker();
//        Item item = new Item();
//        tracker.add(item);
//        String[] answer = new String[]{String.valueOf(item.getId())};
//        new DeleteAction().execute(new StubInput(answer), tracker);
//        Item actual = tracker.findById(item.getId());
//        assertThat(actual, is(nullValue()));
//    }
//
//    @Test
//    public void whenEditItem() {
//        String expected = "replaced item";
//        Tracker tracker = new Tracker();
//        Item item = new Item();
//        tracker.add(item);
//        String[] answer = new String[]{String.valueOf(item.getId()), expected};
//        new EditAction().execute(new StubInput(answer), tracker);
//        Item actual = tracker.findById(item.getId());
//        assertThat(actual.getName(), is(expected));
//    }
}