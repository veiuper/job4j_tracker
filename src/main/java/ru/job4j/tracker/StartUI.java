package ru.job4j.tracker;

public class StartUI {

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("==== Create a new item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        System.out.println("Добавлена заявка " + item);
    }

    public static void showAllItems(Tracker tracker) {
        System.out.println("==== Show all items ====");
        Item[] items = tracker.findAll();
        if (items.length > 0) {
            for (Item curItem : items) {
                System.out.println(curItem);
            }
        } else {
            System.out.println("Хранилище не содержит заявок");
        }
    }

    public static void editItem(Input input, Tracker tracker) {
        System.out.println("==== Edit item ====");
        int id = input.askInt("Enter id: ");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        boolean rsl = tracker.replace(id, item);
        if (rsl) {
            System.out.println("Заявка успешно изменена");
        } else {
            System.out.println("Не удалось изменить заявку");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("==== Delete item ====");
        int id = input.askInt("Enter id: ");
        boolean rsl = tracker.delete(id);
        if (rsl) {
            System.out.println("Заявка удалена успешно");
        } else {
            System.out.println("Ошибка удаления заявки");
        }
    }

    public static void findItemById(Input input, Tracker tracker) {
        System.out.println("==== Find item by id ====");
        int id = input.askInt("Enter id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("Заявка с введенным id '" + id + "' не найдена");
        }
    }

    public static void findItemsByName(Input input, Tracker tracker) {
        System.out.println("==== Find items by name ====");
        String name = input.askStr("Enter name: ");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            for (Item curItem : items) {
                System.out.println(curItem);
            }
        } else {
            System.out.println("Заявки с именем '" + name + "' не найдены");
        }
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            showMenu();
            int select = input.askInt("Select: ");
            if (select == 6) {
                run = false;
            } else if (select == 0) {
                createItem(input, tracker);
            } else if (select == 1) {
                showAllItems(tracker);
            } else if (select == 2) {
                editItem(input, tracker);
            } else if (select == 3) {
                deleteItem(input, tracker);
            } else if (select == 4) {
                findItemById(input, tracker);
            } else if (select == 5) {
                findItemsByName(input, tracker);
            } else {
                System.out.println("Пользователь выбрал: " + select);
            }
        }
    }

    private void showMenu() {
        String[] menu = {
                "Add new item",
                "Show all Items",
                "Edit Item",
                "Deleted item",
                "Find item by id",
                "Find items by name",
                "Exit program"
        };
        System.out.println("Menu:");
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i + ". " + menu[i]);
        }
    }

    public static void main(String[] args) {
        new StartUI().init(new ConsoleInput(), new Tracker());
    }
}
