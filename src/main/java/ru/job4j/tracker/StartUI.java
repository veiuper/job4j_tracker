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
                System.out.println("==== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
                System.out.println("Добавлена заявка " + item);
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
