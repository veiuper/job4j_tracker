package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            showMenu();
            System.out.print("Select: ");
            int select = Integer.parseInt(scanner.nextLine());
            if (select == 6) {
                run = false;
            } else if (select == 0) {
                System.out.println("==== Create a new item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
                System.out.println("Добавлена заявка " + item);
            } else if (select == 1) {
                System.out.println("==== Show all items ====");
                Item[] items = tracker.findAll();
                if (items.length > 0) {
                    for (Item curItem : items) {
                        System.out.println(curItem);
                    }
                } else {
                    System.out.println("Хранилище не содержит заявок");
                }
            } else if (select == 2) {
                System.out.println("==== Edit item ====");
                System.out.print("Enter id: ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                boolean rsl = tracker.replace(id, item);
                if (rsl) {
                    System.out.println("Заявка успешно изменена");
                } else {
                    System.out.println("Не удалось изменить заявку");
                }
            } else if (select == 3) {
                System.out.println("==== Delete item ====");
                System.out.print("Enter id: ");
                int id = Integer.parseInt(scanner.nextLine());
                boolean rsl = tracker.delete(id);
                if (rsl) {
                    System.out.println("Заявка удалена успешно");
                } else {
                    System.out.println("Ошибка удаления заявки");
                }
            } else if (select == 4) {
                System.out.println("==== Find item by id ====");
                System.out.print("Enter id: ");
                int id = Integer.parseInt(scanner.nextLine());
                Item item = tracker.findById(id);
                if (item != null) {
                    System.out.println(item);
                } else {
                    System.out.println("Заявка с введенным id '" + id + "' не найдена");
                }
            } else if (select == 5) {
                System.out.println("==== Find items by name ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item[] items = tracker.findByName(name);
                if (items.length > 0) {
                    for (Item curItem : items) {
                        System.out.println(curItem);
                    }
                } else {
                    System.out.println("Заявки с именем '" + name + "' не найдены");
                }
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
        new StartUI().init(new Scanner(System.in), new Tracker());
    }
}
