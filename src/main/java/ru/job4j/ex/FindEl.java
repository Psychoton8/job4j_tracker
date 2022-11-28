package ru.job4j.ex;

import java.util.Objects;

public class FindEl {
    public static int indexOf(String[] value, String key) {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (Objects.equals(value[i], key)) {
                rsl = i;
            }
        }
        return rsl;
    }
   public static void load(String mess) throws ElementNotFoundException {
        if (mess == null) {
            throw new ElementNotFoundException("Element wasn't found");
        }
   }

    public static void main(String[] args) {
        try {
            load("wow");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }

}
