package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item item = new Item();
        LocalDateTime created = LocalDateTime.now();
        LocalDateTime itemDateTime = item.getCreated();
        System.out.println(item);
    }

}



