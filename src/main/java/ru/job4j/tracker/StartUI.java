package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI {
    private LocalDateTime created = LocalDateTime.now();
    Item item = new Item();
    LocalDateTime itemDateTime = item.getCreated();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
    String currentDateTimeFormat = created.format(formatter);
}



