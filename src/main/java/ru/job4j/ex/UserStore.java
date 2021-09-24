package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        for (User curUser : users) {
            if (login.equals(curUser.getUsername())) {
                return curUser;
            }
        }
        throw new UserNotFoundException("The user '" + login + "' was not found");
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() || user.getUsername().length() < 3) {
            throw new UserInvalidException(
                    "The user '" + user.getUsername() + "' did not pass verification"
            );
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Valeriy Osipov", true)
        };
        try {
            User user = findUser(users, "Valeriy Osipov");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException ui) {
            ui.printStackTrace();
        } catch (UserNotFoundException unf) {
            unf.printStackTrace();
        }
    }
}
