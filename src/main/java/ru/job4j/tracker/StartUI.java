package ru.job4j.tracker;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = input.askInt("Select: ");
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        out.println("Menu:");
        for (int i = 0; i < actions.length; i++) {
            out.println(i + ". " + actions[i].name());
        }
    }

    public static void main(String[] args) {
        UserAction[] actions = new UserAction[]{
                new CreateAction(new ConsoleOutput()),
                new ShowAllAction(),
                new EditAction(),
                new DeleteAction(),
                new FindItemByIdAction(),
                new FindItemsByNameAction(),
                new ExitAction(new ConsoleOutput())
        };
        new StartUI(new ConsoleOutput()).init(new ConsoleInput(), new Tracker(), actions);
    }
}
