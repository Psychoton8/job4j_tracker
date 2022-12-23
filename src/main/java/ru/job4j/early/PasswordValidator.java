package ru.job4j.early;

import static java.lang.Character.*;
import java.util.Arrays;
import java.util.List;

public class PasswordValidator {
    public static String validate(String password) {
        boolean isDigit = false, isUpperCase = false, isLowerCase = false, isFigure = false;
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }

        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }

        for (char symbol: password.toCharArray()) {
            if (isDigit(symbol)) {
                isDigit = true;
            }
            if (isUpperCase(symbol)) {
                isUpperCase = true;
            }
            if (isLowerCase(symbol)) {
                isLowerCase = true;
            }
            if (!isDigit(symbol) && !isLetter(symbol)) {
                isFigure = true;
            }
            if (isDigit && isUpperCase && isLowerCase && isFigure) {
                break;
            }
        }

        if (!isUpperCase) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }

        if (!isLowerCase) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }

        if (!isDigit) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }

        if (!isFigure) {
            throw new IllegalArgumentException("Password should contain at least one special symbol");
        }

        List<String> list = Arrays.asList("qwerty", "12345", "password", "admin", "user");
        for (String word : list) {
            if (password.toLowerCase().contains(word)) {
                throw new IllegalArgumentException("Password shouldn't contain substrings:"
                        + " qwerty, 12345, password, admin, user");
            }
        }
            return password;
    }
}
