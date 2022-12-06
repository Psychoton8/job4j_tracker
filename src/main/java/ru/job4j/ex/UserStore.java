package ru.job4j.ex;

import java.util.Objects;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        boolean rsl = false;
        for (int i = 0; i < users.length; i++) {
            if (Objects.equals(users[i].getUsername(), login)) {
                rsl = true;
                return users[i];
            }
        }
        if (!rsl) {
            throw new UserNotFoundException("Name wasn't found");
        }
        return null;
    }

    public static boolean validate(User user) throws UserInvalidException {
        String name = user.getUsername();
        if (!user.isValid() || user.getUsername().length() < 3) {
            throw new UserInvalidException("User is invalid");
        }
        return false;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        try {
        User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            };
        } catch (UserInvalidException ea) {
            ea.printStackTrace();
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
    }
}

