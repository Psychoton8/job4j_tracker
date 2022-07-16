package ru.job4j.inheritance;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UsagePackageDate {
    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("Today is: " + currentDate);
        System.out.println("Today is: " + currentTime);
        System.out.println("Today is: " + currentDateTime);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
        String currentDateTimeFormat = currentDateTime.format(formatter);
        System.out.println(currentDateTimeFormat);

        DateTimeFormatter form = DateTimeFormatter.ofPattern("HH:mm:ss");
        String currentTimeFormat = currentTime.format(form);
        System.out.println(currentTimeFormat);
    }
}
